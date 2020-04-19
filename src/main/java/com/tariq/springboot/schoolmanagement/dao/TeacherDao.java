package com.tariq.springboot.schoolmanagement.dao;


import java.util.List;

import com.tariq.springboot.schoolmanagement.entity.Address;
import com.tariq.springboot.schoolmanagement.entity.Teacher;

public interface TeacherDao {
	
	public void saveTeacherRegistration(Teacher teacher);
	
	public List<Teacher> getTeacherDetails();
	
	public Teacher getTeacherAddress(int id);

	public void updateAddress(Address address);

}
