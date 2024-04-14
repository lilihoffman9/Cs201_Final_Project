package jlee7162_201_FinalProject;

public class RegisterUser {
	private String username;
	private String password;
	private String email;
  private String firstName;
  private String lastName;
	
	public RegisterUser(String username, String password, String firstName, String lastName, String email) {
		this.username = username;
		this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;
		this.email = email;
	}
	
	public void addRegisterUser() {
		//insert into database
		return;
	}

  public String getFirstName(String firstName){
    return firstName;
  }
  public String getLastName(String lastName){
    return lastName;
  }

}
