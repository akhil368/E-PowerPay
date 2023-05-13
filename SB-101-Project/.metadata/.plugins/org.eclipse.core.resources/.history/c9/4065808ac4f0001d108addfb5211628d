package com.masai.SB_101_Project.ui;

import java.util.List;

import com.masai.SB_101_Project.dao.CustomerSideFunctions;
import com.masai.SB_101_Project.dao.CustomerSideFunctionsImpl;
import com.masai.SB_101_Project.exceptions.NoRecordFound;
import com.masai.SB_101_Project.exceptions.SomethingWentWrongException;

public class AdminUI {

	static void viewAllCustomer()
	{
		try {
		CustomerSideFunctions cus=new CustomerSideFunctionsImpl();
		List<Object[] > customerList=cus.getCustomerList();
		for(Object obj[] :customerList)
		{
			System.out.println("First Name "+ obj[0] + "Last Name "+ obj[1]+" User Name "+ obj[2]+ 
					"Address "+ obj[3] +" Email "+ obj[4]+ "Number "+ obj[5]+ "Is Deleted "+ 
					(((Integer)obj[6]).intValue() ==0?"No ":"Yes")
					);
		}
		}catch(SomethingWentWrongException | NoRecordFound ex)
		{
			System.out.println(ex.getMessage());
		}
	}
}
