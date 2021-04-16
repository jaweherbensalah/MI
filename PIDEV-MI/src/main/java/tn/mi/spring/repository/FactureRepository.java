package tn.mi.spring.repository;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import tn.mi.spring.entities.Facture;


@Repository
public interface FactureRepository extends CrudRepository<Facture,Long>{

}
