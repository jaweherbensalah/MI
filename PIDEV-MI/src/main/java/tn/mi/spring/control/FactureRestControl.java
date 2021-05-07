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

import tn.esprit.spring.entity.Facture;

import tn.esprit.spring.service.IFactureService;




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
	public Facture retrieveFact(@PathVariable("facture_id") String fact_id){
		return factService.retrieveFact(fact_id);
	}

	//ajout 
	/*  
	   {

 "idClient":"3","nomclient": "OMAR","telephone": 54657343,"quantite": 8,"tva": 0.13,"nb": "attention verifier le montant","date_debut": "2021-04-01T00:00:00", "date_fin": "2021-04-17T00:00:00","type_produit": "EDUCATION","type_paiement": "carte_bancaire","reduction":0.14,"email": "khouloudabd512@gmail.com"
}
*/
	//URL :http://localhost:8088/SpringMVC/servlet/add_facture
	@PostMapping("/add_facture")

	public Facture addFact (@RequestBody Facture fact){
		Facture facture=factService.addFact(fact);

		return facture;

	}

	//supprimer 
	//URL :http://localhost:8088/SpringMVC/servlet/remove_facture/{facture_id}
	@DeleteMapping("/remove_facture/{facture_id}")

	public  void removeFact(@PathVariable("facture_id") String fact_id){
		factService.deleteFact(fact_id);



	}
	//update:modifier 
	//URL :http://localhost:8088/SpringMVC/servlet/modify_facture
	@PutMapping("modify_facture")
	public Facture updateFact (@RequestBody Facture fact){
		return factService.updateFact(fact);

	}
	//POUR envoyer un mail de notification
	//URL :http://localhost:8088/SpringMVC/servlet/notificationmail
	@GetMapping("/notificationmail")
	public void notificationmail(){
		factService.NotificationMail();

	}
	// URL :http://localhost:8088/SpringMVC/servlet/nbreFactures
	@GetMapping(value = "nbreFactures")
	@ResponseBody
	public int  nbreFactures() {

		return factService.nbreFactures();
	}
	// URL :http://localhost:8088/SpringMVC/servlet/nbreFacturesAgricole
	@GetMapping(value = "nbreFacturesAgricole")
	@ResponseBody
	public int  nbreFacturesAgricole() {

		return factService.nbreFacturesAgricole();
	}
	// URL :http://localhost:8088/SpringMVC/servlet/nbreFacturesSante
	@GetMapping(value = "nbreFacturesSante")
	@ResponseBody
	public int  nbreFacturesSante() {

		return factService.nbreFacturesSante();
	}
	// URL :http://localhost:8088/SpringMVC/servlet/nbreFacturesEducation
	@GetMapping(value = "nbreFacturesEducation")
	@ResponseBody
	public int  nbreFacturesEducation() {

		return factService.nbreFacturesEducation();
	}


	// URL :http://localhost:8088/SpringMVC/servlet/SommeMontantFacture
	@GetMapping(value = "SommeMontantFacture")
	@ResponseBody
	public double  SommeMontantFacture() {

		return factService.SommeMontantFacture();
	}
	// URL :http://localhost:8088/SpringMVC/servlet/SommeMontantFactureAgricole
	@GetMapping(value = "SommeMontantFactureAgricole")
	@ResponseBody
	public double  SommeMontantFactureAgricole() {

		return factService.SommeMontantFactureAgricole();
	}

	// URL :http://localhost:8088/SpringMVC/servlet/SommeMontantFactureEducation
	@GetMapping(value = "SommeMontantFactureEducation")
	@ResponseBody
	public double  SommeMontantFactureEducation() {

		return factService.SommeMontantFactureEducation();
	}

	// URL :http://localhost:8088/SpringMVC/servlet/SommeMontantFactureSante
	@GetMapping(value = "SommeMontantFactureSante")
	@ResponseBody
	public double  SommeMontantFactureSante() {

		return factService.SommeMontantFactureSante();
	}


	// URL :http://localhost:8088/SpringMVC/servlet/StatistiqueAgricole
	
	@GetMapping(value = "StatistiqueAgricole")
	@ResponseBody
	public double  StatistiqueAgricole() {
		return factService.StatiqueAgricole();

	}
	// URL :http://localhost:8088/SpringMVC/servlet/StatistiqueSante
	@GetMapping(value = "StatistiqueSante")
	@ResponseBody
	public double  StatistiqueSante() {
		return factService.StatiqueSante();

	}

	// URL :http://localhost:8088/SpringMVC/servlet/StatistiqueEducation
	@GetMapping(value = "StatistiqueEducation")
	@ResponseBody
	public double  StatistiqueEducation() {
		return factService.StatiqueEducation();

	}




}
