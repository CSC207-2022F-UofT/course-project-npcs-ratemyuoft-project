package UI;

import Entities.Comment;
import InterfaceAdapter.Controller;
import InterfaceAdapter.Presenter;

import javax.swing.*;

public class CommentFrame extends JFrame {

    JList<String> list = new JList<String>();
    DefaultListModel<String> model =new DefaultListModel<>();
    JPanel Panel = new JPanel();
    Presenter presenter;
    Controller controller;

    public CommentFrame(Presenter presenter, Controller controller){
        this.presenter = presenter;
        this.controller = controller;
        list.setModel(model);
        for(Comment c : controller.showComments()){
            model.addElement(c.getComment());
        }
        Panel.add(new JScrollPane(list));





}

