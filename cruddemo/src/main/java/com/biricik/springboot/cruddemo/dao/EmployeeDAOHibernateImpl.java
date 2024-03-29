package com.biricik.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.biricik.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	// define field for entitymanager
	private EntityManager entityManager;

	// set up constructor injection
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> findAll() {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// create a query
		Query<Employee> query = currentSession.createQuery("from Employee", Employee.class);

		// execute query and get result list
		List<Employee> employees = query.getResultList();

		// return the results
		return employees;
	}

	@Override
	public Employee findById(int id) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// get the employee
		Employee employee = currentSession.get(Employee.class, id);

		// return the employee
		return employee;
	}

	@Override
	public void save(Employee employee) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// save the employee
		currentSession.saveOrUpdate(employee);
	}

	@Override
	public void deleteById(int id) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// delete object with primary key
		Query query = currentSession.
				createQuery("delete from Employee where id=:employeeId");
		
		query.setParameter("employeeId", id);
		query.executeUpdate();

	}

}
