package com.tariq.springboot.schoolmanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tariq.springboot.schoolmanagement.entity.Address;
import com.tariq.springboot.schoolmanagement.entity.Teacher;

@Repository
public class TeacherDaoImpl implements TeacherDao {
	
	private EntityManager entityManager;
	
	@Autowired
	public TeacherDaoImpl(EntityManager entityManager){
		this.entityManager = entityManager;
	}

	@Override
	public void saveTeacherRegistration(Teacher teacher) {
		
		Session session = entityManager.unwrap(Session.class);
		
		Integer in = (Integer)session.save(teacher);
		
		Address add = teacher.getAddresses().get(0);
		teacher.setId(in);
		add.setTeacher(teacher);
		
		session.save(add);
	}

	@Override
	public List<Teacher> getTeacherDetails() {
		
		Session session = entityManager.unwrap(Session.class);
		List<Teacher> list = session.createQuery("from Teacher order by firstName asc", Teacher.class).getResultList();
		return list;
	}

	@Override
	public Teacher getTeacherAddress(int id) {
		
		Session session = entityManager.unwrap(Session.class);
		Teacher teacher = session.load(Teacher.class, id);
		return teacher;
	}

	@Override
	public void updateAddress(Address address) {
		
		Session session = entityManager.unwrap(Session.class);
		
		session.saveOrUpdate(address);
		
		
	}

}
