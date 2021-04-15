package tn.mi.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.mi.spring.entities.Risk;

@Repository
public interface IRiskRepository extends CrudRepository<Risk, Integer>  {

}
