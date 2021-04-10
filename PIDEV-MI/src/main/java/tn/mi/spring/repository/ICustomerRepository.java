/**
 * 
 */
package tn.mi.spring.repository;

import org.springframework.data.repository.CrudRepository;

import tn.mi.spring.entities.Customer;
/**
 * @author guiforodrigue
 *
 */
public interface ICustomerRepository extends CrudRepository<Customer, Long>{

}
