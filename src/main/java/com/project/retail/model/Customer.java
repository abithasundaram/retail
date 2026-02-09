package com.project.retail.model;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@JsonPropertyOrder({ "customerId", "customerName", "customerEmail", 
    "customerBillingAddress", "customerShippingAddress" })
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer customerId;
	String customerName;
	String customerEmail;
	String customerBillingAddress;
	String customerShippingAddress;
	
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getCustomerBillingAddress() {
		return customerBillingAddress;
	}
	public void setCustomerBillingAddress(String customerBillingAddress) {
		this.customerBillingAddress = customerBillingAddress;
	}
	public String getCustomerShippingAddress() {
		return customerShippingAddress;
	}
	public void setCustomerShippingAddress(String customerShippingAddress) {
		this.customerShippingAddress = customerShippingAddress;
	}
	

}
