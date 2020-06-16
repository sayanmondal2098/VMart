package com.tmsl.vmart.dao;

import java.util.List;

import com.tmsl.vmart.model.Product;
import com.tmsl.vmart.model.Seller;

public interface ProductDAO {

	public boolean saveproduct(Product product);

	public List<Product> getAllProducts();
	
	public List<Product> getProductsByCategory(Long catID);
	
	public Product getProductsByPID(Long pID);

	public boolean isExistingProduct(Long pId);

	public  List<Product>  getProductBySellerName(Seller seller);

}
