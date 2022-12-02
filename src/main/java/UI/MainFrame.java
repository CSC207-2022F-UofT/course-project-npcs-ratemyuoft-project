package UI;


import InterfaceAdapter.Controller;
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
    JPanel labelPanel = new JPanel();
    JLabel userlabel ;
    JLabel label ;

    JPanel buttonPanel = new JPanel();



    /**
     * Main Frame Controller
     * @param controller
     * @throws IOException
     * @throws ClassNotFoundException
     *
     * Creat the main frame with buttons.
     */
    public MainFrame(Controller controller,String reviewName) throws IOException, ClassNotFoundException {

        label = new JLabel(reviewName + ":");
        label.setFont(new Font("Courier New", Font.BOLD, 20));
        userlabel = new JLabel(" User");
        userlabel.setFont(new Font("Courier New", Font.PLAIN, 18));

        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.add(viewCommentButton ,BorderLayout.WEST);
        buttonPanel.add(newComment ,BorderLayout.CENTER);
        buttonPanel.add(editComment ,BorderLayout.EAST);

        labelPanel.setLayout(new BorderLayout());
        labelPanel.add(label,BorderLayout.WEST);
        labelPanel.add(userlabel,BorderLayout.CENTER);

        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(labelPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel , BorderLayout.SOUTH);



        this.add(mainPanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setVisible(true);

        viewCommentButton.addActionListener(new ActionListener() {
            /**  This tells controllor that the button is pressed
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    controller.showComments();

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
            private void setVisible(boolean b) {
                this.setVisible(b);
            }


        });

        newComment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddCommentFrame(controller);
            }

        });

        editComment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }

}
