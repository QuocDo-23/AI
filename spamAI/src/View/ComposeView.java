package View;


import javax.swing.*;

import Controller.MailController;

import java.awt.*;

public class ComposeView extends JFrame {
    private JTextField txtTo, txtSubject;
    private JTextArea txtBody;
    private JButton btnSend;
    private MailController controller;
    private String from;

    public ComposeView(String from, MailController controller) {
        this.from = from;
        this.controller = controller;
        setTitle("Compose - " + from);
        setSize(400, 300);
        setLayout(new BorderLayout());

        JPanel top = new JPanel(new GridLayout(2,2));
        top.add(new JLabel("To:")); txtTo = new JTextField(); top.add(txtTo);
        top.add(new JLabel("Subject:")); txtSubject = new JTextField(); top.add(txtSubject);
        add(top, BorderLayout.NORTH);

        txtBody = new JTextArea();
        add(new JScrollPane(txtBody), BorderLayout.CENTER);

        btnSend = new JButton("Send");
        btnSend.addActionListener(e ->
            controller.sendEmail(from, txtTo.getText(), txtSubject.getText(), txtBody.getText())
        );
        add(btnSend, BorderLayout.SOUTH);
    }
}
