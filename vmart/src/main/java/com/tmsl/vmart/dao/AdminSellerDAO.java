package com.tmsl.vmart.dao;

import java.util.List;

import com.tmsl.vmart.model.Category;
import com.tmsl.vmart.model.Product;
import com.tmsl.vmart.model.Seller;

public interface AdminSellerDAO {

	public List<Seller> getAllSellers();

	public List<Product> getAllProducts();

	public boolean saveCatagory(Category category);
}
