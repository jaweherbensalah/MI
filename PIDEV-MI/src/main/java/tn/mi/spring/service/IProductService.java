package tn.mi.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import tn.mi.spring.entities.Product;

@Service
public interface IProductService {
	
	List<Product> retrieveAllProducts(); 
	
	Product addProduct(Product p);
	
	void deleteProduct(Integer id);
	
	Product updateProduct(Product p); 
	
	List<Product> findByIdGreaterThan(int id);
	
	Product retrieveProduct(Integer productId);

}
