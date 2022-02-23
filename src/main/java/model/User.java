package model;

public class User {
	
	private String login;
	private String password;
	
	public User(String login, String password) {
		this.login = login;
		this.password = password;
	}
	
	public String getLogin() {
		return login;
	}
	public String getPassword() {
		return password;
	}
	
	public boolean validate(String login, String password) {
		if (!(getLogin().equals(login))) {
			return false;
		}
		if (!(getPassword().equals(password))) {
			return false;
		}
		return true;
	}

}
