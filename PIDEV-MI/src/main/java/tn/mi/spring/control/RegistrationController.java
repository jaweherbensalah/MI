package tn.mi.spring.control;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.mi.spring.entities.RegistrationRequest;
import tn.mi.spring.service.IUserService;
import tn.mi.spring.service.MailService;
import tn.mi.spring.service.RegistrationService;
@RestController
@RequestMapping(path = "rest/v1/servlet")
//@AllArgsConstructor
public class RegistrationController {
	
	@Autowired
	MailService notificationService;
	
	@Autowired
	IUserService userService;
	
	@Autowired
	BCryptPasswordEncoder passcrypt;
	
	

    @Autowired
    RegistrationService registrationService;
    
    @PostMapping("/register")
    public String register(@RequestBody RegistrationRequest request) {
        return registrationService.register(request);
    }
    
 
  //http://localhost:8081/rest/v1/servlet/login/email/password

	@GetMapping("/login/{d1}/{d2}")
	@ResponseBody
	public String login(@PathVariable("d1") String email,@PathVariable("d2") String password)  {
	if(userService.login(email, password))
	{
		return "user logged in";
	}
	else{
		return "erreur";
	}
	}
    
    
//hedhi nconfirmiw beha el token of a user
    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }
//le constructeur:
	public RegistrationController(RegistrationService registrationService) {
		super();
		this.registrationService = registrationService;
	}



	    
}
