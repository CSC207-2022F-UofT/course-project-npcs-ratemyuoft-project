package UseCase;

import Entities.Comment;
import Entities.CommentList;

public class Interactor implements InputBoundary {
    private final OutputBoundary outputBoundary;
    private Comment comment;
    private static CommentList commentList = new CommentList();



    public Interactor(OutputBoundary outputBoundary, Comment comment) {
        this.outputBoundary = outputBoundary;
        this.comment = comment;

    }

    @Override
    public boolean checkInput(Comment comment) {
        int count = 0;
        String s = comment.getComment();
        for (char c : s.toCharArray()){
            if (c == ' '){
                count ++;
            }
        }
        return (count <= 200 && count > 0);
    }

    @Override
    public void addComment(Comment comment) throws InvalidInputException {
        if (checkInput(comment)){
            commentList.addComment(comment);
            outputBoundary.confirmMessage(comment);
        }
        else {
            throw new InvalidInputException();
        }
    }
}
