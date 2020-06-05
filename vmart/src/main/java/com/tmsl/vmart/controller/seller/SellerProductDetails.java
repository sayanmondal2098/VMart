package com.tmsl.vmart.controller.seller;

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
import com.tmsl.vmart.dao.SellerDAO;
import com.tmsl.vmart.model.Product;
import com.tmsl.vmart.model.Seller;

@Controller
@CrossOrigin
public class SellerProductDetails {
	
	@Autowired
	private ProductDAO productDAO;
	private SellerDAO sellerDAO;

	public SellerProductDetails(ProductDAO productDAO,SellerDAO sellerDAO) {
		// TODO Auto-generated constructor stub
		super();
		this.productDAO = productDAO;
		this.sellerDAO = sellerDAO;

	}

	@RequestMapping(value = "/SellergetAllProducts", method = RequestMethod.POST)
	public ResponseEntity<String> AllProductBySeller(@RequestParam("sellerName") String SellerName) {
		
		Seller thisSeller = sellerDAO.getSellerBySellerName(SellerName);
		List<Product> products = productDAO.getProductBySellerName(thisSeller);
		JSONObject result = new JSONObject();
		JSONArray productList = new JSONArray();
		for (Product p : products) {
			JSONObject tempCust = new JSONObject();
			tempCust.put("pid", p.getPid());
			tempCust.put("name", p.getName());
			tempCust.put("category", p.getCategory().getCatName());
			tempCust.put("discount", p.getDiscount());
			tempCust.put("getDescription", p.getDescription());
			tempCust.put("price", p.getPrice());
			JSONArray pictures = new JSONArray();
			for (String s : p.getPicList()) {
				JSONObject tPic = new JSONObject();
				tPic.put("url", s);
				pictures.put(tPic);
			}
			tempCust.put("pictures", pictures);
			JSONArray specs = new JSONArray();
			for (String s : p.getSpecification()) {
				JSONObject spec = new JSONObject();
				spec.put("spec", s);
				specs.put(spec);
			}
			tempCust.put("specifications", specs);
			productList.put(tempCust);
		}
		result.put("products", productList);

		return new ResponseEntity<String>(result.toString(), HttpStatus.OK);

	}

}
