package bean;

import play.data.validation.Constraints.Required;

public class LoginForm {
	
	@Required
	private String username;//登录名
	
	@Required
	private String password;//密码

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
