package tn.mi.spring.repository;



import java.util.List;




import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import tn.mi.spring.entities.Facture;

@Repository
public interface FactureRepository extends CrudRepository<Facture,Long>{
public List<Facture> findByIdClient(Long idClient);

@Query("SELECT count(*) FROM Facture")
public int countfacture();
@Query("SELECT count(*) FROM Facture where type_produit='SANTE'")
public int countsante();
@Query("SELECT count(*) FROM Facture where type_produit='AGRICOLE' ")
public int countagricole();
@Query("SELECT count(*) FROM Facture where type_produit='EDUCATION' ")
public int counteducation();
@Query("SELECT SUM(Total_reduction) FROM Facture ")
public double SommeFacture();
@Query("SELECT SUM(Total_reduction) FROM Facture where type_produit='AGRICOLE'")
public double SommeFactureAgricole();
@Query("SELECT SUM(Total_reduction) FROM Facture where type_produit='EDUCATION' ")
public double SommeFactureEducation();
@Query("SELECT SUM(Total_reduction) FROM Facture where type_produit='SANTE' ")
public double SommeFactureSante();




}
