/**
 * 
 */
package tn.mi.spring.service;

/**
 * @author guiforodrigue
 *
 */
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tn.mi.spring.service.ICustomerService;
import tn.mi.spring.service.CustomerServiceImpl;
import tn.mi.spring.entities.Customer;
import tn.mi.spring.repository.ICustomerRepository;

@Repository
public class CustomerServiceImpl implements ICustomerService{

	@Autowired
	ICustomerRepository customerRepository;
	
	private static final Logger l = LogManager.getLogger(CustomerServiceImpl.class);
	
	@Override
	public List<Customer> retrieveAllCustomers(){
		List<Customer> customers = (List<Customer>) customerRepository.findAll();
		for (Customer customer : customers){
			l.info("customer +++ :" + customer);
		}
		return customers;
	}
	@Override
	public long countCustomersWithCurrentContract()
	{
		return customerRepository.countCustomersWithContract();
	}
	
	@Override
	public Customer addCustomer(Customer c){
		Customer customerSaved = null;
		customerSaved = (Customer) customerRepository.save(c);
		return customerSaved;
		
	}
	@Override
	public Customer updateCustomer(Customer c){
		Customer customerAdded = (Customer) customerRepository.save(c);
		return customerAdded;
	}
	@Override
	public void deleteCustomer(String id){
		customerRepository.deleteById(Long.parseLong(id));
	}
	
	@Override
	public Customer retrieveCustomer(String id){
		l.info("in retrieveCustomer id = " + id);
		Customer c = customerRepository.findById(Long.parseLong(id)).orElse(null);
		l.info("customer return " + c);
		return c;
		
	}
}
