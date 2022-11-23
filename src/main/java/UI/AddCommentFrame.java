package UI;

import InterfaceAdapter.Controller;
import InterfaceAdapter.Presenter;
import UseCase.InvalidInputException;
import UseCase.OutputBoundary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AddCommentFrame extends JFrame {
    JPanel mainPanel = new JPanel();
    JLabel label = new JLabel("Write Comment:");
    JTextArea textArea = new JTextArea();
    JPanel buttonPanel = new JPanel();
    JButton enterButton = new JButton("Enter");
    JButton backButton = new JButton("Back");

    public AddCommentFrame(Controller controller, OutputBoundary presenter){
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
                    JOptionPane.showMessageDialog(null, "Comment Saved!");
                    AddCommentFrame.super.dispose();
                    try {
                        new MainFrame(controller,presenter);

                    } catch (ClassNotFoundException ex) {
                        JOptionPane.showMessageDialog(null, "Class Not Found!");
                    }
                } catch (InvalidInputException ex) {
                    JOptionPane.showMessageDialog(null, "Comment Invalid!");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Can't Save!");
                }
            }
        });


        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddCommentFrame.super.dispose();
                try {
                    new MainFrame(controller,presenter);
                } catch (IOException | ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });

    }

}

