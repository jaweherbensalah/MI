package tn.mi.spring.entities;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Scope(value = "session")
@Controller(value = "customValidationView")
@ELBeanName(value = "customValidationView")

public class CustomValidationView {

    private String text;

    @Email(message = "must be a valid email")
    private String email;

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }


}