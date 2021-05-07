package tn.mi.spring.control;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.mi.spring.service.UserServiceImpl;
@Scope(value = "session")
@Controller(value ="HomeController")
@ELBeanName(value = "HomeController")
@RestController
@RequestMapping("")
public class HomeController {
	@Autowired 
	UserServiceImpl userservice;
	public static  String connectedUser="";
	static  Long connectedUserId;


	

}
