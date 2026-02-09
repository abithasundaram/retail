package com.project.retail.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.retail.model.Customer;
import com.project.retail.repository.RetailRepo;

@Service
public class CustomerService {
	@Autowired  
	RetailRepo retailrepo;

	
	public Customer addCustomer(Customer cus) {
		return retailrepo.save(cus);
		
	}
	
	public Optional<Customer> searchCustomer(int id) {
		return retailrepo.findById(id);
		
	}
	public Customer updateCustomer(int id, Customer cus) {
		if(!retailrepo.existsById(id)) {
			return null;
		}else {
			cus.setCustomerId(id);
			return retailrepo.save(cus);
		}
	
	}
	
	public boolean deleteCustomer(int id) {		
		if(!retailrepo.existsById(id)) {
			return false;
		}else {
			retailrepo.deleteById(id);
			return true;
		}
		
	}
}