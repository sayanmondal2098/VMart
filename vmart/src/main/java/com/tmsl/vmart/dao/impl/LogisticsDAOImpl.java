package com.tmsl.vmart.dao.impl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;

import com.tmsl.vmart.config.ApplicationContextConfig;
import com.tmsl.vmart.dao.LogisticsDAO;
import com.tmsl.vmart.model.Logistics;

@Repository
@Transactional
@ContextConfiguration(classes = { ApplicationContextConfig.class })
public class LogisticsDAOImpl implements LogisticsDAO {
	
	@Autowired
	private SessionFactory sessionFactory;	

	public LogisticsDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Logistics getLogisticalInfo(Double distance) {
		Session session = sessionFactory.getCurrentSession();
		Logistics logistics=(Logistics)session.createQuery("from Logistics where distanceLowerRange<=:param_distance AND distanceUpperRange>=:param_distance")
				.setParameter("param_distance", distance)
				.uniqueResult();
		if(null==logistics)
		{
			Logistics logistics1=(Logistics)session.createQuery("from Logistics where deliveryChargeAmount=(select MAX(deliveryChargeAmount) from Logistics)")
					.uniqueResult();
			return logistics1;
		}
		return logistics;
	}

}
