package tn.mi.spring.control;

import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.mi.spring.entities.User;
import tn.mi.spring.service.IUserService;
import tn.mi.spring.service.MailService;
@RequestMapping(path = "rest/v1/servlet")
@RestController
public class UserRestController {
	
	@Autowired
	IUserService userService;
	
   @Autowired 
   MailService mailService;
	

	// URL : http://localhost:8081/rest/v1/servlet/retrieve-all-users
	@GetMapping("/retrieve-all-users")
	@ResponseBody
	public List<User> getUsers() {
		List<User> list = userService.retrieveAllUsers();
		return list;
	}
	// http://localhost:8081/SpringMVC/servlet/retrieve-user/{user-id}
	@GetMapping("/retrieve-user/{id}")
	@ResponseBody
	public User getUser(@PathVariable("id") String id) {
		return userService.retrieveUser(id);
	}

	// Ajouter User : http://localhost:8081/add-user
	@PostMapping("/add-user")
	@ResponseBody
	public User addUser(@RequestBody User u) {

		User user = userService.addUser(u);

		return user;
	}
	// Supprimer User : http://localhost:8081/rest/v1/servlet/delete-user/{user-id}
	@DeleteMapping("/delete-user/{id}")
	@ResponseBody
	public void deleteUser(@PathVariable("id") String id) {
		userService.deleteUser(id);
	}
	// Modifier User
	//http://localhost:8081/rest/v1/servlet/modify-user

	@PutMapping("/modify-user")
	@ResponseBody
	public User updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}



	//http://localhost:8081/rest/v1/servlet/stat-enabled-users
	@GetMapping(value = "stat-enabled-users")
	@ResponseBody
	public String stat_enabled() {
		return userService.stat_enabled();
	}

	//http://localhost:8081/rest/v1/servlet/stat-disabled-users
	@GetMapping(value = "stat-disabled-users")
	@ResponseBody
	public String stat_disabled() {
		return userService.stat_disabled();
	}
	
	//http://localhost:8081/rest/v1/servlet/reset-password/{userEmail}/{newPassword}
		@PutMapping(value = "/reset-password/{userEmail}/{newPassword}") 
		@ResponseBody
		public void resetPassword(@PathVariable("newPassword") String pwd, @PathVariable("userEmail") String userEmail) {
		try {
			userService.resetPwd(pwd, userEmail);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		}
		//Forgotten Password:
		//http://localhost:8081/rest/v1/servlet/forgotten-password/{email}
		@GetMapping("/forgotten-password/{email}")
		@ResponseBody
		public void sendmail(@PathVariable("email") String email) throws MessagingException  {

		User u=userService.getPasswordCodeToken(email);
	    if(u!=null)
	    {    try {
	          
	    	mailService.sendEmailForgot(u);
	    
	    
	    } catch (MailException mailException) {
			System.out.println(mailException);
		}
	    	System.out.println("User exist ");	

	    }
	    else{
	    	
	    	System.out.println("User doesnt exist !!!");	
	    }
		}
}


