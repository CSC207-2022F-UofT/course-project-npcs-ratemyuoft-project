package UI;

import Entities.Comment;
import InterfaceAdapter.Controller;
import InterfaceAdapter.Presenter;

import javax.swing.*;

public class CommentFrame extends JFrame {

    JList<Comment> list = new JList<>();
    DefaultListModel<String> modle =new DefaultListModel<>();
    JSplitPane splitPane = new JSplitPane();
    Presenter presenter;
    Controller controller;

    public CommentFrame(Presenter presenter, Controller controller){
        this.presenter = presenter;
        this.controller = controller;

    }


}

