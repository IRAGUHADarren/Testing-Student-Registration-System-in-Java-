package daos;

import java.util.List;
import java.util.UUID;

import org.hibernate.*;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;

import configurations.ConfigurationUtils;
import jakarta.persistence.criteria.*;
import model.Department;

public class Department_dao {
	public Department registerDepartment(Department department) {
		try {
			Session session = ConfigurationUtils.getConnection().openSession();
			Transaction transaction = session.beginTransaction();
			session.save(department);
			transaction.commit();
			session.close();
			return department;
			
		} catch (Exception e) {
			e.printStackTrace();
		
		return null;
	}
		
	}
	
	public UUID getDepartmentIdByName(String departmentName) {
		
			Session session = ConfigurationUtils.getConnection().openSession();
			session.beginTransaction();
			
			 // Create a query using Hibernate Query Language (HQL)
			  @SuppressWarnings("deprecation")
			Query<?> query = session.createQuery("SELECT d.id FROM Department d WHERE d.departmentName = :name");

			  // Set the parameter for department name
			  query.setParameter("name", departmentName);

			  // Execute the query and get the single result (assuming unique department name)
			  UUID departmentId = (UUID) query.uniqueResult();

			  return departmentId;
			 

}
}