package tn.mi.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface IServiceRepository extends CrudRepository<Service, Integer> {

}
