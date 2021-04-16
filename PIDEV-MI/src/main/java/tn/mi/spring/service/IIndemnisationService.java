package tn.mi.spring.service;

import java.util.List;

import tn.mi.spring.entities.Indemnisation;



public interface IIndemnisationService {
	List<Indemnisation> retrieveAllIndemn();
	Indemnisation addIndemn(Indemnisation Indemn);
	void deleteIndemn(String num_ind);
	Indemnisation updateIndemn(Indemnisation Indemn);
	Indemnisation retrieveIndemn(String num_ind);


}
