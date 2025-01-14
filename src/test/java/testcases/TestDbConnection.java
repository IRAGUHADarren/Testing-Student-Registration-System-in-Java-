package testcases;

import static org.junit.Assert.*;

import org.hibernate.*;
import org.junit.Test;

import configurations.ConfigurationUtils;

public class TestDbConnection {
	
	public Boolean getConnectionForTables() {
		Transaction transaction = null;
				
				try(Session session = ConfigurationUtils.getConnection().openSession()) {
					
					transaction =	session.beginTransaction();
					
					//save to create tables
					
					transaction.commit();
					
					return true;
				}catch(Exception ex) {
					if(transaction != null) {
						transaction.rollback();
					}
					return false;
				}
			}

	@Test
	public void test() {

		assertTrue(getConnectionForTables());
	}

}
