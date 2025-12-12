package Model;

import java.util.*;

public class MailService extends Observable {
    private static MailService instance;
    private List<Email> allEmails = new ArrayList<>();
    private SpamDetector detector = SpamDetector.getInstance();

    private MailService() {}

    public static MailService getInstance() {
        if (instance == null)
            instance = new MailService();
        return instance;
    }

    public void sendEmail(Email email) {
        boolean isSpam = detector.isSpam(email.getSubject() + " " + email.getBody());
        email.setFolder(isSpam ? "SPAM" : "INBOX");
        allEmails.add(email);
        setChanged();
        notifyObservers(email);
        System.out.println("Email sent! Folder: " + email.getFolder());
    }

    public List<Email> getInbox(String emailAddr) {
        return allEmails.stream()
                .filter(e -> e.getTo().equals(emailAddr) && "INBOX".equals(e.getFolder()))
                .toList();
    }

    public List<Email> getSpam(String emailAddr) {
        return allEmails.stream()
                .filter(e -> e.getTo().equals(emailAddr) && "SPAM".equals(e.getFolder()))
                .toList();
    }
}