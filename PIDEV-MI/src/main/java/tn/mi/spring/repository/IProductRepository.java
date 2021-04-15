package tn.mi.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.mi.spring.entities.Product;


@Repository
public interface IProductRepository extends CrudRepository<Product, Integer> {
	

}
