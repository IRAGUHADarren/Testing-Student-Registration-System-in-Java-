package testcases;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.*;
import model.Student;
import configurations.*;
import org.junit.Test;

public class TestRetrieveStudent {
	public List<Student> findAllStudent(){
		Transaction transaction = null;
		try(Session session = ConfigurationUtils.getConnection().openSession()) {
			
			transaction = session.beginTransaction();
			
			List<Student> students=session.createQuery("from Student", Student.class).getResultList();
			
			transaction.commit();
			
			return students;
			
		} catch (Exception e) {
			if(transaction !=null) {
				transaction.rollback();
			}
			return null;
		}
		
		
	}

	@Test
	public void test() {
		assertNotNull(findAllStudent());
	}

}
