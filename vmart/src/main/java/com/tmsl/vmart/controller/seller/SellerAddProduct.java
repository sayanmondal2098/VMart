package com.tmsl.vmart.controller.seller;

import java.util.Set;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tmsl.vmart.dao.CategoryDAO;
import com.tmsl.vmart.dao.ProductDAO;
import com.tmsl.vmart.dao.SellerDAO;
import com.tmsl.vmart.model.Product;

@CrossOrigin
@Controller
public class SellerAddProduct {

	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private SellerDAO sellerDAO;
	@Autowired
	private CategoryDAO categoryDAO;

	public SellerAddProduct(ProductDAO productDAO, SellerDAO sellerDAO, CategoryDAO categoryDAO) {
		super();
		this.productDAO = productDAO;
		this.sellerDAO = sellerDAO;
		this.categoryDAO = categoryDAO;
	}

	@RequestMapping(value = "/SellerAddProduct", method = RequestMethod.POST)
	public ResponseEntity<String> addProductEntityByEntitySeller(@RequestParam("name") String name,
			@RequestParam("price") Double price, @RequestParam("sellername") String sellerName,
			@RequestParam("descreption") String descreptionString, @RequestParam("catName") String catName,
			@RequestParam("percentage") Double percentage, @RequestParam("specification") Set<String> specification,
			@RequestParam("piclist") Set<String> piclist) {
		JSONObject result = new JSONObject();
		Product product = new Product();
		product.setName(name);
		product.setPrice(price);
		product.setSeller(sellerDAO.getSellerBySellerName(sellerName));
		product.setCategory(categoryDAO.getCategoriesByCatName(catName));
		product.setDescription(descreptionString);
		product.setDiscount(percentage);
		product.setSpecification(specification);
//		String[] elements = piclist.split(",");
//		List<String> fixedLenghtList = Arrays.asList(elements);
//		ArrayList<String> listOfString = new ArrayList<String>(fixedLenghtList);
//		Set<String> s = new HashSet<String>(listOfString);
		product.setPicList(piclist);
//		product.setSpecification(new HashSet<String>(Arrays.asList(specification.split(","))));
		if (productDAO.saveproduct(product)) {
			result.put("registration_status", "successful");

		} else {
			result.put("registration_status", "failed");
		}
		return new ResponseEntity<String>(result.toString(), HttpStatus.OK);
	}
}
