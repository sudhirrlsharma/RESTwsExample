package com.sudhir.service;

import java.util.Collection;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HEAD;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sudhir.model.User;

@Path("/users")
public class UserService {

	private UserDao userDao;

	public UserService() {
		this.userDao = UserDao.getUserDao();
	}


	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<User> getUsers(@BeanParam SearchCeriteria sc) {
		return userDao.getAllUsers(sc);
	}
	

	@Path("/{userName}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public User getUserById(@PathParam("userName") String userName) {
		return userDao.getUserByUserName(userName);
	}

	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createUser(User user) {
		userDao.createUser(user);
		String result = "User saved : " + user;
		return Response.status(201).entity(result).build();
		
	}

	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateUser(User user) {
		userDao.updateUser(user);
		String result = "User updated : " + user;
		return Response.status(201).entity(result).build();
		
	}

	
	@Path("/{userName}")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteUser(@PathParam("userName") String userName) {
		userDao.deleteUser(userName);
		String result = "User deleted : " + userName;
		return Response.status(200).entity(result).build();
		
	}

	
	  @OPTIONS
	   @Produces(MediaType.APPLICATION_JSON)
	   public String getSupportedOperations(){
	      return "{operation:GET, PUT, POST, DELETE}";
	}

	@HEAD
	public Response head(){
		 return Response.status(200).entity(null).build();
	}
}
