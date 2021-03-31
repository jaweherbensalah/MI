package tn.mi.spring.service;

import java.util.List;

import tn.mi.spring.entities.Facture;



public interface IFactureService{
	List<Facture> retrieveAllFact();
    Facture addFact(Facture fact);
	void deleteFact(String Nfacture);
	Facture updateFact(Facture fact);
	 Facture retrieveFact(String Nfacture);


}
