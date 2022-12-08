package commentUI;


import commentInterfaceAdapter.commentController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class commentMainFrame extends JFrame{
    JPanel mainPanel = new JPanel();
    JButton viewCommentButton = new JButton("View All Comments");
    JButton newComment = new JButton("Comment");
    JPanel labelPanel = new JPanel();
    JLabel userLabel;
    JLabel label ;

    JPanel buttonPanel = new JPanel();



    /**
     * Main Frame Controller
     * @param controller controller
     * Creat the main frame with buttons.
     */
    public commentMainFrame(commentController controller, String reviewName) {

        label = new JLabel(reviewName + ":");
        label.setFont(new Font("Courier New", Font.BOLD, 20));
        userLabel = new JLabel(" review");
        userLabel.setFont(new Font("Courier New", Font.PLAIN, 18));

        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.add(viewCommentButton ,BorderLayout.WEST);
        buttonPanel.add(newComment ,BorderLayout.EAST);

        labelPanel.setLayout(new BorderLayout());
        labelPanel.add(label,BorderLayout.WEST);
        labelPanel.add(userLabel,BorderLayout.CENTER);

        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(labelPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel , BorderLayout.SOUTH);



        this.add(mainPanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setBounds(585,500,500,500);
        this.setSize(1000,1000);
        this.pack();
        this.setVisible(true);

        viewCommentButton.addActionListener(new ActionListener() {
            /**  This tells controller that the button is pressed
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    controller.showComments();

                } catch (IOException | ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }


        });

        newComment.addActionListener(e -> new commentAddCommentFrame(controller));


    }

}
