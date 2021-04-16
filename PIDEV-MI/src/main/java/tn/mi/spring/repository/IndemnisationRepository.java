package tn.mi.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.mi.spring.entities.Indemnisation;


@Repository
public interface IndemnisationRepository extends CrudRepository <Indemnisation,Long> {

}
