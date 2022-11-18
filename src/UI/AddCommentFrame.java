package UI;

import InterfaceAdapter.Controller;
import InterfaceAdapter.Presenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCommentFrame extends JFrame {
    JPanel mainPanel = new JPanel();
    JLabel label = new JLabel("Write Comment:");
    JTextArea textArea = new JTextArea();
    JButton enterButton = new JButton("Enter");

    public AddCommentFrame(Controller controller, Presenter presenter){
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(label, BorderLayout.NORTH);
        mainPanel.add(textArea, BorderLayout.CENTER);
        mainPanel.add(enterButton, BorderLayout.SOUTH);

        this.add(mainPanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();

        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newComment = textArea.getText();
                controller.addComment(newComment);


            }
        });

    }

}

