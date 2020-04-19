package com.tariq.springboot.thymeleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tariq.springboot.thymeleafdemo.entity.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	public List<Customer> findAllByOrderByFirstNameAsc();

}
