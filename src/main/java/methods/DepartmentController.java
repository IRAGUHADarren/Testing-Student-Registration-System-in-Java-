package methods;

import java.util.*;

import daos.Department_dao;
import model.Department;

public class DepartmentController {
	public static void main(String[]args) {
		boolean condition = true;
		String depNames;
		String depCode;
		
		Department department= new Department();
		Department_dao dao=new Department_dao();
		
		while(condition) {
			System.out.println("=========================");
            System.out.println("INPUTS");
            System.out.println("------------------------");
            System.out.println("1. Register Department ");
            System.out.println("2. search in department ");
            System.out.println("0.exit");
            System.out.print("choose:");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            switch(choice) {
            case 1:
            	System.out.print("enter department name:");
                depNames = input.next();
                System.out.print("enter department codes:");
                depCode = input.next();
                
                department.setDepartmentCode(depCode);
                department.setDepartmentName(depNames);
                
                Department feedback=dao.registerDepartment(department);
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
            	System.out.print("enter department name to search:");
                depNames = input.next();
                department= new Department();
                department.setDepartmentName(depNames);
                dao= new Department_dao();
                UUID thedepId=dao.getDepartmentIdByName(depNames);
                if(thedepId !=null) {
                	System.out.println("--------------------------------------------------------");
                    System.out.println("department Info");
                    System.out.println("-------------------");

                    System.out.println("id : "+thedepId);

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
