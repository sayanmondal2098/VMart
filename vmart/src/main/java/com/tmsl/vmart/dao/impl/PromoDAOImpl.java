package com.tmsl.vmart.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;

import com.tmsl.vmart.config.ApplicationContextConfig;
import com.tmsl.vmart.dao.PromoDAO;
import com.tmsl.vmart.model.PromoImage;

@Repository
@Transactional
@ContextConfiguration(classes = { ApplicationContextConfig.class })
public class PromoDAOImpl implements PromoDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public PromoDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}



	@SuppressWarnings("unchecked")
	public List<PromoImage> getAllPromoImages() {
		Session session =  sessionFactory.getCurrentSession();
		List<PromoImage> promoImages = session
				.createQuery("from PromoImage")
				.list();
		return promoImages;
	}

}
