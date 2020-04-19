package com.tariq.springboot.thymeleafdemo.service;

import java.util.List;

import com.tariq.springboot.thymeleafdemo.entity.Address;
import com.tariq.springboot.thymeleafdemo.entity.Teacher;

public interface TeacherRegistrationService {
	
	public void saveTeacherRegistration(Teacher teacher);
	
	public List<Teacher> getTeacherDetails();
	
	public Teacher getTeacherAddress(int id);

	public void updateAddress(Address address);

}
