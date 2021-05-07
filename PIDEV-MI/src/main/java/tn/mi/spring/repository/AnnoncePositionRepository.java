package tn.mi.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tn.mi.spring.entities.Annonce;
import tn.mi.spring.entities.AnnoncePosition;

@Repository
public interface AnnoncePositionRepository extends CrudRepository<AnnoncePosition, Long> {
	
	@Query("SELECT u FROM AnnoncePosition u WHERE u.annoncePosition.id =:annonceId  ")
	public AnnoncePosition retrieveAnnPos( @Param("annonceId")Long annonceId);
	

}
