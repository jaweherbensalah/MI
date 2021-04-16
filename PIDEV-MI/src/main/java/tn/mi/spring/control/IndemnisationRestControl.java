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
		public Indemnisation retrieveIndem(@PathVariable("indemnisation_id") String Indemn_id){
			return indemnService.retrieveIndemn(Indemn_id);
		}
		
		//ajout 
		/*{
    	
 "id":"1","nom": "khouloud","quantite": 8,"date_debut": "2021-04-01T00:00:00", "date_fin": "2021-04-17T00:00:00","type_produit": "EDUCATION","virement": "carte_bancaire","email": "khouloudabd512@gmail.com"

}*/
		//URL :http://localhost:8088/SpringMVC/servlet/add_indemnisation
		@PostMapping("/add_indemnisation")
		
		public Indemnisation addIndem (@RequestBody Indemnisation indemn){
			Indemnisation indemnisation=indemnService.addIndemn(indemn);
			return indemnisation;
			
		}

		//supprimer 
				//URL :http://localhost:8088/SpringMVC/servlet/remove_indemnisation/{indemnisation_id}
		@DeleteMapping("/remove_indemnisation/{indemnisation_id}")
		
		public  void removeIndem(@PathVariable("indemnisation_id") String Indemn_id){
			indemnService.deleteIndemn(Indemn_id);
			
			
		}
		//update:modifier 
		//URL :http://localhost:8088/SpringMVC/servlet/modify_indemnisation
		@PutMapping("modify_indemnisation")
		public Indemnisation updateIndem (@RequestBody Indemnisation indemn){
			return indemnService.updateIndemn(indemn);
		}
		
		
		
		// URL :http://localhost:8088/SpringMVC/servlet/nbreIndemnisation
	    @GetMapping(value = "nbreIndemnisation")
	    @ResponseBody
		public int  nbreIndemnisation() {
			
			return indemnService.nbreIndemnisation();
		}
		// URL :http://localhost:8088/SpringMVC/servlet/nbreIndemnisationAgricole
	    @GetMapping(value = "nbreIndemnisationAgricole")
	    @ResponseBody
		public int  nbreIndemnisationAgricole() {
			
			return indemnService.nbreIndemnisationAgricole();
		}
		// URL :http://localhost:8088/SpringMVC/servlet/nbreIndemnisationSante
	    @GetMapping(value = "nbreIndemnisationSante")
	    @ResponseBody
		public int  nbreIndemnisationSante() {
			
			return indemnService.nbreIndemnisationSante();
		}
		// URL :http://localhost:8088/SpringMVC/servlet/nbreIndemnisationEducation
	    @GetMapping(value = "nbreIndemnisationEducation")
	    @ResponseBody
		public int  nbreIndemnisationEducation() {
			
			return indemnService.nbreIndemnisationEducation();
		}
		
			
		// URL :http://localhost:8088/SpringMVC/servlet/SommeMontantIndemnisation
	    @GetMapping(value = "SommeMontantIndemnisation")
	    @ResponseBody
		public double SommeMontantIndemnisation() {
			
			return indemnService.SommeMontantIndemnisation();
		}
		// URL :http://localhost:8088/SpringMVC/servlet/SommeMontantIndemnisationAgricole
	    @GetMapping(value = "SommeMontantIndemnisationAgricole")
	    @ResponseBody
		public double SommeMontantIndemnisationAgricole() {
			
			return indemnService.SommeMontantIndemnisationAgricole();
		}
			
		// URL :http://localhost:8088/SpringMVC/servlet/SommeMontantIndemnisationEducation
	    @GetMapping(value = "SommeMontantIndemnisationEducation")
	    @ResponseBody
		public double  SommeMontantIndemnisationEducation() {
			
			return indemnService.SommeMontantIndemnisationEducation();
		}
			
		// URL :http://localhost:8088/SpringMVC/servlet/SommeMontantIndemnisationSante
	    @GetMapping(value = "SommeMontantIndemnisationSante")
	    @ResponseBody
		public double SommeMontantIndemnisationSante() {
			
			return indemnService.SommeMontantIndemnisationSante();
		}
			
	    	
		// URL :http://localhost:8088/SpringMVC/servlet/StatiqueIndemnisationAgricole
	    @GetMapping(value = "StatiqueIndemnisationAgricole")
	    @ResponseBody
		public double  StatiqueIndemnisationAgricole() {
	    	return indemnService.StatiqueIndemnisationAgricole();
				
		}
	 // URL :http://localhost:8088/SpringMVC/servlet/StatiqueIndemnisationSante
	    @GetMapping(value = "StatiqueIndemnisationSante")
	    @ResponseBody
		public double  StatiqueIndemnisationSante() {
	    	return indemnService.StatiqueIndemnisationSante();
				
		}
			
	 // URL :http://localhost:8088/SpringMVC/servlet/StatiqueIndemnisationEducation
	    @GetMapping(value = "StatiqueIndemnisationEducation")
	    @ResponseBody
		public double  StatiqueIndemnisationEducation() {
	    	
	    	return indemnService.StatiqueIndemnisationEducation();
				
		}
		
		
}
