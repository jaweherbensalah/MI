package tn.mi.spring.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.primefaces.model.FilterMeta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;

import tn.mi.spring.entities.Email;
import tn.mi.spring.entities.Role;
import tn.mi.spring.entities.User;
import tn.mi.spring.repository.UserRepository;
import tn.mi.spring.service.IUserService;
import tn.mi.spring.service.UserServiceImpl;



@Scope(value = "session")
@Controller(value = "userController")
@ELBeanName(value = "userController")
@Join(path = "/", to= "/loginAdmin.jsf")

public class UserControllerImpl {
JavaMailSender javaMailSender;
@Autowired
UserRepository userRepository;
@Autowired
IUserService userService;
@Autowired
private BCryptPasswordEncoder passwordEncoder;
@NotNull(message = "Name cannot be null")
private String firstName; 
@NotNull(message = "Last name cannot be null")
private String lastName;
@NotNull(message = "City cannot be null")
private String city;
@NotNull(message = "Nationality cannot be null")
private String nationality;
@Email(message = "must be a valid email")
private String email;
@NotNull(message = "Password cannot be null")
@Size(min = 6, max = 200, message 
= "Password must be between 6 and 200 characters")
private String password;
private User u;
private Boolean enabled; 
private Boolean loggedIn;
private List<User> users;
private Long userIdToBeUpdated; // id de user à modifier 
private Role role;
private String searchString;




//méthode login:*************************************************
public String dologin() {

String navigateTo = "null";
User u=userService.Authenticate(email, password);
if (u != null && u.getRole() == Role.ADMIN) {
navigateTo = "/pages/admin/AnnonceManagement.xhtml?faces-redirect=true";
loggedIn = true;
}
else if (u != null && u.getRole() == Role.USER)
{ 
	navigateTo = "/pages/user/welcomeUser2.xhtml?faces-redirect=true";
	loggedIn = true;
}
else
{
FacesMessage facesMessage =
                new FacesMessage("Login Failed: please check your username/password and try again.");
            FacesContext.getCurrentInstance().addMessage("form:btn",facesMessage);
}
return navigateTo;
}

//******************************************************************************************

public String doLogout()
{FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
return "/loginAdmin.xhtml?faces-redirect=true";
}

//*****************************************************************


//******************************************************************
//note the return type is String. return type of methods which are to be called from actions of commandlinks or commandbuttons should be string
public String searchByFirstName()
{
 this.u = userRepository.getUserByFirstName(searchString);
 return u.getFirstName();
}













private List<User> customers1;

private List<User> customers2;

private List<User> customers3;

private List<User> filteredCustomers1;

private List<User> filteredCustomers2;

private List<User> filteredCustomers3;

private List<FilterMeta> filterBy;

@PostConstruct
public void init() {
    customers1 = userService.retrieveAllUsers();
    

    filterBy = new ArrayList<>();

 

}

public boolean globalFilterFunction(Object value, Object filter, Locale locale) {
    String filterText = (filter == null) ? null : filter.toString().trim().toLowerCase();
    
    int filterInt = getInteger(filterText);

    User customer = (User) value;
    return customer.getFirstName().toLowerCase().contains(filterText)
            || customer.getLastName().toLowerCase().contains(filterText)
            || customer.getCity().toLowerCase().contains(filterText)
            || customer.getNationality().toString().toLowerCase().contains(filterText)
            || customer.getEmail().toLowerCase().contains(filterText);
            
}

private int getInteger(String string) {
    try {
        return Integer.parseInt(string);
    }
    catch (NumberFormatException ex) {
        return 0;
    }
}


public List<User> getCustomers1() {
    return customers1;
}


public List<User> getFilteredCustomers1() {
    return filteredCustomers1;
}

public void setFilteredCustomers1(List<User> filteredCustomers1) {
    this.filteredCustomers1 = filteredCustomers1;
}

public List<User> getFilteredCustomers2() {
    return filteredCustomers2;
}

public void setFilteredCustomers2(List<User> filteredCustomers2) {
    this.filteredCustomers2 = filteredCustomers2;
}

public List<User> getFilteredCustomers3() {
    return filteredCustomers3;
}

public void setFilteredCustomers3(List<User> filteredCustomers3) {
    this.filteredCustomers3 = filteredCustomers3;
}



public List<FilterMeta> getFilterBy() {
    return filterBy;
}
























//Générer les Getters & les Setters
public IUserService getUserService() {
	return userService;
}

public String getSearchString() {
	return searchString;
}

public void setSearchString(String searchString) {
	this.searchString = searchString;
}

public void setUserService(IUserService userService) {
	this.userService = userService;
}



public User getU() {
	return u;
}



public void setU(User u) {
	this.u = u;
}

public String getPassword() {
	return password;
}



public void setPassword(String password) {
	this.password = password;
}



public Boolean getLoggedIn() {
	return loggedIn;
}



public void setLoggedIn(Boolean loggedIn) {
	this.loggedIn = loggedIn;
}
//************************************************************************
public UserRepository getUserRepository() {
	return userRepository;
}



public void setUserRepository(UserRepository userRepository) {
	this.userRepository = userRepository;
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
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Boolean getEnabled() {
	return enabled;
}
public void setEnabled(Boolean enabled) {
	this.enabled = enabled;
}

//c'est le get de la liste 
public List<User> getUsers() {
users = userService.retrieveAllUsers();
return users;
}
public void setUsers(List<User> users) {
	this.users = users;
}


public Long getUserIdToBeUpdated() {
	return userIdToBeUpdated;
}



public void setUserIdToBeUpdated(Long userIdToBeUpdated) {
	this.userIdToBeUpdated = userIdToBeUpdated;
}



public Role getRole() {
	return role;
}



public void setRole(Role role) {
	this.role = role;
}



//***********************************crud jsf
//************************************ Ajout ************************************************
public void ajouterEmploye()
{
	userService.addUser(new User(firstName,lastName,city, nationality,email, password,role,enabled));


	/*	SimpleMailMessage mail = new SimpleMailMessage();
		mail.setFrom("appmailing.jaweher@gmail.com");
		mail.setTo("appmailing.jaweher@gmail.com");
		mail.setSubject("You sgned up");
		mail.setText("This is your verification code Mr.");
		javaMailSender.send(mail);
	*/
}

//************************************ Affichage **********************************************
//c'est le get 
public List<User> getEmployes() {
users = userService.retrieveAllUsers();
return users;
}

//************************************** Supp ****************************************************
public void removeEmploye(String employeid)
{
userService.deleteUser(employeid);
}
//************************************* Update *******************************************************
public void modifier(User u)
{this.setFirstName(u.getFirstName());
this.setLastName(u.getLastName());
this.setCity(u.getCity());
this.setNationality(u.getNationality());
this.setEmail(u.getEmail());
this.setPassword(u.getPassword());
this.setEnabled(u.getEnabled());
this.setRole(u.getRole());
this.setUserIdToBeUpdated(u.getId());
}

public void mettreAjourEmploye(){
	User e= new User(userIdToBeUpdated,firstName,lastName,city,nationality,password, email,role,enabled);

userService.updateUser(e);

}
//******************************************************************



public String gotoLogin(){
	return "/login.xhtml?faces-redirect=true";
}

public String gotoMeuble(){
	return "/pages/user/oumema.xhtml?faces-redirect=true";
}
public String gotoVirtualVisit(){
	FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	return "/pages/user/chaima.xhtml?faces-redirect=true";
}

public String gotolistAdvertisement(){
	return "/pages/user/AnnoncesListing.xhtml?faces-redirect=true";
}
public String gotoHomepageUser(){
	return "/pages/user/welcomeUser2.xhtml?faces-redirect=true";
}
public String gotoAnnonceAdd(){
	return "/pages/user/AnnonceAdd.xhtml?faces-redirect=true";
}

public String gotoAnnonceDetail(){
	return "/pages/user/AnnonceDetails.xhtml?faces-redirect=true";
}

public String gotopagelog(){
	return "/login.xhtml?faces-redirect=true";
}
public String gotoLog(){
	return "/pages/user/UserProfile.xhtml?faces-redirect=true";
}
public String gotoUserProfile(){
	return "/pages/user/UserProfile.xhtml?faces-redirect=true";
}
public String gotoRent(){
	return "/pages/user/eya.xhtml?faces-redirect=true";
}
public String gotoBuy(){
	return "/pages/user/salsabil.xhtml?faces-redirect=true";
}
public String viewPurchases(){
	return "/pages/user/mesachatsprevu.xhtml?faces-redirect=true";
}
public String gotoSubscribe(){
	return "/pages/user/Logsubs.xhtml?faces-redirect=true";
}
public String gotoPublication(){
	return "/pages/user/publicab_login.xhtml?faces-redirect=true";
}
public String gotoSurveillance(){
	return "/pages/user/surveillancelog.xhtml?faces-redirect=true";
}


public String creerCompte(){
	return "/pages/user/user_register.xhtml?faces-redirect=true";
}
public String gotoReclamation(){
	return "/pages/user/reclamation.xhtml?faces-redirect=true";
}
public String gotoFiche(){

FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	return "/pages/user/fiche.xhtml?faces-redirect=true";
}
public String gotoAff(){

FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	return "/pages/user/table.xhtml?faces-redirect=true";
}
public String gotoLogassurance(){
	return "/pages/user/assurance_login.xhtml?faces-redirect=true";
}
public String gotoStatistique(){
FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
return "/pages/admin/statistiqueH.xhtml?faces-redirect=true";
}
public String forgot(){
FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
return "/pages/user/forgotPassword.xhtml?faces-redirect=true";
}

public String register(){
FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
return "/pages/user/register.xhtml?faces-redirect=true";
}

public String gotoMaps(){
FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
return "/pages/user/map.xhtml?faces-redirect=true";
}
//******************************************************
private String pwds;
private String npwd;
private String pwdConfirm;
private int champs;

public int getChamps() {
return champs;
}
public void setChamps(int champs) {
this.champs = champs;
}
public String getPwds() {
return pwds;
}
public void setPwds(String pwd) {
this.pwds = pwd;
}
public String getNpwd() {
return npwd;
}
public void setNpwd(String npwd) {
this.npwd = npwd;
}
public String getPwdConfirm() {
return pwdConfirm;
}
public void setPwdConfirm(String pwdConfirm) {
this.pwdConfirm = pwdConfirm;
}
@Autowired
private UserServiceImpl userServiceImpl;

public String changepwd(){
	  User user1 = userRepository.findByEmail2(email);
			user1.setPassword(npwd);
			user1.setResetPasswordToken(npwd);
			userRepository.save(user1);
		
    return 
    "/loginAdmin.xhtml?faces-redirect=true";
}



public String registerUser()
{
	userService.addUser(new User(firstName,lastName,city, nationality,email, password,role,enabled));
	 return "/loginAdmin.xhtml?faces-redirect=true";

}









public User userconnecter(){
	return userRepository.userconnect(HomeController.connectedUser);
}






}

