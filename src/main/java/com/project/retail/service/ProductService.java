package com.project.retail.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.retail.model.Product;
import com.project.retail.repository.product;

@Service
public class ProductService {
	@Autowired
	product prodrepo;
	
	public Product addproduct(Product prod) {
		checkValidateName(prod.getProductName());
		return prodrepo.save(prod);
		
	}
	
	private boolean checkValidateName(String name) {
		if(name == null || name.isEmpty()) {
			return false;
		}
		return true;
		
	}
	
	public Optional<Product> getProduct(int id) {
		return prodrepo.findById(id);
	}
	
	public Product updateProduct(int id, Product prod) {
		if(prodrepo.existsById(id)) {
			prod.setProductId(id);
			return prodrepo.save(prod);			
		}
		
		return null;		
	}
	
	public boolean deleteProduct(int id) {
		if(prodrepo.existsById(id)) {
			prodrepo.deleteById(id);
			return true;
		}
		
		return false;
	}

	
}
