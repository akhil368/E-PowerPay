package com.masai.SB_101_Project.dao;

import java.util.List;

import com.masai.SB_101_Project.entity.Customer;
import com.masai.SB_101_Project.entity.LoggedInUserId;
import com.masai.SB_101_Project.exceptions.NoRecordFound;
import com.masai.SB_101_Project.exceptions.SomethingWentWrongException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

public class CustomerSideFunctionsImpl implements CustomerSideFunctions {

	@Override
	public void payBill() {
		// TODO Auto-generated method stub

	}

	@Override
	public void viewAllTransactionHistory() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Object[]> getCustomerList() throws SomethingWentWrongException, NoRecordFound {
		// TODO Auto-generated method stub
		EntityManager em=null;
		List<Object[]> custmerList=null;
		try {
			em=EmUtils.getEntityManager();
			
			Query query=em.createQuery("SELECT c.firstName,c.lastName,c.userName,c.address,c.number,c.email,c.isDeletd from Customer c");
			custmerList=query.getResultList();
			if(custmerList.size()==0)
			{
				throw new NoRecordFound("No Customer Found");
			}
		
		
		}catch(PersistenceException ex)
		{
			throw new SomethingWentWrongException("Unable to process request, try again later");
		}
		finally {
			em.close();
		}
		
		return null;
	}

	@Override
	public void login(String userName, String password) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		EntityManager em=null;
		try {
			em=EmUtils.getEntityManager();
			Query query=em.createQuery("SELECT c.id FROM Customer c WHERE userName =:userName AND password = :password AND isDeleted = 0") ;
			query.setParameter("userName", userName);
			query.setParameter("password", password);
			List<Integer> listInt=(List<Integer>)query.getResultList();
			LoggedInUserId.loggedInUserId =listInt.get(0);
			
		}catch(PersistenceException ex)
		{
			throw new SomethingWentWrongException("Unable to process request, try again later");
		}finally{
			em.close();
		}
		
	}

	@Override
	public void changePassword(String oldPassword, String newPassword) throws SomethingWentWrongException{
		EntityManager em = null;
		try {
			em = EmUtils.getEntityManager();
			Query query = em.createQuery("SELECT count(c) FROM Customer c WHERE password = :oldPassword AND id = :id");
			query.setParameter("oldPassword", oldPassword);
			query.setParameter("id", LoggedInUserId.loggedInUserId);
			Long userCount = (Long)query.getSingleResult();
			if(userCount == 0) {
				//you are here old password is incorrect for logged in user
				throw new SomethingWentWrongException("Invalid old password");
			}
			//You are here means all checks done, We can proceed for changing the password
			Customer customer = em.find(Customer.class, LoggedInUserId.loggedInUserId);
			EntityTransaction et = em.getTransaction();
			et.begin();
			customer.setPassword(newPassword);
			et.commit();
		}catch(PersistenceException ex) {
			throw new SomethingWentWrongException("Unable to process request, try again later");
		}finally{
			em.close();
		}
	}

	@Override
	public void deleteAccount() throws SomethingWentWrongException{
		EntityManager em = null;
		try {
			em = EmUtils.getEntityManager();
			Customer customer = em.find(Customer.class, LoggedInUserId.loggedInUserId);
			EntityTransaction et = em.getTransaction();
			et.begin();
			customer.setIsDeleted(1);
			et.commit();
		}catch(PersistenceException ex) {
			throw new SomethingWentWrongException("Unable to process request, try again later");
		}finally{
			em.close();
		}
	}

	@Override
	public void addCustomer(Customer customer) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		
		EntityManager em = null;
		try {
			em = EmUtils.getEntityManager();
			
			//check if company with same username exists
			Query query = em.createQuery("SELECT count(c) FROM Customer c WHERE username = :username");
			query.setParameter("username", customer.getUserName());
			if((Long)query.getSingleResult() > 0) {
				//you are here means company with given name exists so throw exceptions
				throw new SomethingWentWrongException("The username" + customer.getUserName() + " is already occupied");
			}
			
			//you are here means no company with given name
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.persist(customer);
			et.commit();
		}catch(PersistenceException ex) {
			throw new SomethingWentWrongException("Unable to process request, try again later");
		}finally{
			em.close();
		}
	}

}
