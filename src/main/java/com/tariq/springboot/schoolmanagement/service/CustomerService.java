package com.tariq.springboot.schoolmanagement.service;

import java.util.List;

import com.tariq.springboot.schoolmanagement.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getAllCustomer();
	
	public Customer findByID(Integer id);
	
	public void save(Customer customer);
	
	public void delete(Integer id);

}
