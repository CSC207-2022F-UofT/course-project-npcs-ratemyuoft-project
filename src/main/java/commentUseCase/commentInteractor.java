package commentUseCase;

import commentDataStructures.commentInPutData;
import commentDataStructures.commentOutPutData;
import entities.Comment;
import entities.CommentList;

import java.io.IOException;
import java.util.ArrayList;

public class commentInteractor implements commentInputBoundary {
    private final commentOutputBoundary commentOutputBoundary;
    private static CommentList commentList = new CommentList();
    private final commentGateway commentGateway;


    /**
     * @param commentOutputBoundary outputBoundary
     * @param commentGateway gateway
     * @throws IOException import fail
     * @throws ClassNotFoundException class no found
     * Constructor for Interactor takes an output boundary and a gateway.
     * Import data from the database.
     *
     */
    public commentInteractor(commentOutputBoundary commentOutputBoundary, commentGateway commentGateway) throws IOException, ClassNotFoundException {
        this.commentOutputBoundary = commentOutputBoundary;
        this.commentGateway = commentGateway;
        // import file and set as iterable commentList
        try{
            commentList = commentGateway.importComment();

        } catch (IOException e ){
            commentList = new CommentList();
            this.commentOutputBoundary.outputMessage("Importation failed");
        }


    }


    /**
     * helper function for add Comment
     * @param comment comment
     * @return boolean
     */
    private boolean checkInput(String comment) {
        int count = comment.length();
        char[] chars = comment.toCharArray();
        int i = 0;
        while (chars[i] == ' ') {
            i ++;
            if (i == count){
                return false;
            }
        }
        return count <= 1500;
    }


    /**convert CommentList to List
     * @param commentList commentList
     * @return array list
     */
    private ArrayList<String> listConvert(CommentList commentList){
        ArrayList<String> listOfComment = new ArrayList<>();

        for(Comment c : commentList){
            listOfComment.add(c.getComment());
        }
        return listOfComment;
    }



    /**
     * Send CommentList to Output Boundary
     */
    @Override
    public void showComments()  {
        this.commentOutputBoundary.showComments(new commentOutPutData(listConvert(commentList)));
    }

    /**
     *
     * @throws InvalidInputException invalid input
     * @throws IOException
     * Check for valid input and turn in to a new Common class send to database
     * if input not valid throw exception.
     * If something wrong with importing data it throws exception.
     */

    @Override
    public void addComment(commentInPutData commentInPutData) throws InvalidInputException, IOException {

        if (checkInput(commentInPutData.getComments())) {
            Comment commentClass = new Comment(commentInPutData.getComments());
            commentList.addComment(commentClass);
            try {
                //save new comments
                commentGateway.saveComment(commentList);
                // this error will rise if the file has problems
            } catch (IOException e) {
                throw new IOException();
            }
        }else {
            throw new InvalidInputException();
            
        }
        

    }








    /**
     * @param s
     *Send message to output boundary to present.
     */
    @Override
    public void outputMessage(String s){
        this.commentOutputBoundary.outputMessage(s);
    }
}
