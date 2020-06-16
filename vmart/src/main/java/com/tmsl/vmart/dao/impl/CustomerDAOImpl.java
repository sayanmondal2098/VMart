package com.tmsl.vmart.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;

import com.tmsl.vmart.config.ApplicationContextConfig;
import com.tmsl.vmart.dao.CustomerDAO;
import com.tmsl.vmart.model.Customer;

@Repository
@Transactional
@ContextConfiguration(classes = { ApplicationContextConfig.class })
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public CustomerDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public boolean saveCustomer(Customer customer) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(customer);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean isExistCustomer(String email) {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Customer> customerList = session.createQuery("from Customer where email=:param_email")
				.setParameter("param_email", email).list();
		if (customerList.size() > 0) {
			return true;
		}
		return false;
	}

	public boolean verifyCustomer(String email, String password) {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Customer> customerList = session
				.createQuery("from Customer where email=:param_email and password=:param_pass")
				.setParameter("param_email", email).setParameter("param_pass", password).list();
		if (customerList.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	public List<Customer> getAllCustomers() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Customer> customerList = session.createQuery("from Customer").list();
		return customerList;
	}

	public Customer getCustomerByLoginCredentials(String email, String password) {
		Session session = sessionFactory.getCurrentSession();
		Customer customer = (Customer) session
				.createQuery("from Customer where email=:param_email and password=:param_pass")
				.setParameter("param_email", email).setParameter("param_pass", password).uniqueResult();
		return customer;
	}

}
