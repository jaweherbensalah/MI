package tn.mi.spring.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.mi.spring.entities.Facture;
import tn.mi.spring.repository.FactureRepository;


@Service
public class FactureServiceImpl implements IFactureService{

	@Autowired
	FactureRepository factRepository;
	private static final Logger L=LogManager.getLogger(FactureServiceImpl.class);
	
	@Override
	public List<Facture> retrieveAllFact() {
		List<Facture> factures=(List<Facture>) factRepository.findAll();
		for(Facture facture : factures){
			L.info("facture::::::::::::::" + facture);
		}
		return factures;

	}

	@Override
	public Facture addFact(Facture fact) {
		Facture factSaved=null;
		factSaved=factRepository.save(fact);

		return factSaved;
	}

	@Override
	public void deleteFact(String Nfacture) {
		factRepository.deleteById(Long.parseLong(Nfacture));
		
	}

	@Override
	public Facture updateFact(Facture fact) {
		return factRepository.save(fact);
	}

	@Override
	public Facture retrieveFact(String Nfacture) {
		L.info(("au niveau de retrievefacture le numero de facture = " +Nfacture));
		Facture fact = factRepository.findById(Long.parseLong(Nfacture)).orElse(null);
		
		L.info("le facture fact returned : "+fact);
		return fact;
	}

}
