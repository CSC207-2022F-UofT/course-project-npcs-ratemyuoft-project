package commentUI;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class commentShowCommentsFrame extends JFrame implements commentUIShow {
    JPanel mainPanel = new JPanel();
    JList<String> list = new JList<>();
    DefaultListModel<String> model =new DefaultListModel<>();
    JButton backButton = new JButton("Back");
    JScrollPane scrollPane =new JScrollPane(list);



    /**
     * @param listOfComments
     * add the arraylist on to the view and show.
     */
    public void showComments(ArrayList<String> listOfComments) {
        list.setModel(model);
        int count = 1;
        for (String s : listOfComments) {
            model.addElement(count++ +": "+s);
        }
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(backButton, BorderLayout.SOUTH);

        this.add(mainPanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        backButton.addActionListener(e -> commentShowCommentsFrame.super.dispose());
        }
    }










