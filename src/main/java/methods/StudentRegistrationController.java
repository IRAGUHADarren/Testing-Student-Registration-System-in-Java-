package methods;

import model.*;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.Transaction;

import configurations.ConfigurationUtils;
import daos.*;

public class StudentRegistrationController {
	
	@SuppressWarnings("deprecation")
	public static void main(String[]args) {
		boolean condition = true;
		int number;
		
		  UUID studentId = null;
	        UUID departmentId = null;
	        UUID semesterId = null;
	        
			StudentRegistration studentRegistration= new StudentRegistration();
			StudRegis_dao dao=new StudRegis_dao();
			Semester_dao sem=new Semester_dao();
			Department_dao dep= new Department_dao();
			Department department= new Department();
			Student_dao studentDao = new Student_dao();
			
			Student stud = new Student();
			Semester semester= new Semester();
	        
	        Session session = ConfigurationUtils.getConnection().openSession();
		    Transaction transaction = null;
		    transaction = session.beginTransaction();
	    try {
			while(condition) {
				System.out.println("=========================");
	            System.out.println("INPUTS");
	            System.out.println("------------------------");
	            System.out.println("1. Register StudentRegistration ");

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
	            	
	            	
	            	
	        		System.out.print("enter Registration number:");
	                number = input.nextInt();
	               
	                
	                System.out.println("enter the department name:");
	                String deptName = input.next();
	                UUID deptId = dep.getDepartmentIdByName(deptName);
	                
	                System.out.println("enter the semester number:");
	                String semName = input.next();
	                UUID semId = sem.getSemesterIdByName(semName);
	                System.out.println("regNum"+number+"sem"+semId+" dept"+ deptId+"stud"+studentId);
	                transaction.commit();	
	                StudentRegistration feedback=dao.registerStudent(number, studentId,semId, deptId  );
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






//  case 2:
//	System.out.print("enter StudentRegistration name to search:");
//    depNames = input.next();
//    StudentRegistration= new StudentRegistration();
//    StudentRegistration.setStudentRegistrationName(depNames);
//    dao= new StudentRegistration_dao();
//    UUID thedepId=dao.getStudentRegistrationIdByName(depNames);
//    if(thedepId !=null) {
//    	System.out.println("--------------------------------------------------------");
//        System.out.println("StudentRegistration Info");
//        System.out.println("-------------------");
//
//        System.out.println("id : "+thedepId);
//
//        System.out.println("-----------------------------------------------");
//        
//    }else{
//        System.out.println("Not Found!!");
//    }
//    System.out.print("Do you wish to continue, use Yes or No: ");
//    answer = input.next();
//    if(answer.equalsIgnoreCase("yes")){
//        condition = true;
//    }else{
//        System.out.println("Thank you for using system");
//        condition = false;
//    }
//    break;























}
