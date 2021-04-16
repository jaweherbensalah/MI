package tn.mi.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

public interface IServiceService {
	
	List<Service> retrieveAllServices(); 
	Service addService(Service s);
	
	void deleteService(Integer id);
	
	Service updateService(Service s); 
	
	List<Service> findByIdGreaterThan(int id);
	
	Service retrieveService(Integer serviceId);

}
