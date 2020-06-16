package com.tmsl.vmart.controller;

import java.util.List;

import org.json.JSONArray;
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
import com.tmsl.vmart.model.Product;

@Controller
@CrossOrigin
public class GetCartController {
	@Autowired
	private CartDAO cartDAO;

	public GetCartController(CartDAO cartDAO) {
		super();
		this.cartDAO = cartDAO;
	}

	@RequestMapping(value = "/getcart", method = RequestMethod.POST)
	public ResponseEntity<String> getCart(@RequestParam("customerId") int CustomerId) {
		List<Product> cartProduct = cartDAO.getAllProducts(CustomerId);
		JSONObject result = new JSONObject();
		JSONArray productList = new JSONArray();
		for (Product p : cartProduct) {
			JSONObject tempCust = new JSONObject();
			tempCust.put("Pname", p.getName());
			tempCust.put("Price", p.getPrice());
			tempCust.put("pic", p.getPicList());
			productList.put(tempCust);
		}
		result.put("cart", productList);

		return new ResponseEntity<String>(result.toString(), HttpStatus.OK);
	}
}
