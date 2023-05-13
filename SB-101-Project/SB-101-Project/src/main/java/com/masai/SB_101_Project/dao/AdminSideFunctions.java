package com.masai.SB_101_Project.dao;

import java.util.List;

import com.masai.SB_101_Project.entity.Bill;
import com.masai.SB_101_Project.entity.Customer;
import com.masai.SB_101_Project.exceptions.NoRecordFound;
import com.masai.SB_101_Project.exceptions.SomethingWentWrongException;

public interface AdminSideFunctions {

	public void generateBill(Bill b, int id) throws NoRecordFound,SomethingWentWrongException;
	List<Customer > getCustomerList() throws SomethingWentWrongException,NoRecordFound;
	public Bill viewBill(int id) throws SomethingWentWrongException,NoRecordFound;
	public List<Bill> viewAllBill() throws SomethingWentWrongException,NoRecordFound;
	public void viewAllPaidBill() throws SomethingWentWrongException,NoRecordFound;
	public void viewAllPendingBill() throws SomethingWentWrongException,NoRecordFound;
	public void deleteCustomer(int id) throws SomethingWentWrongException,NoRecordFound ;
	
}