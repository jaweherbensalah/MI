package tn.mi.spring.control;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.mi.spring.entities.Customer;
import tn.mi.spring.service.ICustomerService;



@RestController
public class CustomerRestController {
	@Autowired
	ICustomerService customerService;
	
	// http://localhost:8081/SpringMVC/servlet/retrieve-all-customers
	@GetMapping("/retrieve-all-customers")
	@ResponseBody
	public List<Customer> getCustomers() {
		List<Customer> list = customerService.retrieveAllCustomers();
		return list;
    }
	// http://localhost:8081/SpringMVC/servlet/count-Customers-With-Current-Contract
		@GetMapping("/count-Customers-With-Current-Contract")
		@ResponseBody
		public Long getNomberCurrentCustomers() {
			long nc = customerService.countCustomersWithCurrentContract();
			return nc;
	    }
	// http://localhost:8081/SpringMVC/servlet/retrieve-customer/{customer-id}
	@GetMapping("/retrieve-customer/{customer-id}")
	@ResponseBody
	public Customer retrieveCustomer(@PathVariable("customer-id") String customerId) {
		return customerService.retrieveCustomer(customerId);
	}
	
	// Ajouter Customer : http://localhost:8081/SpringMVC/servlet/add-customer
	@PostMapping("/add-customer")
	@ResponseBody
	public Customer addCustomer(@RequestBody Customer c) {
		Customer customer = customerService.addCustomer(c);
		return customer;
	}
	
	// http://localhost:8081/SpringMVC/servlet/remove-customer/{customer-id}
	@DeleteMapping("/remove-customer/{customer-id}")
	@ResponseBody
	public void removeCustomer(@PathVariable("customer-id") String customerId) {
		customerService.deleteCustomer(customerId);
	}
	
	// http://localhost:8081/SpringMVC/servlet/modify-customer
	@PutMapping("/modify-customer")
	@ResponseBody
	public Customer modifyUser(@RequestBody Customer customer) {
		return customerService.updateCustomer(customer);
	}
}
