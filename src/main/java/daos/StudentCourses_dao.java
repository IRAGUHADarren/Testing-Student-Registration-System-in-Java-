package daos;

import java.util.Date;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Transaction;

import configurations.ConfigurationUtils;


import model.Student;
import model.StudentCourses;
import model.Course;

public class StudentCourses_dao {

	public StudentCourses registerStudentCourse(int marks,UUID studentId, UUID course_code) {
	    Session session = ConfigurationUtils.getConnection().openSession();
	    Transaction transaction = null;
	    StudentCourses studentCourses =null;

	    try {
	        transaction = session.beginTransaction();
	        Student student = session.get(Student.class, studentId);
	        Course courses = session.get(Course.class, course_code);
	        
	       System.out.println("marks:"+marks+"course_code:"+course_code+"stud"+studentId);
	        studentCourses = new StudentCourses();
	        studentCourses.setMarksInCourse(marks);

	        studentCourses.setStudent(student);
	        studentCourses.setCourse(courses);

	        System.out.print("reaching here");
	        session.persist(studentCourses);
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
	    return studentCourses;
	}
	
}
