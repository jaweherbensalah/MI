package tn.mi.spring.repository;


import org.springframework.data.jpa.repository.Query;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.mi.spring.entities.Indemnisation;


@Repository
public interface IndemnisationRepository extends CrudRepository <Indemnisation,Long> {
	
	@Query("SELECT count(*) FROM Indemnisation")
	public int countIndemnisation();
	@Query("SELECT count(*) FROM Indemnisation where type_produit='SANTE'")
	public int countIndemnisationsante();
   @Query("SELECT count(*) FROM Indemnisation where type_produit='AGRICOLE'")
	public int countIndemnisationagricole();
	@Query("SELECT count(*) FROM Indemnisation where type_produit='EDUCATION'")
	public int countIndemnisationeducation();
	@Query("SELECT SUM(montant) FROM Indemnisation ")
	public double SommeIndemnisation();
	@Query("SELECT SUM(montant) FROM Indemnisation where type_produit='AGRICOLE'")
	public double SommeIndemnisationAgricole();
	@Query("SELECT SUM(montant) FROM Indemnisation where type_produit='EDUCATION'")
	public double SommeIndemnisationEducation();
	@Query("SELECT SUM(montant) FROM Indemnisation where type_produit='SANTE'")
	public double SommeIndemnisationSante();

}
