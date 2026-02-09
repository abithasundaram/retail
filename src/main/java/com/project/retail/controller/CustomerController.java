package com.project.retail.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.retail.model.Customer;
import com.project.retail.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerController {
	
	@Autowired
	CustomerService customerservice;
	
	@PostMapping("addCustomer")
	public ResponseEntity<?> addCustomer(@RequestBody Customer cus) {
		Customer response = customerservice.addCustomer(cus);		
		return new ResponseEntity<Customer>(response,HttpStatus.CREATED);
	}

	
	@GetMapping("/search/{id}")
	public ResponseEntity<Customer> searchCustomer(@PathVariable int id){
		Optional<Customer> searchResponse = customerservice.searchCustomer(id);
		return searchResponse.map(customer-> ResponseEntity.ok(customer))
				.orElse(ResponseEntity.notFound().build());

		
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable int id, @RequestBody Customer cus){
	Customer updatedcustomer = customerservice.updateCustomer(id, cus);
	if(updatedcustomer == null) {
		return ResponseEntity.notFound().build();
	}else {
		return ResponseEntity.ok(updatedcustomer);
	}
		

}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable int id){
		boolean result = customerservice.deleteCustomer(id);
		if(!result) {
			return new ResponseEntity<String>("Customer not Exist",HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<String>("Customer details deleted Successfully",HttpStatus.OK);
		}
	}

}
