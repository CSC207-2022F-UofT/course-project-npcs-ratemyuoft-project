package usecase;

import java.io.IOException;

import entities.Course;

public interface InputBoundary {
    void addReview(Course c, int r) throws InvalidInputException, IOException;

    void addReview(Course c, int r, String s) throws InvalidInputException, IOException;

    void outputMessage(String s);
}