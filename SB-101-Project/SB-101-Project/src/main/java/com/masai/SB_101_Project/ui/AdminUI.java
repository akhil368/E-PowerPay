package com.masai.SB_101_Project.ui;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.masai.SB_101_Project.dao.AdminSideFunctions;
import com.masai.SB_101_Project.dao.AdminSideFunctionsImp;
import com.masai.SB_101_Project.dao.CustomerSideFunctions;
import com.masai.SB_101_Project.dao.CustomerSideFunctionsImpl;
import com.masai.SB_101_Project.entity.Bill;
import com.masai.SB_101_Project.entity.Customer;
import com.masai.SB_101_Project.exceptions.NoRecordFound;
import com.masai.SB_101_Project.exceptions.SomethingWentWrongException;

public class AdminUI {

	public static void viewAllCustomer(Scanner sc)
	{
		try {
		AdminSideFunctions cus=new AdminSideFunctionsImp();
		List<Customer > customerList=(List<Customer >)cus.getCustomerList();
		for(Customer obj :customerList)
		{
			System.out.println(obj);
		}
		}catch(SomethingWentWrongException | NoRecordFound ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	public static void showBillById(Scanner sc)
	{
		System.out.println("Enter Id");
		int id=sc.nextInt();
		try {
			AdminSideFunctions admin=new AdminSideFunctionsImp();
			Bill b=admin.viewBill(id);
			System.out.println(b);
			
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	public static void showAllBill(Scanner sc)
	{
		
		try {
			AdminSideFunctions admin=new AdminSideFunctionsImp();
			List<Bill > customerList=(List<Bill>)admin.viewAllBill();
			for(Bill obj :customerList)
			{
				System.out.println(obj);
			}
			}catch(SomethingWentWrongException | NoRecordFound ex)
			{
				System.out.println(ex.getMessage());
			}
	}
	public static void deleteBill(Scanner sc)
	{
		System.out.println("Enter ID of the Customer");
		int id=sc.nextInt();
		try {
			AdminSideFunctions admin=new AdminSideFunctionsImp();
			admin.deleteCustomer(id);
			
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	
	public static void showAllPendingBill(Scanner sc)
	{
		try {
			AdminSideFunctions admin=new AdminSideFunctionsImp();
			admin.viewAllPendingBill();
			
			
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	public static void showAllPaidBill(Scanner sc)
	{
		try {
			AdminSideFunctions admin=new AdminSideFunctionsImp();
			admin.viewAllPaidBill();
			
			
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	public static void genrateBill(Scanner sc)
	{
		System.out.println("Enter Customer ID");
		int id=sc.nextInt();
		
		
		int unitRate=10;
		System.out.println("Enter Previous Reading");
		 double prevReading=sc.nextDouble(); 
		 System.out.println("Enter Previous Reading");
		 double currReading=sc.nextDouble();
		 double tax=(2.5)*100;
		 System.out.println("Is Bill Paid");
		int isPaid=sc.nextInt();
		
		System.out.println("Enter Start Date");
		LocalDate startDate=LocalDate.parse(sc.next());
		System.out.println("Enter End Date");
		LocalDate endDate=LocalDate.parse(sc.next());
		System.out.println("Enter Billing Date");
		LocalDate billing_date=LocalDate.parse(sc.next());
		
		LocalDate dueDate=billing_date.plusDays(10);
		double unitCosumed=prevReading-currReading;
		double totalAmount=unitCosumed*unitRate;
		
		totalAmount=(totalAmount*2.5)/100 + totalAmount;
		
		Bill b=new Bill(unitRate, totalAmount, prevReading, currReading, tax, dueDate, isPaid, startDate, endDate, billing_date) ;
		
		
		AdminSideFunctions ad=new AdminSideFunctionsImp();
		try {
			ad.generateBill(b, id);
		} catch (NoRecordFound | SomethingWentWrongException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
		
		
		
	}
}
