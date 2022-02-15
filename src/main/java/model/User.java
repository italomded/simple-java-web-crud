package model;

public class User {
	
	private String login;
	private String password;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
