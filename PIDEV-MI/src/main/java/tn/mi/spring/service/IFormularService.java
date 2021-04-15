package tn.mi.spring.service;

import java.util.List;

import tn.mi.spring.entities.Formular;

public interface IFormularService {
	
	List<Formular> retrieveAllFormulars(); 
	Formular addFormular(Formular f);
	
	void deleteFormular(Integer id);
	
	Formular updateFormular(Formular p); 
	
	List<Formular> findByIdGreaterThan(int id);
	
	Formular retrieveFormular(Integer formularId);

	
}
