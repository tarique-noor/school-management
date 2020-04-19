package com.tariq.springboot.thymeleafdemo.service;

import java.util.List;

import com.tariq.springboot.thymeleafdemo.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getAllCustomer();
	
	public Customer findByID(Integer id);
	
	public void save(Customer customer);
	
	public void delete(Integer id);

}
