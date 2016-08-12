package com.sudhir.model;

import java.util.HashSet;
import java.util.Set;

public class User {

	private String username;
	private String password;
	private boolean enabled;
	private Set<UserRole> userRole = new HashSet<UserRole>(0);
	private Set<UserPermission> userPermission = new HashSet<UserPermission>(0);

	public User() {
	}

	public User(String username, String password, boolean enabled) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}

	public User(String username, String password, boolean enabled,
			Set<UserRole> userRole) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.userRole = userRole;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<UserPermission> getUserPermission() {
		return this.userPermission;
	}
	
	
	public Set<UserRole> getUserRole() {
		return this.userRole;
	}

	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}
	
	public void setUserPermission(Set<UserPermission> userPermission) {
		this.userPermission = userPermission;
	}
	
	
	@Override
	public String toString(){
		return new StringBuilder("[username: ").append(this.username ).append(",").append("password: ").append(password).toString();
		
	}
}
