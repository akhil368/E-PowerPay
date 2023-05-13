package com.masai.SB_101_Project;

import java.util.Scanner;

import com.masai.SB_101_Project.ui.AdminUI;
import com.masai.SB_101_Project.ui.CustomerLoginUi;

/**
 * Hello world!
 *
 */
public class App 
{
	 public static void main( String[] args ){
	    	Scanner sc = new Scanner(System.in);
	    	
	    	int choice = 0;
	    	do {
	    		System.out.println("1. Admin Login");
	    		System.out.println("2. Customer Login");
	    		System.out.println("3. Customer Registration");
	    		System.out.println("0. Exit");
	    		System.out.print("Enter Selection ");
	    		choice = sc.nextInt();
	    		switch(choice) {
	    			case 1:
	    				adminLogin(sc);
	    				break;
	    			case 2:
	    				CustomerLoginUi.userLogin(sc);
	    				break;
	    			case 3:
	    				CustomerLoginUi.registerCustomer(sc);
	    				break;
	    			case 0:
	    				System.out.println("Thanks for using the E-Pay ");
	    				break;
	    			default:
	    				System.out.println("Invalid Selection, try again");
	    		}
	    	}while(choice != 0);
	    	
	    	sc.close();
	    }
	public static void adminLogin(Scanner sc) {
			System.out.print("Enter username ");
			String username = sc.next();
			System.out.print("Enter password ");
			String password = sc.next();
			if(username.equals("admin") && password.equals("admin")) {
				adminMenu(sc);
			}else {
				System.out.println("Invalid Username of Password");
			}
		}
	public static void displayAdminMenu() {
		System.out.println("1. Generate Bill");
		System.out.println("2. View Bill by Bill Id");
		System.out.println("3. View All Bill");
		System.out.println("4. Delete A Customer");
		System.out.println("5. Show All Pending Bills");
		System.out.println("6. Show All Paid Bills");
		System.out.println("7. Show All Customers");
		
		System.out.println("0. Logout");
	}
	public static void displayUserMenu() {
		System.out.println("1. change Password");
		System.out.println("2. View All Transaction");
		System.out.println("3. Pay Bill");
		System.out.println("4. Delete Account");
		
		
		System.out.println("0. Logout");
	}
	static void adminMenu(Scanner sc) {
		int choice = 0;
		do {
			displayAdminMenu();
			System.out.print("Enter selection ");
			choice = sc.nextInt();
    		switch(choice) {
    			case 1:
    				CustomerLoginUi.changePassword(sc);
    				break;
    			case 2:
    				CustomerLoginUi.payBill(sc);
    			case 3:
    				CustomerLoginUi.payBill(sc);
    				break;
    			case 4:
    				CustomerLoginUi.deleteAccount(sc);;
    				break;
    			
    			
    			case 0:
    				System.out.println("Bye Bye Admin");
    				break;
    			default:
    				System.out.println("Invalid Selection, try again");
    		}
    	}while(choice != 0);	
	}
	public static void userPannel(Scanner sc)
	{
		int choice = 0;
		do {
			displayUserMenu();
			System.out.print("Enter selection ");
			choice = sc.nextInt();
    		switch(choice) {
    			case 1:
    				AdminUI.genrateBill(sc);
    				break;
    			case 2:
    				AdminUI.showBillById(sc);
    				break;
    			case 3:
    				AdminUI.showAllBill(sc);
    				break;
    			case 4:
    				AdminUI.deleteBill(sc);
    				break;
    			case 5:
    				AdminUI.showAllPendingBill(sc);
    				break;
    			case 6:
    				AdminUI.showAllPaidBill(sc);
    				break;
    			case 7:
    				AdminUI.viewAllCustomer(sc);
    				break;
    			
    			case 0:
    				System.out.println("Bye Bye Admin");
    				break;
    			default:
    				System.out.println("Invalid Selection, try again");
    		}
    	}while(choice != 0);	
	}
	 
	 
}
