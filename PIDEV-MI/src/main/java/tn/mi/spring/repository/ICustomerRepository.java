/**
 * 
 */
package tn.mi.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.mi.spring.entities.Customer;
/**
 * @author guiforodrigue
 *
 */
@Repository
public interface ICustomerRepository extends CrudRepository<Customer, Long>{
	
	@Query(value = "SELECT COUNT(*) FROM t_customer", nativeQuery = true)
	long countCustomersWithContract();
	
	@Query(value = "SELECT  u.first_name, u.last_name, u.phone FROM t_user u LEFT JOIN contract c ON u.cl_id = c.customer_cl_id "
			+ "LEFT JOIN  Formular f ON f.formular_id = c.formular_formular_id"
			+ "WHERE u.cl_id = c.customer_cl_id "
			+ "AND c.contract_subscription_validate = true "
			+ "AND c.contract_cancelation = false"
			+ "f.name = ?1", nativeQuery = true)
	List<Customer> findCustomersByFormular(String name);
}
