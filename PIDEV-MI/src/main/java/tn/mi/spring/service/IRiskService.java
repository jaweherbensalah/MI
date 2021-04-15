package tn.mi.spring.service;

import java.util.List;

import tn.mi.spring.entities.Risk;

public interface IRiskService {
	
	List<Risk> retrieveAllRisks(); 
	Risk addRisk(Risk r);
	
	void deleteRisk(Integer id);
	
	Risk updateRisk(Risk r); 
	
	List<Risk> findByIdGreaterThan(int id);
	
	Risk retrieveRisk(Integer riskId);

}
