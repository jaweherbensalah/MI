package tn.mi.spring.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.mi.spring.entities.Product;
import tn.mi.spring.service.IProductService;

@RestController
public class ProductRestControl {
	
	@Autowired
	IProductService productService; 
	
	// http://localhost:8081/SpringMVC/servlet/retrieve-all-product
		@GetMapping("/retrieve-all-products")
		@ResponseBody
		public List<Product> getProducts() {
		List<Product> list = productService.retrieveAllProducts();
		return list;
		}
		
		// http://localhost:8081/SpringMVC/servlet/retrieve-product/{Product-id}
		@GetMapping("/retrieve-product/{Product-id}")
		@ResponseBody
		public Product retrieveProduct(@PathVariable("Product-id") Integer ProductId) {
		return productService.retrieveProduct(ProductId);
		}
		
		// Ajouter Product : http://localhost:8081/SpringMVC/servlet/add-product
		@PostMapping("/add-product")
		@ResponseBody
		public Product addProduct(@RequestBody Product p) {
		Product product = productService.addProduct(p);
				return product;
		}
		
		// http://localhost:8081/SpringMVC/servlet/remove-product/{product-id}
		@DeleteMapping("/remove-product/{product-id}")
		@ResponseBody
		public void removeProduct(@PathVariable("product-id") Integer productId) {
		productService.deleteProduct(productId);
		}

		// http://localhost:8081/SpringMVC/servlet/modify-product
		@PutMapping("/modify-product")
		@ResponseBody
		public Product modifyUser(@RequestBody Product product) {
		return productService.updateProduct(product);
		}

}
