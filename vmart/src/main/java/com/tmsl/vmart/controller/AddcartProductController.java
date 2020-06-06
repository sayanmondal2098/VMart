package com.tmsl.vmart.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tmsl.vmart.dao.CartDAO;
import com.tmsl.vmart.dao.ProductDAO;
import com.tmsl.vmart.model.Cart;
import com.tmsl.vmart.model.Product;

@Controller
@CrossOrigin
public class AddcartProductController {
	@Autowired
	private CartDAO cartDAO;
	@Autowired
	private ProductDAO productDAO;

	public AddcartProductController(CartDAO cartDAO, ProductDAO productDAO) {
		super();
		this.cartDAO = cartDAO;
		this.productDAO = productDAO;
	}

	@RequestMapping(value = "/addCart", method = RequestMethod.POST)
	public ResponseEntity<String> setCart(@RequestParam("customerId") long CustomerId,
			@RequestParam("pid") long productiD) {

		if (cartDAO.isExistingCart(CustomerId)) {
			Cart existingCart = cartDAO.getCartbyCustomerid(CustomerId);
			Cart backupCart = existingCart;
			backupCart.getProducts().add(productDAO.getProductsByPID(productiD));
			backupCart.setCid(CustomerId);
			cartDAO.saveCart(backupCart);
			cartDAO.removeCart(existingCart);
		} else {
			Cart newcart = new Cart();
			Product product = productDAO.getProductsByPID(productiD);
			newcart.setCid(CustomerId);
			newcart.getProducts().add(product);
			cartDAO.saveCart(newcart);
		}

		List<Product> cartProduct = cartDAO.getAllProducts(CustomerId);
		cartProduct.add(productDAO.getProductsByPID(productiD));
//		cartDAO.saveCart(cart)
		JSONObject result = new JSONObject();
//		JSONArray productList = new JSONArray();
		result.put("cart", "added successfully");

		return new ResponseEntity<String>(result.toString(), HttpStatus.OK);
	}
}
