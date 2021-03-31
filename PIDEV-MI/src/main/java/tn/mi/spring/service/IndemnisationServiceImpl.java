package tn.mi.spring.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.mi.spring.entities.Indemnisation;
import tn.mi.spring.repository.IndemnisationRepository;

@Service
public class IndemnisationServiceImpl implements IIndemnisationService{
	
	@Autowired
	IndemnisationRepository indemnRepository;
	private static final Logger L=LogManager.getLogger(IndemnisationServiceImpl.class);
	
	@Override
	public List<Indemnisation> retrieveAllIndemn() {
		List<Indemnisation> indemnisations=(List<Indemnisation>) indemnRepository.findAll();
		for(Indemnisation indemnisation : indemnisations){
			L.info("Indemnisation::::::::::::::" + indemnisation);
		}
		return indemnisations;
	}

	@Override
	public Indemnisation addIndemn(Indemnisation Indemn) {
		 Indemnisation indemnSaved=null;
		indemnSaved=indemnRepository.save(Indemn);

		return indemnSaved;
	}

	@Override
	public void deleteIndemn(String num_ind) {
	indemnRepository.deleteById(Long.parseLong(num_ind));
		
	}

	@Override
	public Indemnisation updateIndemn(Indemnisation Indemn) {
		return indemnRepository.save(Indemn);
	}

	@Override
	public Indemnisation retrieveIndemn(String num_ind) {
		L.info(("au niveau de retrieveindemnisation le numero de l indemnisation  =  " +num_ind));
		
		Indemnisation Indemn= indemnRepository.findById(Long.parseLong(num_ind)).get();
		L.info("l indemnisation Indemn returned : "+Indemn);
		return Indemn;
	}

}
