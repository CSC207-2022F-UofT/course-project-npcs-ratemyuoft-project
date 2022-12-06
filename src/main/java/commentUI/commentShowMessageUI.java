package commentUI;

import javax.swing.*;

public class commentShowMessageUI extends JFrame implements commentUIMessage {


    /**
     * @param s
     * Show message on a popup window
     */
    @Override
    public void showMessage(String s) {
        JOptionPane.showMessageDialog(null, s , "Message" ,JOptionPane.INFORMATION_MESSAGE);
    }
}
