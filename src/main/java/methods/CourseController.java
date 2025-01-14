package methods;

import java.util.Scanner;
import java.util.UUID;

import daos.Course_dao;
import model.Course;

public class CourseController {

	public static void main(String[]args) {
		boolean condition = true;
		String courseNames;
		String courseCode;
		
		Course Course= new Course();
		Course_dao dao=new Course_dao();
		
		while(condition) {
			System.out.println("=========================");
            System.out.println("INPUTS");
            System.out.println("------------------------");
            System.out.println("1. Register Course ");
            System.out.println("2. search in Course ");
            System.out.println("0.exit");
            System.out.print("choose:");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            switch(choice) {
            case 1:
            	System.out.print("enter Course name:");
                courseNames = input.next();
                System.out.print("enter Course codes:");
                courseCode = input.next();
                
                Course.setCourseCode(courseCode);
                Course.setCourseName(courseNames);
                
                Course feedback=dao.registerCourse(Course);
                System.out.println(feedback);
                System.out.print("Do you wish to continue, use Yes or No: ");
                String answer = input.next();
                if(answer.equalsIgnoreCase("yes")){
                    condition = true;
                }else{
                    System.out.println("Thank you for using system");
                    condition = false;
                }
                break;
            case 2:
            	System.out.print("enter Course name to search:");
                courseNames = input.next();
                Course= new Course();
                Course.setCourseName(courseNames);
                dao= new Course_dao();
                UUID thecourseId=dao.getCourseIdByName(courseNames);
                if(thecourseId !=null) {
                	System.out.println("--------------------------------------------------------");
                    System.out.println("Course Info");
                    System.out.println("-------------------");

                    System.out.println("id : "+thecourseId);

                    System.out.println("-----------------------------------------------");
                    
                }else{
                    System.out.println("Not Found!!");
                }
                System.out.print("Do you wish to continue, use Yes or No: ");
                answer = input.next();
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
		}
}
