package UI;

import Entities.Comment;
import Entities.CommentList;
import InterfaceAdapter.Controller;
import InterfaceAdapter.Presenter;
import UseCase.OutputBoundary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ShowCommentsFrame extends JFrame {
    JPanel mainPanel = new JPanel();
    JList<String> list = new JList<String>();
    DefaultListModel<String> model =new DefaultListModel<>();
    JPanel panel = new JPanel();
    Controller controller;
    JButton backButton = new JButton("Back");

    public ShowCommentsFrame(Controller controller, OutputBoundary presenter)  {

        this.controller = controller;

        list.setModel(model);

        try {
            CommentList cl = controller.showComments();
            for (Comment c : cl) {
                System.out.println("hi");
                System.out.println(c.getComment());
                model.addElement(c.getComment());

            }
        }catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Class Not found");

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "No Comments Yet");
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
                    new MainFrame(controller,presenter);
                } catch (IOException | ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });


    }
}

