package Model;

public class Account {
	 private String email;
	    private String password;
	    private String name;

	    public Account(String email, String password, String name) {
	        this.email = email;
	        this.password = password;
	        this.name = name;
	    }

	    public String getEmail() { return email; }
	    public String getPassword() { return password; }
	    public String getName() { return name; }
}
