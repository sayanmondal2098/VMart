package com.tmsl.vmart.dao;

import java.util.List;

import com.tmsl.vmart.model.Product;
import com.tmsl.vmart.model.Seller;

public interface SellerDAO {
	public boolean saveSeller(Seller seller);

	public boolean isExistingSeller(String name);

	public boolean verifySeller(String name, String password);

	public Seller getSellerBySellerName(String name);
	
	public Seller getSellerBySellerId(Long sid);

	public List<Product> getAllProducts();

	public boolean addProduct(Product product);

	public boolean removeProduct(Integer pId);

	public Seller getSellerByLoginCredentials(String name, String password);


}
