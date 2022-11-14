package UseCase;

import DataBase.DataAccess;
import Entities.Comment;
import Entities.CommentList;

import java.io.IOException;

public class Interactor implements InputBoundary {
    private final OutputBoundary outputBoundary;
    private Comment comment;
    private static CommentList commentList = new CommentList();
    private Gateway gateway = new DataAccess();



    public Interactor(OutputBoundary outputBoundary, Comment comment) throws IOException, ClassNotFoundException {
        this.outputBoundary = outputBoundary;
        this.comment = comment;
        // import file and set as iterable commentList
        try{
            commentList = gateway.importComment();
        } catch (IOException e ){
            commentList = new CommentList();
            this.outputBoundary.outputMessage("Importation failed");
        }


    }



    // helper function for add Comment
    public boolean checkInput(Comment comment) {
        int count = 0;
        String s = comment.getComment();
        for (char c : s.toCharArray()){
            if (c != ' '){
                count ++;
            }
        }
        return (count <= 1500 && count > 0);
    }



    @Override
    public void addComment(Comment comment) throws InvalidInputException {
        if (checkInput(comment)) {
            commentList.addComment(comment);
            try {
                //save new comments
                gateway.saveComment(commentList);
                this.outputBoundary.confirmComment(comment);
            } catch (IOException e) {
                this.outputBoundary.outputMessage("saving new comment to file failed");
            }
        }
        else {
            throw new InvalidInputException();
            //catch by controller
        }

    }




    // helper function
    public boolean checkString (String s) {
        int count = 0;
        for (char c : s.toCharArray()){
            if (c != ' '){
                count ++;
            }
        }
        return (count <= 1500 && count > 0);
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
                else {
                    throw new CommentNotInListException();
                }

            }
        }
        else {
            throw new InvalidInputException();
        }
    }


    @Override
    public void outputMessage(String s){
        this.outputBoundary.outputMessage(s);


    }
}
