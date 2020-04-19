package com.tariq.springboot.thymeleafdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.tariq.springboot.thymeleafdemo.entity.Address;
import com.tariq.springboot.thymeleafdemo.entity.Customer;
import com.tariq.springboot.thymeleafdemo.entity.Teacher;
import com.tariq.springboot.thymeleafdemo.service.TeacherRegistrationService;

@Controller
@RequestMapping("/registration")
public class TeacherRegistrationController {
	
	@Autowired
	private TeacherRegistrationService teacherRegistrationService;
	
	@GetMapping("/welcome")
	public String welcomePage(Model model) {
		
		List<Teacher> list = teacherRegistrationService.getTeacherDetails();
		
		model.addAttribute("teacher", list);
		
		return "welcome";
	}
	
	@GetMapping("/openregister")
	public String openRegisteration(Model model){
		
		Teacher teacher = new Teacher();
		
		model.addAttribute("teacher", teacher);
		
		return "view/register";
	}
	
	@GetMapping("/opensecond")
	public String openSecond(Model model){
		
		Address address = new Address();
		
		model.addAttribute("address", address);
		
		return "view/address-other";
	}
	
	@PostMapping("/saveTeacher")
	public String saveTeacher(@ModelAttribute("teacher") Teacher teacher){
		
		teacherRegistrationService.saveTeacherRegistration(teacher);
		
		return "redirect:/registration/welcome";
	}
	
	@GetMapping("/toAddress")
	public String showUpdateForm(@RequestParam("ID") int ID, Model model){
		
		Teacher teacher = teacherRegistrationService.getTeacherAddress(ID);
		Address add = teacher.getAddresses().get(0);
		
		String name = teacher.getFirstName()+" "+teacher.getLastName();
		String mobile = "(+91)"+teacher.getMobile();
		String addressType = add.getAddressType();
		
		model.addAttribute("teacher", teacher);
		model.addAttribute("name", name);
		model.addAttribute("house", (add.getHouseNo() == null ? "" : add.getHouseNo()+", ")+(add.getStreetNo() == null ? "" : add.getStreetNo()+", ")+(add.getNearestPlace() == null ? "" : "Near by "+add.getNearestPlace()));
//		model.addAttribute("nearby", nearBy);
		model.addAttribute("mohalla", (add.getMohalla() == null ? "" : add.getMohalla()+", ")+(add.getThana() == null ? "" : "Thana: "+add.getThana()));
		model.addAttribute("city", (add.getCity() == null ? "" : add.getCity()+", ")+(add.getDistt() == null ? "" : "Distt: "+add.getDistt()));
		model.addAttribute("state", (add.getStates() == null ? "" : add.getStates()+" ")+(add.getPinCode() == null ? "" : add.getPinCode()));
		model.addAttribute("mobile", mobile);
		
		return "view/display-address";
	}
	
	@PostMapping("/openAddressForm")
	public String openAddressForm(@RequestParam("id") int id, Model model){
		
		Teacher teacher = teacherRegistrationService.getTeacherAddress(id);
		Address add = teacher.getAddresses().get(0);
		
		model.addAttribute("address", add);
		
		return "view/address";
	}
	
	@PostMapping("/addAddrerss")
	public RedirectView addAddrerss(@ModelAttribute("address") Address address, Model model){
		
		int ID=address.getTeacher().getId();
		Teacher teacher = teacherRegistrationService.getTeacherAddress(ID);
		address.setTeacher(teacher);
		teacherRegistrationService.updateAddress(address);
		
		RedirectView rv = new RedirectView();
        rv.setContextRelative(true);
		rv.setUrl("/registration/toAddress?ID="+ID);
		
		return rv;
	}

}
