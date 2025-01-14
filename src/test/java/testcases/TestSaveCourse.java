package testcases;

import static org.junit.Assert.*;

import org.hibernate.*;
import model.Course;
import org.junit.Test;

import configurations.ConfigurationUtils;

public class TestSaveCourse {
	public Boolean saveCourse() {
		Transaction transaction= null;
		try(Session session = ConfigurationUtils.getConnection().openSession()){
			transaction = session.beginTransaction();
			
			Course course=new Course();
			course.setCourseName("Software_testing");
			course.setCourseCode("SENG8425");
			
			session.persist(course);
			transaction.commit();
			
			return true;
		}catch(Exception e) {
			if(transaction !=null) {
				transaction.rollback();
			}
		}
		return false;
	}
	@Test
	public void test() {
		assertTrue(saveCourse());
	}

}
