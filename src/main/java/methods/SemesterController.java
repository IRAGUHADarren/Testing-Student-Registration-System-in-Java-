package methods;

import java.util.Date;
import java.util.Scanner;
import java.util.UUID;

import daos.Semester_dao;
import model.Semester;

public class SemesterController {

	public static void main(String[]args) {
		boolean condition = true;
		String semName;
		
		
		Semester semester= new Semester();
		Semester_dao dao=new Semester_dao();
		
		while(condition) {
			System.out.println("=========================");
            System.out.println("INPUTS");
            System.out.println("------------------------");
            System.out.println("1. Register Semester ");
            System.out.println("2. search in Semester ");
            System.out.println("0.exit");
            System.out.print("choose:");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            switch(choice) {
            case 1:
            	System.out.print("enter Semester name:");
                semName = input.next();
                
                semester.setStartDate(new Date());
                semester.setEndDate(new Date());
                semester.setSemesterName(semName);
                
                Semester feedback=dao.registerSemester(semester);
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
            	System.out.print("enter Semester name to search:");
                semName = input.next();
                semester= new Semester();
                semester.setSemesterName(semName);
                dao= new Semester_dao();
                UUID theSemId=dao.getSemesterIdByName(semName);
                if(theSemId !=null) {
                	System.out.println("--------------------------------------------------------");
                    System.out.println("Semester Info");
                    System.out.println("-------------------");

                    System.out.println("id : "+theSemId);

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
