package UI;

import javax.swing.*;

public class ShowMessageUI extends JFrame implements UIMessage {


    /**
     * @param s
     * Show message on a popup window
     */
    @Override
    public void showMessage(String s) {
        JOptionPane.showMessageDialog(null, s , "Message" ,JOptionPane.INFORMATION_MESSAGE);
    }
}
