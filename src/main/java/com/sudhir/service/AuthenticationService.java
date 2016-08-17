package com.sudhir.service;

import java.util.Date;

import javax.annotation.security.PermitAll;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.internal.util.Base64;

import com.sudhir.model.User;

@PermitAll
@Path("/authentication")
public class AuthenticationService {
	
	private UserDao userDao;
	
	public AuthenticationService(){
		this.userDao = UserDao.getUserDao();	
	}
	
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public Response authenticateUser(User user) {
		try {
			System.out.println("@@@@User " + user.getUsername()+ " @@@@@@@@Password" + user.getPassword());

			authenticate(user.getUsername(), user.getPassword());
			String token = issueToken(user.getUsername(),user.getPassword());
			return Response.ok(token).build();

		} catch (Exception e) {
			System.out.println(e);
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

	private String issueToken(String username, String password) {
		String plainToken = new StringBuilder(username).append("|").append(password).append("|").append(new Date()).toString();
		System.out.println("######## Token " + plainToken);
		return new String(Base64.encode(plainToken.getBytes()));
		
	}
}
