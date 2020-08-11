import java.io.Serializable;
import java.util.ArrayList;

public abstract class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	private String username;
	private String password;
	protected String fname;
	protected String lname;
	
	public User(){
		this.username = "";
		this.password = "";
		this.fname = "" ;
		this.lname = "";
		
		
	}
	public User(String username, String password, String fname, String lname) {
		this.username = username;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
		
		
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}

}
