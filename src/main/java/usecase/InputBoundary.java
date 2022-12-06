package usecase;

import java.io.IOException;

import entities.Course;

public interface InputBoundary {
    void addReview(String courseName, String rating) throws InvalidInputException, IOException, ClassNotFoundException;

    void addReview(String courseName, String rating, String comment) throws InvalidInputException, IOException, ClassNotFoundException, InvalidCommentLengthException;

    void outputMessage(String s);
}