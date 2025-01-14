package testcases;

import static org.junit.Assert.*;

import org.hibernate.*;
import configurations.ConfigurationUtils;
import model.Student;
import org.junit.Test;

public class TestSaveStudent {
	public Boolean saveStudent() {
		Transaction transaction=null;
		try (Session session = ConfigurationUtils.getConnection().openSession()){
			transaction = session.beginTransaction();
			
			Student student=new Student();
			student.setDateOfBirth("2/3/2000");
			student.setFirstName("Iraguha");
			student.setLastName("Darren");
			student.setGender("M");
			
			session.persist(student);
			transaction.commit();
			
			return true;
			
		} catch (Exception e) {
			if(transaction !=null) {
				transaction.rollback();
			}
		}
		
		return false;
	}
	
	
	@Test
	public void test() {
		assertTrue(saveStudent());
	}

}
