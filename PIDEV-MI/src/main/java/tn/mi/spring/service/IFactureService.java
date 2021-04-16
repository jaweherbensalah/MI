package tn.mi.spring.service;




import java.text.ParseException;

import java.util.List;

import tn.mi.spring.entities.Facture;




public interface IFactureService{
	List<Facture> retrieveAllFact();
    Facture addFact(Facture fact);
	void deleteFact(String Nfacture);
	Facture updateFact(Facture fact);
	
	 Facture retrieveFact(String Nfacture);
	 public void NotificationMail () ;
	 public Facture consulterFacture(String Nfacture);
	 public int nbreFactures();
	 public int nbreFacturesSante();
	 public int nbreFacturesAgricole();
	 public int nbreFacturesEducation();
	 public double SommeMontantFacture();
	 public double SommeMontantFactureAgricole();
	 public double SommeMontantFactureSante();
	 public double SommeMontantFactureEducation();
	 public double StatiqueAgricole();
	 public double StatiqueEducation();
	 public double StatiqueSante();
	 
	


}
