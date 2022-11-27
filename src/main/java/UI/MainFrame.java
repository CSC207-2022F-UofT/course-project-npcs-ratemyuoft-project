//package UI;
//
//
//import filterInterfaceAdapters.FilterController;
//
//import javax.swing.*;
//import javax.swing.border.Border;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class MainFrame extends JFrame {
//    JPanel mainPanel = new JPanel();
//
//    JButton filterByName = new JButton("Filter By Name");
//
//    JTextField filterByNameTextField = new JTextField();
//
//    JScrollPane leftPanel = new JScrollPane();
//
//    JPanel rightPanel = new JPanel();
//
//    JPanel rightUpperPanel = new JPanel();
//
//    JPanel rightLowerPanel = new JPanel();
//
//
//    public MainFrame(FilterController filterController) {
//        mainPanel.setLayout(new BorderLayout());
//        //leftPanel.setLayout(new BorderLayout());
//
////        rightUpperPanel.setLayout(new BorderLayout());
////        rightLowerPanel.setLayout(new BorderLayout());
//
////        rightLowerPanel.add(filterByName);
////        rightUpperPanel.add(filterByNameTextField);
//
//        rightPanel.add(filterByName, BorderLayout.SOUTH);
//        rightPanel.add(filterByNameTextField, BorderLayout.NORTH);
//
//        mainPanel.add(leftPanel, BorderLayout.WEST);
//
//        mainPanel.add(rightPanel, BorderLayout.EAST);
//
//        this.add(mainPanel);
//        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        this.pack();
//        this.setVisible(true);
//
//        filterByName.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String name = filterByNameTextField.getText();
//
//                try {
//                    filterController.FilterByName(name);
//                }
//            }
//    })
//
//}
