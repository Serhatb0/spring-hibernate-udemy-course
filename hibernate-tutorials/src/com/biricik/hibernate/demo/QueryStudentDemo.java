package com.biricik.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.biricik.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// start a transaction
			session.beginTransaction();
			
			// query students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			// display the students 
			displayStudents(theStudents);
			
			// query studetns : lastName='Biricik'
			theStudents = session.createQuery("from Student s where s.lastName='Birick'").getResultList();
			
			// display the students
			System.out.println("Students who have last name of Biricik");
			displayStudents(theStudents);
			
			// query studetns : lastName='Treasa' or firstName='John'
			theStudents = session.createQuery("from Student s where s.lastName='Treasa'"
					+ " or s.firstName='John'").getResultList();
			
			// display the students
			System.out.println("Students who have last name of Treasa or firstName of John");
			displayStudents(theStudents);
			
			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			factory.close();
		}

	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
