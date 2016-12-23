package com.bte.hwvr.model;

import java.io.Serializable;

import jersey.repackaged.com.google.common.base.MoreObjects;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	private String login;
	private String email;
	private String fullName;
	private int authType;
	private String password;
	private boolean isAdmin;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAuthType() {
		return authType;
	}

	public void setAuthType(int authType) {
		this.authType = authType;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("id", id).add("login", login).add("email", email)
				.add("fullName", fullName).add("authType", authType).add("password", password).add("isAdmin", isAdmin)
				.toString();
	}

}
