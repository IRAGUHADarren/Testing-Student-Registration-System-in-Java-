package daos;

import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import configurations.ConfigurationUtils;
import model.Course;

public class Course_dao {

	public Course registerCourse(Course course) {
		try {
			Session session = ConfigurationUtils.getConnection().openSession();
			Transaction transaction = session.beginTransaction();
			session.save(course);
			transaction.commit();
			session.close();
			return course;
			
		} catch (Exception e) {
			e.printStackTrace();
		
		return null;
	}
		
	}
	
	public UUID getCourseIdByName(String courseName) {
		
			Session session = ConfigurationUtils.getConnection().openSession();
			session.beginTransaction();
			
			 // Create a query using Hibernate Query Language (HQL)
			  @SuppressWarnings("deprecation")
			Query<?> query = session.createQuery("SELECT d.id FROM Course d WHERE d.courseName = :name");

			  // Set the parameter for Course name
			  query.setParameter("name", courseName);

			  // Execute the query and get the single result (assuming unique Course name)
			  UUID CourseId = (UUID) query.uniqueResult();

			  return CourseId;
			 

}
}
