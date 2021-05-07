package tn.mi.spring.service;

import java.util.List;

import tn.mi.spring.entities.AnnonceReview;

public interface AnnReviewService {
	List<AnnonceReview> retrieveAllAnnonceReviews();
	AnnonceReview addAnnonceReview(AnnonceReview r);
	
	AnnonceReview updateAnnonceReview(AnnonceReview r);
	AnnonceReview retrieveAnnonceReview(long id);
	List<AnnonceReview> getAllReviewsByAnnonce(long annonceid);
	void deleteAnnonceReview(Long id);
	
	

}
