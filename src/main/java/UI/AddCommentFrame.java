package UI;

import InterfaceAdapter.Controller;
import UseCase.InvalidInputException;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class AddCommentFrame extends JFrame  {
    JPanel mainPanel = new JPanel();
    JLabel label = new JLabel("Write Comment:");
    JTextArea textArea = new JTextArea();
    JPanel buttonPanel = new JPanel();
    JButton enterButton = new JButton("Enter");
    JButton backButton = new JButton("Back");




    public AddCommentFrame(Controller controller){

        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.add(enterButton, BorderLayout.WEST);
        buttonPanel.add(backButton, BorderLayout.EAST);
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(label, BorderLayout.NORTH);
        mainPanel.add(textArea, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        this.add(mainPanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setVisible(true);



        enterButton.addActionListener(e -> {
            String newComment = textArea.getText();
            try {
                controller.addComment(newComment);
                controller.outPutMessage("Comment Saved!");
                AddCommentFrame.super.dispose();
            } catch (InvalidInputException ex) {
                controller.outPutMessage("Comment Invalid!");

            } catch (IOException ex) {
                controller.outPutMessage("Can't Save!");

            }
        });


        backButton.addActionListener(e -> AddCommentFrame.super.dispose());

    }

}

