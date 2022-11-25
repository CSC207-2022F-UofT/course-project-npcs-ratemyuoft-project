package UI;

import Entities.Comment;
import Entities.CommentList;
import InterfaceAdapter.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ShowCommentsFrame extends JFrame implements UIShow {
    JPanel mainPanel = new JPanel();
    JList<String> list = new JList<String>();
    DefaultListModel<String> model =new DefaultListModel<>();
    JPanel panel = new JPanel();
    Controller controller;
    JButton backButton = new JButton("Back");

    public void showComments(CommentList commentList) {
        list.setModel(model);

        for (Comment c : commentList) {
            model.addElement(c.getComment());
        }
        panel.add(new JScrollPane(list));
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(panel, BorderLayout.NORTH);
        mainPanel.add(backButton, BorderLayout.CENTER);
        this.add(mainPanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShowCommentsFrame.super.dispose();
                try {
                    new MainFrame(controller);
                } catch (IOException | ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
    }
}






