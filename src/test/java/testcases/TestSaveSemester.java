package testcases;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import model.Semester;
import configurations.*;
import org.hibernate.*;

public class TestSaveSemester {
	public Boolean saveSemester() {
		Transaction transaction=null;
		
		try(Session session=ConfigurationUtils.getConnection().openSession()) {
			transaction = session.beginTransaction();
			Semester semester=new Semester();
			semester.setSemesterName("Summer_semester");
			semester.setStartDate(new Date());
			semester.setEndDate(new Date());
			
			session.persist(semester);
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
		assertTrue(saveSemester());
	}

}
