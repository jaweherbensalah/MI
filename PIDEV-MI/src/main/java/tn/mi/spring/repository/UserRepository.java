package tn.mi.spring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tn.mi.spring.entities.Role;
import tn.mi.spring.entities.User;

@Repository
@Transactional(readOnly = true)
public interface UserRepository
        extends CrudRepository<User, Long> {

    Optional<User> findByEmail(String email);

    @Transactional
    @Modifying
    @Query("UPDATE User a " +
            "SET a.enabled = TRUE WHERE a.email = ?1")
    int enableAppUser(String email);

    public User findByResetPasswordToken(String token);
    
    @Query("SELECT c FROM User c WHERE c.email = ?1")
    public User findByEmail2(String email); 
    
	@Query(value = "SELECT     100*(SELECT count(*) FROM User where enabled =1) "
			+ "  /(SELECT count(*) FROM USER)", nativeQuery = true)
    public int stat_enabled();


	@Query(value = "SELECT     100*(SELECT count(*) FROM User where enabled =0) "
			+ "  /(SELECT count(*) FROM USER)", nativeQuery = true)
    public int stat_disabled();
	
	
	@Query("SELECT u FROM User u WHERE u.email= ?1")
	User getcode(String email);

	// @Query("select e from User e where e.email=:email and e.password=:password")
	//    public User getUserByEmailAndPassword(@Param("email")String email, @Param("password")String password);
	 
	    public User getUserByEmailAndPassword(String email, String password);
	   
	    @Query("select e from User e where e.firstName=:firstName ")
	    public User getUserByFirstName(String firstName);
	
//****************************************************************************
	    @Query("SELECT u FROM User u WHERE u.role= ?1")
		List<User> retrieveUsersByRole(Role role);
		
		@Modifying
		@Transactional
		@Query("update User u set u.enabled=1 where u.id = ?1")
		void verifiedaccount(Integer id);
		
	
		
		@Query("SELECT u FROM User u WHERE u.email= ?1 and u.password= ?2")
		User login(String email,String password);
		
	//***********************************************************
		 @Query("select  u from User u WHERE u.firstName=:f")
		    public List<User> rechercheuser(@Param("f") String user);



//******************************************************************************
@Query("select  u from User u WHERE u.email=:email")
public User userconnect(@Param("email") String user);

}