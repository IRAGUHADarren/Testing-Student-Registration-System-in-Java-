package methods;

import java.util.Scanner;
import java.util.UUID;

import daos.Student_dao;
import model.Student;

public class StudentController {

	public static void main(String[]args) {
		boolean condition = true;
		String firstName;
		String lastName;
		String dob;
		String gender;
		
		Student student= new Student();
		Student_dao studentDao=new Student_dao();
		
		while(condition) {
			System.out.println("=========================");
            System.out.println("INPUTS");
            System.out.println("------------------------");
            System.out.println("1. Register Student ");
            System.out.println("2. search in Student ");
            System.out.println("0.exit");
            System.out.print("choose:");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            switch(choice) {
            case 1:
            	System.out.print("enter Student first name:");
                firstName = input.next();
                System.out.print("enter Student last name:");
                lastName = input.next();
                System.out.print("enter date of birth:");
                dob=input.next();
                System.out.print("enter gender:");
                gender=input.next();
                
                student.setDateOfBirth(dob);
                student.setGender(gender);
                student.setLastName(lastName);
                student.setFirstName(firstName);
                
                Student feedback=studentDao.registerStudent(student);
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
            	System.out.print("enter Student firstname to search:");
                firstName = input.next();
                //System.out.print("enter last name:");
                //lastName=input.next();
                student= new Student();
                student.setFirstName(firstName);
                //student.setLastName(lastName);
                studentDao= new Student_dao();
                UUID thefirstId=studentDao.getStudentIdByName(firstName);
                if(thefirstId !=null) {
                	System.out.println("enter the department");
                    System.out.println("Student Info");
                    System.out.println("-------------------");

                    System.out.println("id : "+thefirstId);

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
