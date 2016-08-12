package com.sudhir.service;

import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.sudhir.model.User;

@Path("/authentication")
public class AuthenticationService {
	
	private UserDao userDao;
	
	public AuthenticationService(){
		this.userDao = UserDao.getUserDao();	
	}
	
	
	@POST
	@Produces("application/json")
	@Consumes("application/x-www-form-urlencoded")
	public Response authenticateUser(@FormParam("username") String username,
			@FormParam("password") String password) {
		try {

			authenticate(username, password);
			String token = issueToken(username);
			return Response.ok(token).build();

		} catch (Exception e) {
			return Response.status(Response.Status.UNAUTHORIZED).build();
		}
	}

	private void authenticate(String username, String password)
			throws Exception {
		
		User usr = this.userDao.getUserByUserName(username);
		if(!password.equals(usr.getPassword())){
			 throw new RuntimeException("User Is not authenticated");
			
		}
		
	
	}

	private String issueToken(String username) {
		return new StringBuilder(username).append("|").append("rendom").append(new Date()).toString();
		
	}
}
