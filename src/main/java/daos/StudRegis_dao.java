package daos;
import java.util.Date;
import java.util.Scanner;
import java.util.UUID;

import org.hibernate.*;

import configurations.ConfigurationUtils;
import model.*;
import model.StudentRegistration;
public class StudRegis_dao {

	
	public StudentRegistration registerStudent(int regNum,UUID studentId, UUID semesterId, UUID departmentId) {
	    Session session = ConfigurationUtils.getConnection().openSession();
	    Transaction transaction = null;
	    StudentRegistration studentRegistration =null;

	    try {
	        transaction = session.beginTransaction();
	        Student student = session.get(Student.class, studentId);
	        Semester semester = session.get(Semester.class, semesterId);
	        Department department = session.get(Department.class, departmentId);
	       System.out.println("regNum"+regNum+"sem"+semesterId+" dept"+ departmentId+"stud"+studentId);
	        studentRegistration = new StudentRegistration();
	        studentRegistration.setRegistrationNumber(regNum);
	        studentRegistration.setRegistrationDate(new Date());
	        studentRegistration.setStudent(student);
	        studentRegistration.setSemester(semester);
	        studentRegistration.setDepartment(department);
	        System.out.print("reaching here");
	        session.persist(studentRegistration);
	        transaction.commit();
	      System.out.print("reaching here");
	    } catch (Exception e) {
	        if (transaction != null) {
	            transaction.rollback();
	        }
	        e.printStackTrace();
	        
	    } finally {
	        session.close();
	    }
	    return studentRegistration;
	}
//	public static void main(String[] args) {
//	    // Assuming you have objects for Student, Semester, and Department
//	    Student student = new Student();
//	    Semester semester = new Semester();
//	    Department department = new Department();
//
//	    int registrationStatus;
//		try {
//			registrationStatus = registerStudent(student, semester, department);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	    if (registrationStatus == 1) {
//	        System.out.println("Student registration successful!");
//	    } else {
//	        System.out.println("Student registration failed.");
//	    }
//	}
//
	
}	