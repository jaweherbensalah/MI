
package tn.mi.spring.entities;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity

public class User implements UserDetails {
	private static final long serialVersionUID =1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotNull(message = "Name cannot be null")
	private String firstName;
	@NotNull(message = "Last name cannot be null")
	private String lastName;
	@NotNull(message = "City cannot be null")
	private String city;
	@NotNull(message = "Nationality cannot be null")
	private String nationality;

	@NotNull(message = "Email cannot be null")
	@Email(message = "Email should be valid")
	private String email;
	@NotNull(message = "Password cannot be null")
	@Size(min = 6, max = 200, message 
	= "Password must be between 6 and 200 characters")
	private String password;
	@Enumerated(EnumType.STRING)
	private Role role;
	private Boolean locked = false;
	private Boolean enabled = false;
	
	private String resetPasswordToken;
	private int random;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	private Set<Fiche> fiche;
	public Set<Fiche> getFiche() {
		return fiche;
	}
	public void setFiche(Set<Fiche> fiche) {
		this.fiche = fiche;
	}
//*********************ctor pour l'email et tout ça ...
	//****************************************************
    public User(String firstName,
                   String lastName,String city,String nationality,
                   String email,
                   String password,
                   Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.nationality = nationality;
        this.email = email;
        this.password = password;
        this.role = role;
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

	public int getRandom() {
		return random;
	}

	public void setRandom(int random) {
		this.random = random;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getResetPasswordToken() {
		return resetPasswordToken;
	}

	public void setResetPasswordToken(String resetPasswordToken) {
		this.resetPasswordToken = resetPasswordToken;
	}

	//****************************************************


	@Override
	@JsonIgnore
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority authority =
				new SimpleGrantedAuthority(role.name());
		return Collections.singletonList(authority);
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return email;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return !locked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public Boolean getLocked() {
		return locked;
	}

	public void setLocked(Boolean locked) {
		this.locked = locked;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((enabled == null) ? 0 : enabled.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((locked == null) ? 0 : locked.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (role != other.role)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (enabled == null) {
			if (other.enabled != null)
				return false;
		} else if (!enabled.equals(other.enabled))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (locked == null) {
			if (other.locked != null)
				return false;
		} else if (!locked.equals(other.locked))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	public User(String firstName, String city,String nationality,String lastName, String email, String password, Role role,
			Boolean locked, Boolean enabled,String resetPasswordToken) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.nationality = nationality;
		this.email = email;
		this.password = password;
		this.role = role;
		this.locked = locked;
		this.enabled = enabled;
		this.resetPasswordToken=resetPasswordToken;
	}

	public User(Long id, String firstName, String lastName,String city,String nationality, String email, String password, Role role,
			Boolean locked, Boolean enabled,String resetPasswordToken) {
		super();
		this.id = id; 
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.nationality = nationality;
		this.email = email;
		this.password = password;
		this.role = role;
		this.locked = locked;
		this.enabled = enabled;
		this.resetPasswordToken=resetPasswordToken;
	}
	public User(){}
<<<<<<< HEAD

	public User(Long id,String firstName, String lastName, String city, String nationality, String email, String password,
			Role role, Boolean enabled) {
		
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.nationality = nationality;
		this.email = email;
		this.password = password;
		this.role = role;
		//this.locked = locked;
		this.enabled = enabled;
		//this.resetPasswordToken=resetPasswordToken;
		
	}

	public User(String firstName, String lastName, String city, String nationality, String email, String password,
			Role role, Boolean enabled) {
	
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.nationality = nationality;
		this.email = email;
		this.password = password;
		this.role = role;
		//this.locked = locked;
		this.enabled = enabled;
		//this.resetPasswordToken=resetPasswordToken;
		
	}




}
=======
}
>>>>>>> 55c688cee2ffac8c67f099a970e9a21547c4f941
