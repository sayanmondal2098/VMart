package com.tmsl.vmart.controller.Admin;

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

import com.tmsl.vmart.dao.ProductDAO;
import com.tmsl.vmart.model.Product;

@CrossOrigin
@Controller
public class GetAllProducts {

	@Autowired
	private ProductDAO productDAO;

	public GetAllProducts(ProductDAO productDAO) {
		super();
		this.productDAO = productDAO;
	}

	@RequestMapping(value = "/all_products", method = RequestMethod.POST)
	public ResponseEntity<String> AllProduct(@RequestParam("adminId") String adminEmail,
			@RequestParam("password") String adminPassword) {
		List<Product> products = productDAO.getAllProducts();
		JSONObject result = new JSONObject();
		JSONArray productList = new JSONArray();
		for (Product p : products) {
			JSONObject tempCust = new JSONObject();
			tempCust.put("pid", p.getPid());
			tempCust.put("name", p.getName());
			tempCust.put("category", p.getCategory().getCatName());		
			tempCust.put("discount", p.getDiscount());
			tempCust.put("seller", p.getSeller().getSellerID());
			tempCust.put("getDescription", p.getDescription());
			tempCust.put("price", p.getPrice());
			JSONArray pictures=new JSONArray();
			for(String s:p.getPicList())
			{
				JSONObject tPic=new JSONObject();
				tPic.put("url", s);
				pictures.put(tPic);
			}
			tempCust.put("pictures",pictures);
			JSONArray specs=new JSONArray();
			for(String s:p.getSpecification())
			{
				JSONObject spec=new JSONObject();
				spec.put("spec", s);
				specs.put(spec);
			}
			tempCust.put("specifications",specs);
			productList.put(tempCust);
		}
		result.put("products", productList);

		return new ResponseEntity<String>(result.toString(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ResponseEntity<String> ProductsByCat(@RequestParam("cat_id") Long catID) {
		JSONObject result = new JSONObject();
		List<Product> products = productDAO.getProductsByCategory(catID);
		if(products.size()==0)
		{
			result.put("status", "error");
			result.put("message", "no_products_found");
			return new ResponseEntity<String>(result.toString(), HttpStatus.OK);
		}
		JSONArray productList = new JSONArray();
		for (Product p : products) {
			JSONObject tempCust = new JSONObject();
			tempCust.put("pid", p.getPid());
			tempCust.put("name", p.getName());
			tempCust.put("discount", p.getDiscount());
			tempCust.put("price", p.getPrice());
			JSONArray pictures=new JSONArray();
			for(String s:p.getPicList())
			{
				JSONObject tPic=new JSONObject();
				tPic.put("url", s);
				pictures.put(tPic);
			}
			tempCust.put("pictures",pictures);
			productList.put(tempCust);
		}
		result.put("products", productList);		
		result.put("status", "success");
		result.put("message", "products_found");
		return new ResponseEntity<String>(result.toString(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/prod", method = RequestMethod.POST)
	public ResponseEntity<String> ProductsByPID(@RequestParam("prod_id") Long pID) {
		JSONObject result = new JSONObject();
		Product product = productDAO.getProductsByPID(pID);
		if(null==product)
		{
			result.put("status", "error");
			result.put("message", "product_not_found");
			return new ResponseEntity<String>(result.toString(), HttpStatus.OK);
		}
		JSONArray picList=new JSONArray();
		for(String s:product.getPicList())
		{
			JSONObject obj=new JSONObject();
			obj.put("url", s);
			picList.put(obj);
		}
		result.put("pictures",picList);
		result.put("category", product.getCategory().getCatName());
		result.put("discount", product.getDiscount());
		result.put("price", product.getPrice());	
		result.put("sellerID", product.getSeller().getSellerID());
		result.put("sellerName", product.getSeller().getName());
		result.put("sellerAddress", product.getSeller().getAddress());
		result.put("sellerPhone", product.getSeller().getPhoneNo());
		result.put("sellerGPS", product.getSeller().getGpsCoordinates());
		result.put("sellerVerified", product.getSeller().getVerified());
		JSONArray specList=new JSONArray();
		for(String s:product.getSpecification())
		{
			JSONObject obj=new JSONObject();
			obj.put("spec", s);
			specList.put(obj);
		}
		result.put("specifications",specList);
		result.put("description", product.getDescription());	
		result.put("status", "success");
		result.put("message", "product_found");
		return new ResponseEntity<String>(result.toString(), HttpStatus.OK);
	}

}
