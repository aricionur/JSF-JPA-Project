package com.aricionur.jsfJpa.controller;

import javax.faces.bean.ManagedBean;

/**
 * @author Onur Arýcý
 */

@ManagedBean
public class LoginController {

	String outputUsername = "Username : ";
	String username;
	String outputPassword = "Password : ";
	String password;

	String defaultUsername = "root";
	String defaultPassword = "1234";

	public String login() {
		System.out.println("-----------------");

		if (getUsername().equals(defaultUsername) && getPassword().equals(defaultPassword)) {

			return "secure/user.xhtml?faces-redirect=true";
		}

		return "fail.xhtml?faces-redirect=true";
	}

	public String getOutputUsername() {
		return outputUsername;
	}

	public void setOutputUsername(String outputUsername) {
		this.outputUsername = outputUsername;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getOutputPassword() {
		return outputPassword;
	}

	public void setOutputPassword(String outputPassword) {
		this.outputPassword = outputPassword;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
