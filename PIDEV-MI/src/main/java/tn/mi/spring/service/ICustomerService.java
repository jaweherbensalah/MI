/**
 * 
 */
package tn.mi.spring.service;

import java.util.List;

import tn.mi.spring.entities.Customer;

/**
 * @author guiforodrigue
 *
 */
public interface ICustomerService {

	List<Customer> retrieveAllCustomers();

	Customer addCustomer(Customer c);

	Customer updateCustomer(Customer c);
	
	void deleteCustomer(String id);
	
	Customer retrieveCustomer(String id);
	
	long countCustomersWithCurrentContract();
}
