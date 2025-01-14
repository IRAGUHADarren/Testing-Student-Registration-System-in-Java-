package methods;
import model.*;

import java.util.Scanner;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Transaction;

import configurations.ConfigurationUtils;
import daos.*;

public class StudentCoursesController {
	
	@SuppressWarnings("deprecation")
	public static void main(String[]args) {
		boolean condition = true;
		int number;
		
		  UUID studentId = null;
	        UUID course_code = null;
//	        UUID semesterId = null;
	        
//			StudentRegistration studentRegistration= new StudentRegistration();
//			StudRegis_dao dao=new StudRegis_dao();
//			Semester_dao sem=new Semester_dao();
//			Department_dao dep= new Department_dao();
//			Department department= new Department();
	        Course_dao coursedao=new Course_dao();
			Student_dao studentDao = new Student_dao();
			StudentCourses_dao studentcourse= new StudentCourses_dao();
			
			Student stud = new Student();
//			Semester semester= new Semester();
			Course cour= new Course();
			StudentCourses studCour =new StudentCourses();
			
	        
	        Session session = ConfigurationUtils.getConnection().openSession();
		    Transaction transaction = null;
		    transaction = session.beginTransaction();
	    try {
			while(condition) {
				System.out.println("=========================");
	            System.out.println("INPUTS");
	            System.out.println("------------------------");
	            System.out.println("1. Register StudentCourse ");

	            System.out.println("0.exit");
	            System.out.print("choose:");
	            Scanner input = new Scanner(System.in);
	            int choice = input.nextInt();
	            switch(choice) {
	            case 1:
	            	// Register Student First
	            	
	            	System.out.println("enter Student First Name:");
	               String firstName = input.next();
	               stud.setFirstName(firstName);
	               
	               System.out.println("enter Student Last Name:");
	               String LastName = input.next();
	               stud.setLastName(LastName);
	               
	           	System.out.println("enter Student Gender:");
	            String gender = input.next();
	            stud.setGender(gender);
	            
	            System.out.println("enter date of birth:");
	            String dob = input.next();
	            stud.setDateOfBirth(dob);
	            
	            studentId = (UUID) session.save(stud);
	           
	            
	        	System.out.println("Hello" + studentId);
	            	
	            	
	            	
	        		System.out.print("enter marksincourse number:");
	                number = input.nextInt();
	               
	                
	                System.out.println("enter the course name:");
	                String courseName = input.next();
	                UUID coursecode = coursedao.getCourseIdByName(courseName);
	                
//	                System.out.println("enter the semester number:");
//	                String semName = input.next();
//	                UUID semId = sem.getSemesterIdByName(semName);
//	                System.out.println("regNum"+number+"sem"+semId+" dept"+ deptId+"stud"+studentId);
	                transaction.commit();	
	                StudentCourses feedback=studentcourse.registerStudentCourse(number, studentId, course_code);
	                System.out.println(feedback+"correct");
	                
	                System.out.print("Do you wish to continue, use Yes or No: ");
	                String answer = input.next();
	                if(answer.equalsIgnoreCase("yes")){
	                    condition = true;
	                }else{
	                    System.out.println("Thank you for using system");
	                    condition = false;
	               }
	                break;

	            case 0:
	                System.out.println("Thank you for using the system");
	                System.exit(0);
	                break;
	            default:
	                }
	            
	            }
			
	    }catch(Exception e) {
	    	throw new RuntimeException("Nothing found");
	    }
	}		

}
