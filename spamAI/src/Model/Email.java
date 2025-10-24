package Model;

public class Email {
	  private String from;
	    private String to;
	    private String subject;
	    private String body;
	    private String folder;

	    public Email(String from, String to, String subject, String body) {
	        this.from = from;
	        this.to = to;
	        this.subject = subject;
	        this.body = body;
	    }

	    public String getFrom() { return from; }
	    public String getTo() { return to; }
	    public String getSubject() { return subject; }
	    public String getBody() { return body; }
	    public String getFolder() { return folder; }

	    public void setFolder(String folder) { this.folder = folder; }
}
