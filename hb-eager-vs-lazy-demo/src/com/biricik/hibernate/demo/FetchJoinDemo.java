package com.biricik.hibernate.demo;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.biricik.hibernate.demo.entity.Course;
import com.biricik.hibernate.demo.entity.Instructor;
import com.biricik.hibernate.demo.entity.InstructorDetail;
import com.biricik.hibernate.demo.entity.Student;

public class FetchJoinDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		
		try {
			// start a transaction
			session.beginTransaction();
			
			// option 2:Hibernate query with HQL
			
			// get the instructor from db
			int theId =4;
			
			Query<Instructor> query = session.createQuery("select i from Instructor i "
					+"JOIN FETCH i.courses where i.id=:theInstructorId"
					,Instructor.class);
			
			// set parameter on query
			query.setParameter("theInstructorId", theId);
			
			// execute query and get instructor
			Instructor tempInstructor = query.getSingleResult();
			
			System.out.println("Instructor: " + tempInstructor);
			
			
			
			// commit transaction
			session.getTransaction().commit();
			
			// close the session
			session.close();
			
			System.out.println("The Session is now closed");
			// option 1: call getter method while session is open
			
			// get course for the instructor
			System.out.println("Courses: " + tempInstructor.getCourses());
			
			System.out.println("Done!");
		}finally {
			// add clean up code
			session.close();
			factory.close();
		}

	}

}
