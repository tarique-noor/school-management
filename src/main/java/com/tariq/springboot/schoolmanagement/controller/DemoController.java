package com.tariq.springboot.schoolmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tariq.springboot.schoolmanagement.entity.Customer;
import com.tariq.springboot.schoolmanagement.service.CustomerService;

@Controller
@RequestMapping("/api")
public class DemoController {
	
	@Autowired
	private CustomerService customerService;
	
	/*@GetMapping("/welcome")
	public String welcomePage() {
		
		return "welcome";
	}*/
	
	@GetMapping("/hello")
	public String sayHello(Model theModel) {
		
		theModel.addAttribute("theDate", new java.util.Date());
		
		return "helloworld";
	}
	
	@GetMapping("/customers")
	public String getList(Model model){
		
		List<Customer> list = customerService.getAllCustomer();
		
		model.addAttribute("customers", list);
		
		return "view/customer-list";
	}
	
	@GetMapping("/showform")
	public String showForm(Model model){
		
		Customer customer = new Customer();
		
		model.addAttribute("customer", customer);
		
		return "view/customer-form";
	}
	
	@GetMapping("/showUpdate")
	public String showUpdateForm(@RequestParam("cusomerID") int custID, Model model){
		
		Customer customer = customerService.findByID(custID);
		
		model.addAttribute("customer", customer);
		
		return "view/customer-form";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("cusomerID") int custID, Model model){
		
		customerService.delete(custID);
		
		return "redirect:/api/customers";
	}
	
	@PostMapping("/save")
	public String saveCustomer(@ModelAttribute("customer") Customer customer){
		
		customerService.save(customer);
		
		return "redirect:/api/customers";
	}
}








