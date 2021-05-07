package tn.mi.spring.entities;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter

public class RegistrationRequest {
    private  String firstName;
    private  String lastName;
    private  String city;
    private  String nationality;
    private  String email;
    private  String password;
    @Enumerated(EnumType.STRING)
    private  Role role;
    private String resetPasswordToken;
    
	public String getEmail(){
		return email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}


	public RegistrationRequest(){}
	public String getResetPasswordToken() {
		return resetPasswordToken;
	}
	public void setResetPasswordToken(String resetPasswordToken) {
		this.resetPasswordToken = resetPasswordToken;
	}
	public RegistrationRequest(String firstName, String lastName, String city,String nationality,String email, String password,
			String resetPasswordToken) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		  this.city=city ;
		  this.nationality=nationality ;
		this.email = email;
		this.password = password;
		this.resetPasswordToken = resetPasswordToken;
	}
	
	public RegistrationRequest(String firstName, String lastName, String city,String nationality, String email, String password, Role role,
			String resetPasswordToken) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		  this.city=city ;
		  this.nationality=nationality ;
		this.email = email;
		this.password = password;
		this.role = role;
		this.resetPasswordToken = resetPasswordToken;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	@Override
	public String toString() {
		return "RegistrationRequest [firstName=" + firstName + ", lastName=" + lastName + ", city=" + city
				+ ", nationality=" + nationality + ", email=" + email + ", password=" + password + ", role=" + role
				+ ", resetPasswordToken=" + resetPasswordToken + "]";
	}

	
}
