package tn.mi.spring.service;

import java.util.List;

import javax.mail.MessagingException;

import tn.mi.spring.entities.User;

public interface IUserService {
	List<User>retrieveAllUsers();
	User addUser (User u);
	void deleteUser (String id);
	User updateUser (User u);
	User retrieveUser (String id);
    String stat_enabled();
    String stat_disabled();
    boolean login(String email,String password);
    
	void resetPwd(String pwd, String email) throws MessagingException;
	User getPasswordCodeToken(String email);
	 public User Authenticate(String email, String password) ;

}
