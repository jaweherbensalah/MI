package tn.mi.spring.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.mi.spring.service.IServiceService;

@RestController
public class ServiceRestControl {
	
	@Autowired
	IServiceService serviceService; 
	
	// http://localhost:8081/SpringMVC/servlet/retrieve-all-service
		@GetMapping("/retrieve-all-service")
		@ResponseBody
		public List<Service> getServices() {
		List<Service> list = serviceService.retrieveAllServices();
		return list;
		}
		
		// http://localhost:8081/SpringMVC/servlet/retrieve-service/{Service-id}
		@GetMapping("/retrieve-service/{service-id}")
		@ResponseBody
		public Service retrieveService(@PathVariable("service-id") Integer ServiceId) {
		return serviceService.retrieveService(ServiceId);
		}
		
		// Ajouter Service : http://localhost:8081/SpringMVC/servlet/add-service
		@PostMapping("/add-service")
		@ResponseBody
		public Service addservice(@RequestBody Service f) {
			Service service = serviceService.addService(f);
			return service;
		}
		
		// http://localhost:8081/SpringMVC/servlet/remove-service/{service-id}
		@DeleteMapping("/remove-service/{service-id}")
		@ResponseBody
		public void removeService(@PathVariable("service-id") Integer serviceId) {
		serviceService.deleteService(serviceId);
		}

		// http://localhost:8081/SpringMVC/servlet/modify-service
		@PutMapping("/modify-service")
		@ResponseBody
		public Service modifyService(@RequestBody Service service) {
		return serviceService.updateService(service);
		}

}
