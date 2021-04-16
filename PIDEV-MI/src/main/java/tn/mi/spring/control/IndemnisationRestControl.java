package tn.mi.spring.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.mi.spring.entities.Indemnisation;
import tn.mi.spring.service.IIndemnisationService;

@RestController
public class IndemnisationRestControl {
	
	@Autowired
	IIndemnisationService indemnService;
	
	//URL :http://localhost:8088/SpringMVC/servlet/retrieve_all_indemnisation
	@GetMapping("/retrieve_all_indemnisation")
	public List<Indemnisation> retrieveAllIndemn() {
		List<Indemnisation> list=indemnService.retrieveAllIndemn();
	
		return list;
	}
	
	//URL :http://localhost:8088/SpringMVC/servlet/retrieve_indemnisation/{indemnisation_id}
		@GetMapping("/retrieve_indemnisation/{indemnisation_id}")
		public Indemnisation retrieveIndem(@PathVariable("Indemn_ID") String Indemn_id){
			return indemnService.retrieveIndemn(Indemn_id);
		}
		
		//ajout 
		//URL :http://localhost:8088/SpringMVC/servlet/add_indemnisation
		@PostMapping("/add_indemnisation")
		
		public Indemnisation addIndem (@RequestBody Indemnisation indemn){
			Indemnisation indemnisation=indemnService.addIndemn(indemn);
			return indemnisation;
			
		}

		//supprimer 
				//URL :http://localhost:8088/SpringMVC/servlet/remove_indemnisation/{indemnisation_id}
		@DeleteMapping("/remove_indemnisation/{indemnisation_id}")
		
		public  void removeIndem(@PathVariable("Indemn_ID") String Indemn_id){
			indemnService.deleteIndemn(Indemn_id);
			
			
		}
		//update:modifier 
		//URL :http://localhost:8088/SpringMVC/servlet/modify_indemnisation
		@PutMapping("modify_indemnisation")
		public Indemnisation updateIndem (@RequestBody Indemnisation indemn){
			return indemnService.updateIndemn(indemn);
		}
		
		
}
