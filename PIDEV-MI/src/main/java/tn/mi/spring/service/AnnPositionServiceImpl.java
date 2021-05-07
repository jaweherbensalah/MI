package tn.mi.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.mi.spring.entities.Annonce;
import tn.mi.spring.entities.AnnoncePosition;
import tn.mi.spring.entities.AnnonceReview;
import tn.mi.spring.repository.AnnoncePositionRepository;
import tn.mi.spring.repository.AnnonceRepository;
import tn.mi.spring.repository.AnnoncePositionRepository;

@Service
public class AnnPositionServiceImpl implements AnnPositionService{

	@Autowired
	AnnoncePositionRepository annPosRepository;
	@Autowired
	AnnonceRepository annRepository;

	private static final Logger L=LogManager.getLogger(AnnServiceImpl.class);

	@Override
	public List<AnnoncePosition> retrieveAllAnnoncePositions() {
		List<AnnoncePosition> AnnoncePositions=(List<AnnoncePosition>) annPosRepository.findAll();
		for(AnnoncePosition annoncePos:AnnoncePositions){
		L.info("user +++ : "+ annoncePos);}
		return AnnoncePositions;
	}
	
	
	@Override
	public AnnoncePosition addAnnoncePosition(AnnoncePosition r){
		return annPosRepository.save(r);
		
	}
	@Override
	public AnnoncePosition updateAnnoncePosition(AnnoncePosition r){
		return annPosRepository.save(r);
		
	}

	@Override
	public AnnoncePosition getAnnoncePosByAnnId(Long annonceId) {
		return annPosRepository.retrieveAnnPos(annonceId);
		
	}


	
	public AnnoncePosition retrieveAnnoncePosition(long id) {
		AnnoncePosition r;
		r=annPosRepository.findById(id).orElse(null);
		return r;
		
	}
	
	
	
	
	
	
	

}
