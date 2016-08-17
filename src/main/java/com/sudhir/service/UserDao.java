package com.sudhir.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.sudhir.model.User;

public class UserDao {
	
	private Map<String, User> usersMap = new HashMap<String, User>();
	
	private static UserDao dao; 
	
	private  UserDao(){
		System.out.println("Initializing the users");
		usersMap.put("SudhirSh", createUsers("Sudhirsh", "sharma"));
		usersMap.put("jwalin", createUsers("jwalin", "shah"));
	}
	
	public Collection<User> getAllUsers(){
		return usersMap.values();
	}
	
	public Collection<User> getAllUsers(SearchCeriteria sc){
		Collection<User> users;
		if(sc.getSortOrder().equals("ASC")){
			System.out.println("Sorting accending");
			
		}else{
			System.out.println("Sorting desending");
		}
		
		System.out.println("Limiting the records to " + sc.getLimit());
		return usersMap.values();
	}
	
	public User getUserByUserName(String userName){
		System.out.println("Prinign the user map " + usersMap);
		System.out.println("Input user is  " + userName);
		User u = usersMap.get(userName);
		userExist(userName, u);
		return u;
				
	}

	private void userExist(String userName, User u) {
		if(u==null){
			throw new RuntimeException("User Name found " + userName);
		}
	}
	
	public boolean createUser(User u){
		System.out.println(u);
		usersMap.put(u.getUsername(), u);
		return true;
	}

	public boolean updateUser(User u){
		User usr = usersMap.get(u.getUsername());
		userExist(u.getUsername(), usr);
		usersMap.put(u.getUsername(), u);
		return true;
	}
	
	public boolean deleteUser(String userName){
		User u = usersMap.get(userName);
		if(u==null){
			return false;
		} else{
			usersMap.remove(userName);
		}
		return true;
	}
	
	

	private User createUsers(String usr,String pwd) {
		User u = new User();
		u.setUsername(usr);
		u.setPassword(pwd);
		u.setEnabled(true);
		return u;
	}
	

	public  static UserDao getUserDao(){
		if(dao==null){
			dao = new UserDao();
		}
		return dao;
	}
}
