package com.sudhir.model;


public class UserPermission{

	private Integer userPermissionId;
	private User user;
	private String permission;

	public UserPermission() {
	}

	public UserPermission(User user, String permission) {
		this.user = user;
		this.permission = permission;
	}

	public Integer getUserPermissionId() {
		return this.userPermissionId;
	}

	public void setUserPermissionId(Integer userPermissionId) {
		this.userPermissionId = userPermissionId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getPermission() {
		return this.permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

}