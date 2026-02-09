package com.project.retail.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.retail.Exceptionhandling.NotFoundCustomException;

import com.project.retail.model.Product;
import com.project.retail.service.ProductService;

@RestController
@RequestMapping("/api")
public class productController {
	
	@Autowired 
	ProductService productservice;
	
	@PostMapping("/addproduct")
	public ResponseEntity<Product>addProducts(@RequestBody Product prod){
		
		Product addprod = productservice.addproduct(prod);
			return new ResponseEntity<Product>(addprod,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/searchProduct/{id}")
	public ResponseEntity<Product> searchProduct(@PathVariable int id){
		Product getProduct = productservice.getProduct(id)
				.orElseThrow(() -> new NotFoundCustomException("Product not found"));				
				return ResponseEntity.ok(getProduct);
		
	}

	@PutMapping("/updateProduct/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product prod){
		Product updateProd = productservice.updateProduct(id, prod);
		if(updateProd == null) {
			return ResponseEntity.notFound().build();
		}
		
		return new ResponseEntity<Product>(updateProd,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteProduct/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable int id){
		boolean deleteProd = productservice.deleteProduct(id);
		if(!deleteProd) {
			return ResponseEntity.notFound().build();
		}
		
		return new ResponseEntity<String>("Deleted Successfully",HttpStatus.OK);
		
	}
	
}
