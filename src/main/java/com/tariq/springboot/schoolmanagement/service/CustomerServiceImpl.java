package com.tariq.springboot.schoolmanagement.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tariq.springboot.schoolmanagement.dao.CustomerRepository;
import com.tariq.springboot.schoolmanagement.entity.Customer;
import com.tariq.springboot.schoolmanagement.exception.CustomerNotFoundException;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<Customer> getAllCustomer() {
		return customerRepository.findAllByOrderByFirstNameAsc();
	}

	@Override
	public Customer findByID(Integer id) {
		Optional<Customer> result = customerRepository.findById(id);
		Customer cust = null;
		if(result.isPresent()){
			cust = result.get();
		}else{
			throw new CustomerNotFoundException("Did not find customer id "+ id);
		}
		
		return cust;
	}

	@Override
	public void save(Customer customer) {
		customerRepository.save(customer);
	}

	@Override
	public void delete(Integer id) {
		customerRepository.deleteById(id);
	}

}
