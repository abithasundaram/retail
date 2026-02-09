package com.project.retail.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.retail.model.Product;

@Repository
public interface product extends JpaRepository <Product,Integer>{

}
