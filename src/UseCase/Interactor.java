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
    public boolean checkInput(String comment) throws InvalidInputException {
        int count = 0;
        for (char c : comment.toCharArray()){
            if (c != ' '){
                count ++;
            }
        }

        if (count <= 1500 && count > 0){
            return true;
        }
        else {
            //catch by controller
            throw new InvalidInputException();
        }
    }


    @Override
    public CommentList showComments() throws IOException, ClassNotFoundException {
        commentList = gateway.importComment();
        return (commentList);
    }

    @Override
    public void addComment(String commentString) throws InvalidInputException, IOException {
        if (checkInput(commentString)) {
            Comment commentClass = new Comment(commentString);
            System.out.println(commentClass);
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
        else {
            throw new CommentNotInListException();
        }
    }



    @Override
    public void editComment(int commentNum, String s) throws InvalidInputException,  CommentNotInListException {
        if(checkString(s)){
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
    }


    @Override
    public void outputMessage(String s){
        this.outputBoundary.outputMessage(s);
    }
}
