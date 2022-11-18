package UI;

import InterfaceAdapter.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame{
    JPanel mainPanel = new JPanel();
    JButton viewCommentButton = new JButton("View All Comments");
    JButton newComment = new JButton("Comment");
    JButton editComment = new JButton("Edit Comment");
    JLabel reviewNamePanel = new JLabel("******");
    JPanel buttonPanel = new JPanel();

    public MainFrame(Controller controller){

        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.add(viewCommentButton ,BorderLayout.WEST);
        buttonPanel.add(newComment ,BorderLayout.CENTER);
        buttonPanel.add(editComment ,BorderLayout.EAST);

        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(reviewNamePanel , BorderLayout.NORTH);
        mainPanel.add(buttonPanel , BorderLayout.SOUTH);

        this.add(mainPanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();

        viewCommentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        newComment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        editComment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }

}
