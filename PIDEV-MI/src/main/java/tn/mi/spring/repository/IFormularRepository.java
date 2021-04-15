package tn.mi.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.mi.spring.entities.Formular;

@Repository
public interface IFormularRepository extends CrudRepository <Formular, Integer> {
	

}
