package UseCase;

import Entities.Comment;
import Entities.CommentList;

import java.io.IOException;

public class Interactor implements InputBoundary  {
    private final OutputBoundary outputBoundary;
    private static CommentList commentList = new CommentList();
    private final Gateway gateway ;




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



    // helper function for add Comment
    public boolean checkInput(String comment) {
        int count = comment.length();
        if (count <= 1500 && count > 0){
            return true;
        }
        return false;
    }


    /**
     * Send CommentList to Output Boundary
     *if something is wrong when import Commentlist from database
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public void showComments() throws IOException, ClassNotFoundException {
        commentList = gateway.importComment();
         this.outputBoundary.showComments(commentList);
    }

    /**
     * @param commentString
     * @throws InvalidInputException
     * @throws IOException
     * Check for valid input and turn in to a new Common class send to database
     * if input not valid throw exception
     */

    @Override
    public void addComment(String commentString) throws InvalidInputException, IOException {
        if (checkInput(commentString)) {
            Comment commentClass = new Comment(commentString);
            commentList.addComment(commentClass);
            try {
                //save new comments
                gateway.saveComment(commentList);
            } catch (IOException e) {
                throw new IOException();
            }
            this.outputBoundary.confirmComment(commentClass);
        }else {
            throw new InvalidInputException();
            
        }
        

    }





    // helper function
    public boolean checkString (String s) throws CommentNotInListException {
        int count = 0;
        for (char c : s.toCharArray()){
            if (c != ' '){
                count ++;
            }
        }
        if (count <= 1500 && count > 0){
            return true;
        }
        return false;
    }



    @Override
    public void editComment(int commentNum, String s) throws CommentNotInListException, InvalidInputException {
        if(checkInput(s)){
            for( Comment c : commentList) {
                if (c.getCommentNum() == commentNum) {
                    try {
                        //save new comments
                        gateway.saveComment(commentList);
                        c.setComment(s);
                        this.outputBoundary.outputMessage("Comment Changed");

                    } catch (IOException e) {
                        this.outputBoundary.outputMessage("edit and save new comment to file failed");
                    }
                }
            }
        }
        else {
            throw new CommentNotInListException();
        }

    }


    @Override
    public void outputMessage(String s){
        this.outputBoundary.outputMessage(s);
    }
}
