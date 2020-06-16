package com.tmsl.vmart.dao;

import java.util.List;

import com.tmsl.vmart.model.Category;

public interface CategoryDAO {
	
	public boolean saveCatagory(Category category);
	
	public boolean isExistingCatagory(String sizeChart);
	
	public Category getCategoriesByCatName(String catName);
	
	public boolean removeCatagory(Category category);
	
	public List<Category> getAllCategories();

}
