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

import tn.mi.spring.entities.Facture;
import tn.mi.spring.service.IFactureService;



@RestController
public class FactureRestControl {
	
	@Autowired
	IFactureService factService;
	
	//URL :http://localhost:8088/SpringMVC/servlet/retrieve_all_facture
	@GetMapping("/retrieve_all_facture")
	public List<Facture> retrieveAllFat() {
		List<Facture> list=factService.retrieveAllFact();
	
		return list;
	}
	
	
	
	//URL :http://localhost:8088/SpringMVC/servlet/retrieve_facture/{facture_id}
			@GetMapping("/retrieve_facture/{facture_id}")
			public Facture retrieveFact(@PathVariable("Fact_ID") String fact_id){
				return factService.retrieveFact(fact_id);
			}
			
			//ajout 
			//URL :http://localhost:8088/SpringMVC/servlet/add_facture
			@PostMapping("/add_facture")
			
			public Facture addFact (@RequestBody Facture fact){
				Facture facture=factService.addFact(fact);
						
				return facture;
				
			}

			//supprimer 
					//URL :http://localhost:8088/SpringMVC/servlet/remove_facture/{facture_id}
			@DeleteMapping("/remove_facture/{facture_id}")
			
			public  void removeFact(@PathVariable("Fact_ID") String fact_id){
				factService.deleteFact(fact_id);
				
				
				
			}
			//update:modifier 
			//URL :http://localhost:8088/SpringMVC/servlet/modify_facture
			@PutMapping("modify_facture")
			public Facture updateFact (@RequestBody Facture fact){
				return factService.updateFact(fact);
				
			}
			
}
