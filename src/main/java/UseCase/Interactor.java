package UseCase;

import DataStructures.InPutData;
import DataStructures.OutPutData;
import Entities.Comment;
import Entities.CommentList;

import java.io.IOException;
import java.util.ArrayList;

public class Interactor implements InputBoundary  {
    private final OutputBoundary outputBoundary;
    private static CommentList commentList = new CommentList();
    private final Gateway gateway ;


    /**
     * @param outputBoundary outputBoundary
     * @param gateway gateway
     * @throws IOException import fail
     * @throws ClassNotFoundException class no found
     * Constructor for Interactor takes an output boundary and a gateway.
     * Import data from the database.
     *
     */
    public Interactor(OutputBoundary outputBoundary,Gateway gateway) throws IOException, ClassNotFoundException {
        this.outputBoundary = outputBoundary;
        this.gateway = gateway;
        // import file and set as iterable commentList
        try{
            commentList = gateway.importComment();

        } catch (IOException e ){
            commentList = new CommentList();
            this.outputBoundary.outputMessage("Importation failed");
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
        this.outputBoundary.showComments(new OutPutData(listConvert(commentList)));
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
    public void addComment(InPutData inPutData) throws InvalidInputException, IOException {

        if (checkInput(inPutData.getComments())) {
            Comment commentClass = new Comment(inPutData.getComments());
            commentList.addComment(commentClass);
            try {
                //save new comments
                gateway.saveComment(commentList);
            } catch (IOException e) {
                throw new IOException();
            }
        }else {
            throw new InvalidInputException();
            
        }
        

    }



    @Override
    public void editComment(int commentNum, String s)  {
//        if(checkInput(s)){
//            for( Comment c : commentList) {
//                if (c.getCommentNum() == commentNum) {
//                    try {
//                        //save new comments
//                        gateway.saveComment(commentList);
//                        c.setComment(s);
//                        this.outputBoundary.outputMessage("Comment Changed");
//
//                    } catch (IOException e) {
//                        this.outputBoundary.outputMessage("edit and save new comment to file failed");
//                    }
//                }
//            }
//        }
//        else {
//            throw new CommentNotInListException();
//        }

    }


    /**
     * @param s
     *Send message to output boundary to present.
     */
    @Override
    public void outputMessage(String s){
        this.outputBoundary.outputMessage(s);
    }
}
