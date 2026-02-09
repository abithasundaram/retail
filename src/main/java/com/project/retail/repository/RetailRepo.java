package com.project.retail.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.retail.model.Customer;

@Repository
public interface RetailRepo extends JpaRepository<Customer,Integer>{
	

}
