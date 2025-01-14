package daos;

import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import configurations.ConfigurationUtils;
import model.Semester;

public class Semester_dao {

	public Semester registerSemester(Semester semester) {
		try {
			Session session = ConfigurationUtils.getConnection().openSession();
			Transaction transaction = session.beginTransaction();
			session.save(semester);
			transaction.commit();
			session.close();
			return semester;
			
		} catch (Exception e) {
			e.printStackTrace();
		
		return null;
	}
		
	}
	
	public UUID getSemesterIdByName(String semesterName) {
		
			Session session = ConfigurationUtils.getConnection().openSession();
			session.beginTransaction();
			
			 // Create a query using Hibernate Query Language (HQL)
			  @SuppressWarnings("deprecation")
			Query<?> query = session.createQuery("SELECT d.id FROM Semester d WHERE d.semesterName = :name");

			  // Set the parameter for Semester name
			  query.setParameter("name", semesterName);

			  // Execute the query and get the single result (assuming unique Semester name)
			  UUID SemesterId = (UUID) query.uniqueResult();

			  return SemesterId;
			 

}

}
