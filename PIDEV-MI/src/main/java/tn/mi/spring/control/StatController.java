package tn.mi.spring.control;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.mi.spring.service.FicheService;


@Controller(value = "statcontroller")
@ELBeanName(value = "statcontroller")
@Join(path= "/l2",  to= "/loginAdmin.jsf")



public class StatController {
	 @Autowired
		FicheService ficheservice;
	public int getv1() {
		return ficheservice.getNombretrueJPQL();
	}
}
