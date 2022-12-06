package usecase;

import java.io.IOException;

import entities.Course;

public interface InputBoundary {
    void addReview(String courseName, int rating) throws InvalidInputException, IOException, ClassNotFoundException;

    void addReview(String courseName, int rating, String comment) throws InvalidInputException, IOException, ClassNotFoundException;

    void outputMessage(String s);
}