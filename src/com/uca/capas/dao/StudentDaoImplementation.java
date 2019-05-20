package com.uca.capas.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.domain.Student;

@Repository
public class StudentDaoImplementation implements StudentDao {

	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;
	
	@Override
	public List<Student> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.student");
		Query query = entityManager.createNativeQuery(sb.toString(),Student.class);
		List<Student> resulset= query.getResultList();
		
		return resulset;
	}

	@Override
	public Student findOne(Integer code) throws DataAccessException {
		// TODO Auto-generated method stub
		Student student = entityManager.find(Student.class, code);
		return student;
	}

	@Override
	@Transactional
	public int save(Student s, Integer newRow) throws DataAccessException {
		// TODO Auto-generated method stub
		try {
			if(newRow == 1) entityManager.persist(s);
			else entityManager.merge(s);
			
			entityManager.flush();
			return 1;
		}catch (Throwable e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	@Transactional
	public int delete(Student s) throws DataAccessException {
		// TODO Auto-generated method stub
		try {
			if(entityManager.contains(s)) {
				entityManager.remove(s);
			}else {
				entityManager.remove(entityManager.merge(s));
			}
		} catch (Throwable e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
		return 0;
	}
	
}
