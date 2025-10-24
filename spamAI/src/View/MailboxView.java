package View;



import javax.swing.*;

import Controller.MailController;
import Model.Account;
import Model.Email;

import java.awt.*;
import java.util.List;

public class MailboxView extends JFrame {
    private JList<String> inboxList, spamList;
    private DefaultListModel<String> inboxModel, spamModel;
    private JButton btnCompose, btnRefresh;
    private Account owner;
    private MailController controller;

    public MailboxView(Account owner) {
        this.owner = owner;
        setTitle("Mailbox - " + owner.getName());
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        inboxModel = new DefaultListModel<>();
        spamModel = new DefaultListModel<>();
        inboxList = new JList<>(inboxModel);
        spamList = new JList<>(spamModel);

        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                new JScrollPane(inboxList), new JScrollPane(spamList));
        split.setDividerLocation(250);
        add(split, BorderLayout.CENTER);

        btnCompose = new JButton("Compose");
        btnRefresh = new JButton("Refresh");
        JPanel bottom = new JPanel();
        bottom.add(btnCompose);
        bottom.add(btnRefresh);
        add(bottom, BorderLayout.SOUTH);

        controller = new MailController(this);
        controller.loadInbox();

        btnCompose.addActionListener(e -> new ComposeView(owner.getEmail(), controller).setVisible(true));
        btnRefresh.addActionListener(e -> controller.loadInbox());
    }

    public void showInbox(List<Email> emails) {
        inboxModel.clear();
        for (Email e : emails) inboxModel.addElement("From: " + e.getFrom() + " | " + e.getSubject());
    }

    public void showSpam(List<Email> emails) {
        spamModel.clear();
        for (Email e : emails) spamModel.addElement("From: " + e.getFrom() + " | " + e.getSubject());
    }

    public void refresh() { controller.loadInbox(); }
    public String getOwnerEmail() { return owner.getEmail(); }
}
