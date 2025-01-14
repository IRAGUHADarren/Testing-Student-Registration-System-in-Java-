package configurations;

import org.hibernate.*;
import org.hibernate.cfg.*;

import model.*;

import java.util.*;

public class ConfigurationUtils {

	public static SessionFactory getConnection() {
		SessionFactory sessionFactory = null;
 		
 
		 try {
			 if(sessionFactory == null){
		            Configuration configuration = new Configuration();
		            Properties Properties = new Properties();
		            Properties.put(Environment.DRIVER,"org.postgresql.Driver");
		            Properties.put(Environment.URL, "jdbc:postgresql://localhost:5432/student_management_db");         
		            Properties.put(Environment.USER, "postgres");         
		            Properties.put(Environment.PASS, "12345");         
		            Properties.put(Environment.HBM2DDL_AUTO, "update");         
		            Properties.put(Environment.SHOW_SQL, "true");
		            configuration.setProperties(Properties);
		            configuration.addAnnotatedClass(Student.class);
		            configuration.addAnnotatedClass(Course.class);
		            configuration.addAnnotatedClass(Department.class);
		            configuration.addAnnotatedClass(Semester.class);
		            configuration.addAnnotatedClass(StudentCourses.class);
		            configuration.addAnnotatedClass(StudentRegistration.class);
		            sessionFactory = configuration.buildSessionFactory();
		         return sessionFactory;   
			 }       
			
		} catch (Exception e) {
			e.printStackTrace();
		
		}
		 return sessionFactory;  
	
	}
}
