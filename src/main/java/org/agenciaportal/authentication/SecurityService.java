package org.agenciaportal.authentication;

public interface SecurityService {

	public String findLoggedInUsername();
	public void autologin(String username, String password);
}
