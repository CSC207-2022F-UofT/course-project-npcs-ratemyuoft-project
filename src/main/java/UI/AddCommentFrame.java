package UI;

import InterfaceAdapter.Controller;
import UseCase.InvalidInputException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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



        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newComment = textArea.getText();
                try {
                    controller.addComment(newComment);
                    controller.outPutMessage("Comment Saved!");
                    AddCommentFrame.super.dispose();
                    try {
                        new MainFrame(controller);

                    } catch (ClassNotFoundException ex) {
                        controller.outPutMessage("Class Not Found!");

                    }
                } catch (InvalidInputException ex) {
                    controller.outPutMessage("Comment Invalid!");

                } catch (IOException ex) {
                    controller.outPutMessage("Can't Save!");

                }
            }
        });


        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddCommentFrame.super.dispose();
                try {
                    new MainFrame(controller);
                } catch (IOException | ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });

    }

}
