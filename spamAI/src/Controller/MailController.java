package Controller;


import java.util.Observable;
import java.util.Observer;

import Model.Email;
import Model.MailService;
import View.MailboxView;

public class MailController implements Observer {
    private MailService mailService = MailService.getInstance();
    private MailboxView mailboxView;

    public MailController(MailboxView view) {
        this.mailboxView = view;
        mailService.addObserver(this);
    }

    public void sendEmail(String from, String to, String subject, String body) {
        Email email = new Email(from, to, subject, body);
        mailService.sendEmail(email);
    }

    public void loadInbox() {
        mailboxView.showInbox(mailService.getInbox(mailboxView.getOwnerEmail()));
        mailboxView.showSpam(mailService.getSpam(mailboxView.getOwnerEmail()));
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof Email email && email.getTo().equals(mailboxView.getOwnerEmail())) {
            mailboxView.refresh();
        }
    }
}
