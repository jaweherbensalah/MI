package tn.mi.spring.entities;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.mi.spring.entities.Role;

@Scope(value = "session")
@Controller(value = "data")
@ELBeanName(value = "data")
public class Data {
public Role[] getRoles()
{
return Role.values();
}
}
