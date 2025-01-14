package daos;

import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import configurations.ConfigurationUtils;
import model.Student;

public class Student_dao {

	public Student registerStudent(Student student) {
		try {
			Session session = ConfigurationUtils.getConnection().openSession();
			Transaction transaction = session.beginTransaction();
			session.save(student);
			transaction.commit();
			session.close();
			return student;
			
		} catch (Exception e) {
			e.printStackTrace();
		 
		return null;
	}
		
	}
	
	public UUID getStudentIdByName(String firstName) {
		
			Session session = ConfigurationUtils.getConnection().openSession();
			session.beginTransaction();
			
			 // Create a query using Hibernate Query Language (HQL)
			  @SuppressWarnings("deprecation")
			Query<?> query = session.createQuery("SELECT d.id FROM Student d WHERE d.firstName = :name ");

			  // Set the parameter for Student name
			  query.setParameter("name", firstName);
			  //query.setParameter("name1", lastName);

			  // Execute the query and get the single result (assuming unique Student name)
			  UUID StudentId = (UUID) query.uniqueResult();

			  return StudentId;
			 

}
}
