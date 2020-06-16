package com.tmsl.vmart.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;

import com.tmsl.vmart.config.ApplicationContextConfig;
import com.tmsl.vmart.dao.CategoryDAO;
import com.tmsl.vmart.model.Category;

@Repository
@Transactional
@ContextConfiguration(classes = { ApplicationContextConfig.class })
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public CategoryDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public boolean saveCatagory(Category category) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(category);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	public boolean isExistingCatagory(String catName) {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Category> categories = session.createQuery("from Category where catName=:param_catName")
				.setParameter("param_catName", catName).list();
		if (categories.size() > 0) {
			return true;
		}
		return false;
	}

	public Category getCategoriesByCatName(String catName) {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Category> categorie = session.createQuery("from Category where catName=:param_catName")
				.setParameter("param_catName", catName).list();
		return categorie.get(0);
	}

	public boolean removeCatagory(Category category) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.remove(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Category> getAllCategories() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Category> categories = session.createQuery("from Category")
				.list();
		return categories;
	}

}
