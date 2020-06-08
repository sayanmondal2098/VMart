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
import com.tmsl.vmart.dao.CartDAO;
import com.tmsl.vmart.model.Cart;
import com.tmsl.vmart.model.Product;


@Repository
@Transactional
@ContextConfiguration(classes = { ApplicationContextConfig.class })
public class CartDAOImpl implements CartDAO{
	
	@Autowired
	private SessionFactory sFactory;
	
	public CartDAOImpl(SessionFactory sessionFactory) {
		this.sFactory = sessionFactory;
	}

	public List<Product> getAllProducts(long customer_id) {
		Session session = sFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Product> pList = session
		.createQuery("from Cart where cid=:param_cID")
		.setParameter("param_cID", customer_id)
		.list();
		return pList;
	}

	public boolean saveCart(Cart cart) {
		try {
			Session session = sFactory.getCurrentSession();
			session.save(cart);
			
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	public boolean addProduct(Product product, long customerId) {
		try {
			Session session = sFactory.getCurrentSession();
			@SuppressWarnings("unchecked")
			List<Product> pList = session
					.createQuery("from Cart where cid=:param_cID")
					.setParameter("param_cID", customerId)
					.list();
			pList.add(product);
			for (Product product2 : pList) {
				System.out.println(product2);
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Cart getCartbyCustomerid(long customerId) {
		
			Session session = sFactory.getCurrentSession();
			@SuppressWarnings("unchecked")
			List<Cart> cart = session
					.createQuery("from Cart where cid=:param_cID")
					.setParameter("param_cID", customerId).list();
			return cart.get(0);
		
	}

	public boolean isExistingCart(long customerId) {
		Session session = sFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Cart> cart = session
				.createQuery("from Cart where cid=:param_cID")
				.setParameter("param_cID", customerId).list();
		if (cart.size()>0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean removeCart(Cart cart) {
		try {
			Session session = sFactory.getCurrentSession();
			session.remove(cart);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
