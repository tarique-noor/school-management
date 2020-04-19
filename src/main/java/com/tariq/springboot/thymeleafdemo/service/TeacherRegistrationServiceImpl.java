package com.tariq.springboot.thymeleafdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tariq.springboot.thymeleafdemo.dao.TeacherDao;
import com.tariq.springboot.thymeleafdemo.entity.Address;
import com.tariq.springboot.thymeleafdemo.entity.Teacher;

@Service
public class TeacherRegistrationServiceImpl implements TeacherRegistrationService {

	@Autowired
	private TeacherDao teacherDao;

	@Override
	@Transactional
	public void saveTeacherRegistration(Teacher teacher) {

		teacherDao.saveTeacherRegistration(teacher);
		
	}

	@Override
	@Transactional
	public List<Teacher> getTeacherDetails() {
		return teacherDao.getTeacherDetails();
	}

	@Override
	@Transactional
	public Teacher getTeacherAddress(int id) {
		
		return teacherDao.getTeacherAddress(id);
	}

	@Override
	@Transactional
	public void updateAddress(Address address) {
		
		teacherDao.updateAddress(address);
		
	}

}
