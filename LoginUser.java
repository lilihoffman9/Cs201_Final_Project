package jlee7162_201_FinalProject;

public class LoginUser {
	private String username;
	private String password;
	
	public LoginUser(String username, String password) {
		this.setUsername(username);
	}
	
	public Boolean ValidateUser(String username, String password) {
		return true;
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
	
}
