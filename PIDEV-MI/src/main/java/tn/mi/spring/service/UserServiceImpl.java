package tn.mi.spring.service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.mail.MessagingException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import tn.mi.spring.entities.ConfirmationToken;
import tn.mi.spring.entities.User;
import tn.mi.spring.repository.UserRepository;

@Service
public class UserServiceImpl implements UserDetailsService,IUserService{
	
	private static final Logger  L =LogManager.getLogger(UserServiceImpl.class);
	private final static String USER_NOT_FOUND_MSG ="user with email %s not found";
    @Autowired 
	UserRepository userRepository;
	private  BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired 
	ConfirmationTokenService confirmationTokenService;
	@Autowired
	BCryptPasswordEncoder passcrypt;
	@Autowired
	MailService mailService;

	@Override
	///verifier si le user existe déjà ???
	public UserDetails loadUserByUsername(String email)
			throws UsernameNotFoundException {
		return userRepository.findByEmail(email)
				.orElseThrow(() ->
				new UsernameNotFoundException(
						String.format(USER_NOT_FOUND_MSG, email)));
	}
//*************************************************************************
	public String signUpUser(User user) {
		boolean userExists = userRepository
				.findByEmail(user.getEmail())
				.isPresent();

		if (userExists) {
		
			throw new IllegalStateException("email already taken");
		}

		String encodedPassword = bCryptPasswordEncoder
				.encode(user.getPassword());

		user.setPassword(encodedPassword);

		userRepository.save(user);

		String token = UUID.randomUUID().toString();

		ConfirmationToken confirmationToken = new ConfirmationToken(
				token,
				LocalDateTime.now(),
				LocalDateTime.now().plusMinutes(15),
				user
				);

		confirmationTokenService.saveConfirmationToken(
				confirmationToken);

		

		return token;
	}

	public int enableAppUser(String email) {
		return userRepository.enableAppUser(email);
	}
//*******************ctor************************************************
	public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		super();
		this.userRepository = userRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	
	
	
//***********forgotten pwd *****************************
	public void updateResetPasswordToken(String token, String email) throws Exception
	{User user  = userRepository.findByEmail2(email);
    if (user != null) {
    	user.setResetPasswordToken(token);
    	userRepository.save(user);
    } else {
        throw new Exception("Could not find any customer with the email " + email);
    }
    }
	
	
	public User getByResetPasswordToken(String token) {
	        return userRepository.findByResetPasswordToken(token);
	    }
	     
	
	public void updatePassword(User u, String newPassword) {
	        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	        String encodedPassword = passwordEncoder.encode(newPassword);
	        u.setPassword(encodedPassword);
	         
	        u.setResetPasswordToken(null);
	        userRepository.save(u);
	    }
//  Crud User:***********************************************************
	    @Override
		public List <User> retrieveAllUsers(){
			List<User> users =(List<User>) userRepository.findAll();
			for (User user: users)
			{L.info("user +++: "+ user);
			}	
			return users;
		}
		//**********************Ajout*********************
		@Override
		public User addUser(User u) {
			User userSaved=null;
			userSaved =userRepository.save(u);
			return userSaved;
		}
		@Override
		public void deleteUser(String id) {
			userRepository.deleteById(Long.parseLong(id));

		}
		@Override
		public User updateUser(User u) {
			// User userAdded =userRepository.save(u);
			//return userAdded;
			return userRepository.save(u);

		}
		@Override
		public User retrieveUser(String id) {
			L.info(("in retrieveUser id = " +id));
			User u = userRepository.findById(Long.parseLong(id)).orElse(null);
			//User u1= userRepository.findById(Long.parseLong(id)).get();
			L.info("user returned : "+u);
			return u;
		}
		
		
		
        @Override
		public String stat_enabled() {
        	return "Percentage of users with Active Account is:  "+userRepository.stat_enabled()+"%";
		}
	    
    	
        @Override
		public String  stat_disabled() {
			return "Percentage of users with Inactive Acount is:  "+userRepository.stat_disabled()+"%";
		}
	   
        @Override
        public void resetPwd(String pwd, String email)   {
			
				User u = userRepository.findByEmail(email).get();
				String crypt=passcrypt.encode(pwd);
				u.setPassword(crypt);
			    userRepository.save(u);
				try {
					mailService.sendEmailVerify(u);
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
   

			}

	@Override
        public User getPasswordCodeToken(String email)
    	{
    		User u=userRepository.getcode(email);
    		if(u!=null)
    		{
           return u;}
    		else{
    			return null;
    		}
    		
    		
    	}
	@Override
	public User Authenticate(String email, String password) {
		
		return userRepository.getUserByEmailAndPassword(email, password);
	}




	public boolean login(String email,String password)
	{
		User u=userRepository.login(email, password);
		if(u.getEnabled())
		{
			return true;
		}
		else {
			return false;
		}
		
	}

public String userconnect(){
/*	Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	String username="";
	if (principal instanceof UserDetails) {
	   username = ((UserDetails) principal).getUsername();
	} else {
	  username = principal.toString();
	}*/
	return "jaweher.bensalah@esprit.tn";
	}
}
