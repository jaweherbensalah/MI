package tn.mi.spring.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.mi.spring.entities.Service;


@Repository
public interface IServiceRepository extends CrudRepository<Service, Integer> {

}
