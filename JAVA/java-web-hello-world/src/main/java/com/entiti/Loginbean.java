package com.entiti;

public class Loginbean {
	private String username;
	private String password;

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

	public boolean validate() {
		if ("admin".equals(password)) {
			return true;
		} else {
			return false;
		}
	}

}
