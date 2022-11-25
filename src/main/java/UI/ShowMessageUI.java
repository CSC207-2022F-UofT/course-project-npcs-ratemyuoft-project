package UI;

import javax.swing.*;

public class ShowMessageUI extends JFrame implements UIMessage {



    @Override
    public void showMessage(String s) {
        JOptionPane.showMessageDialog(null, s , "Message" ,JOptionPane.INFORMATION_MESSAGE);
    }
}
