package com.capgemini.flightmanagementsystem.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.capgemini.flightmanagementsystem.dto.AdminLogin;
import com.capgemini.flightmanagementsystem.exception.MailAlreadyExistException;

@Repository
public class AdminLoginDaoImpl implements AdminLoginDao{
	
	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	public AdminLogin auth(String email, String password) {
		EntityManager manager=factory.createEntityManager();
		String jpql="from AdminLogin where email=:email";
		TypedQuery<AdminLogin> query=manager.createQuery(jpql, AdminLogin.class);
		query.setParameter("email", email);
		
		try {
			AdminLogin bean=query.getSingleResult();
			BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
			if(encoder.matches(password, bean.getPassword())){
				manager.close();
				return bean;
			}else {
				manager.close();
				throw new MailAlreadyExistException("Password Invalid");
			}
		} catch (Exception e) {
			manager.close();
			throw new MailAlreadyExistException("Invalid credentials... Please try again");
		}

	}

	@Override
	public boolean register(AdminLogin bean) {
		EntityManager manager= factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(bean);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new MailAlreadyExistException("Email already exist");
		}
	}
}


