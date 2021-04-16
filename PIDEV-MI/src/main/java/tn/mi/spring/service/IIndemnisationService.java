package tn.mi.spring.service;

import java.util.List;



import tn.mi.spring.entities.Indemnisation;



public interface IIndemnisationService {
	
	List<Indemnisation> retrieveAllIndemn();
	Indemnisation addIndemn(Indemnisation Indemn);
	void deleteIndemn(String num_ind);
	Indemnisation updateIndemn(Indemnisation Indemn);
	Indemnisation retrieveIndemn(String num_ind);
	 public int nbreIndemnisation();
	 public int nbreIndemnisationSante();
	 public int nbreIndemnisationAgricole();
	 public int nbreIndemnisationEducation();
	 public double SommeMontantIndemnisation();
	 public double SommeMontantIndemnisationAgricole();
	 public double SommeMontantIndemnisationSante();
	 public double SommeMontantIndemnisationEducation();
	 public double StatiqueIndemnisationAgricole();
	 public double StatiqueIndemnisationEducation();
	 public double StatiqueIndemnisationSante();
 

}
