package com.masai.SB_101_Project.dao;

import java.awt.datatransfer.SystemFlavorMap;
import java.io.Console;
import java.util.List;

import com.masai.SB_101_Project.entity.Bill;
import com.masai.SB_101_Project.entity.Customer;
import com.masai.SB_101_Project.exceptions.NoRecordFound;
import com.masai.SB_101_Project.exceptions.SomethingWentWrongException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

public class AdminSideFunctionsImp implements AdminSideFunctions {

	@Override
	public List<Customer> getCustomerList() throws SomethingWentWrongException, NoRecordFound {
		// TODO Auto-generated method stub
		EntityManager em=null;
		List<Customer> customerList=null;
		try {
			em=EmUtils.getEntityManager();
			
			Query query=em.createQuery("SELECT c.firstName,c.lastName,c.userName,c.address,c.number,c.email,c.isDeleted from Customer c");
			customerList=query.getResultList();
			if(customerList.size()==0)
			{
				throw new NoRecordFound("No Customer Found");
			}
		return customerList;
		
		}catch(PersistenceException ex)
		{
			throw new SomethingWentWrongException("Unable to process request, try again later");
		}
		finally {
			em.close();
		}
		
//		return null;
	}

	@Override
	public Bill viewBill(int id) throws SomethingWentWrongException,NoRecordFound {
		// TODO Auto-generated method stub
		EntityManager em=null;
		Bill b=null;
		try {
		em=EmUtils.getEntityManager();
		Query query=em.createQuery("SELECT b FROM Bill b where id=:id");
		query.setParameter("id", id);
		b=(Bill)query.getSingleResult();
		if(b==null)
		{
			throw new NoRecordFound("No Record Found");
		}
		
		return b;
		}
		catch(PersistenceException ex)
		{
			throw new SomethingWentWrongException("Unable to process request, try again later");
		}
		finally {
			em.close();
		}
		
	}

	@Override
	public List<Bill> viewAllBill() throws  SomethingWentWrongException,NoRecordFound{
		EntityManager em=null;
		List<Bill> b=null;
		try {
		em=EmUtils.getEntityManager();
		Query query=em.createQuery("SELECT b FROM Bill b ");
		
		b=(List<Bill>)query.getResultList();
		if(b.size()==0)
		{
			throw new NoRecordFound("No Record Found");
		}
		
		return b;
		}
		catch(PersistenceException ex)
		{
			throw new SomethingWentWrongException("Unable to process request, try again later");
		}
		finally {
			em.close();
		}

	}

	
	@Override
	public void deleteCustomer(int id) throws SomethingWentWrongException,NoRecordFound {
		// TODO Auto-generated method stub
		EntityManager em=null;
		Customer b=null;
		try {
			em=EmUtils.getEntityManager();
			EntityTransaction et=em.getTransaction();
			b=em.find(Customer.class, id);
			if(b==null)
			{
				throw new  NoRecordFound("No Record Found");
			}
			b.setIsDeleted(1);
			System.out.println("Customer Deleted Successfully");
			
		
			
			
		}catch(PersistenceException ex)
		{
			throw new SomethingWentWrongException("Unable to Delete Customer ");
		}
		finally {
			em.close();
		}


	}

	@Override
	public void generateBill(Bill b, int id) throws NoRecordFound,SomethingWentWrongException
	{
		// TODO Auto-generated method stub
//		EntityManager em=EmUtils.getEntityManager();
		EntityManager em=EmUtils.getEntityManager();
		EntityTransaction et=em.getTransaction();
		Customer  cs=null;
		
		try {
	
			cs=em.find(Customer.class, id);
			if(cs==null)
			{
				throw new NoRecordFound("No Record Found");
			}
			b.setConsumer(cs);
			et.begin();
		
			em.persist(cs);
			et.commit();
		
			
			
		}catch(PersistenceException ex)
		{
			System.out.println();
		}finally {
			em.close();
		}
	}

	@Override
	public void viewAllPaidBill() throws SomethingWentWrongException, NoRecordFound {
		// TODO Auto-generated method stub
		EntityManager em=null;
		List<Bill> b;
		try {
			em=EmUtils.getEntityManager();
			Query query=em.createQuery("SELECT b FROM Bill b where b.isPaid=1");
			
			
			b=(List<Bill>)query.getResultList();
			if(b.size()==0)
			{
				throw new NoRecordFound("No Record Found");
			}
			for(Bill b1 : b)
			{
				System.out.println(b1);
			}
			
			}
			catch(PersistenceException ex)
			{
				throw new SomethingWentWrongException("Unable to process request, try again later");
			}
			finally {
				em.close();
			}
	}

	@Override
	public void viewAllPendingBill() throws SomethingWentWrongException, NoRecordFound {
		// TODO Auto-generated method stub
				EntityManager em=null;
				List<Bill> b;
				try {
					em=EmUtils.getEntityManager();
					Query query=em.createQuery("SELECT b FROM Bill b where b.isPaid=0");
					
				
					b=(List<Bill>)query.getResultList();
					if(b.size()==0)
					{
						throw new NoRecordFound("No Record Found");
					}
					for(Bill b1 : b)
					{
						System.out.println(b1);
					}
					
					}
					catch(PersistenceException ex)
					{
						throw new SomethingWentWrongException("Unable to process request, try again later");
					}
					finally {
						em.close();
					}
	}

}
