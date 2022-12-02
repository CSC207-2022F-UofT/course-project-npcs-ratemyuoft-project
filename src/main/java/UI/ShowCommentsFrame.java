package UI;

import Entities.Comment;
import Entities.CommentList;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class ShowCommentsFrame extends JFrame implements UIShow {
    JPanel mainPanel = new JPanel();
    JList<String> list = new JList<String>();
    DefaultListModel<String> model =new DefaultListModel<>();
    JPanel panel = new JPanel();
    JButton backButton = new JButton("Back");


    /**
     * @param listOfComments
     * add the arraylist on to the view and show.
     */
    public void showComments(ArrayList<String> listOfComments) {
        list.setModel(model);
        for (String s : listOfComments) {
            model.addElement(s);
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
            }
        });
        }
    }










