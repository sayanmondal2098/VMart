package com.tmsl.vmart.dao;

import java.util.List;

import com.tmsl.vmart.model.Cart;
import com.tmsl.vmart.model.Product;

public interface CartDAO {
	public List<Product> getAllProducts(long customer_id);

	public boolean saveCart(Cart cart);

	public boolean addProduct(Product product, long customerId);

	public Cart getCartbyCustomerid(long customerId);
	
	public boolean isExistingCart(long customerId);
	
	
	public boolean removeCart(Cart cart);
	
}
