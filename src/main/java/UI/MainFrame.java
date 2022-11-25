package UI;

import DataBase.DataAccess;
import InterfaceAdapter.Controller;
import InterfaceAdapter.Presenter;
import UseCase.Gateway;
import UseCase.InputBoundary;
import UseCase.Interactor;
import UseCase.OutputBoundary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MainFrame extends JFrame{
    JPanel mainPanel = new JPanel();
    JButton viewCommentButton = new JButton("View All Comments");
    JButton newComment = new JButton("Comment");
    JButton editComment = new JButton("Edit Comment");
    JLabel reviewNamePanel = new JLabel("******");
    JPanel buttonPanel = new JPanel();



    public MainFrame(Controller controller) throws IOException, ClassNotFoundException {


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
        this.setVisible(true);

        viewCommentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    controller.showComments();
                    MainFrame.super.dispose();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }


            }
        });

        newComment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddCommentFrame(controller);
                MainFrame.super.dispose();

            }
        });

        editComment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }

}
