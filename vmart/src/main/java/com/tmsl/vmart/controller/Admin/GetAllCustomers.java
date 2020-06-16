package com.tmsl.vmart.controller.Admin;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tmsl.vmart.dao.CustomerDAO;
import com.tmsl.vmart.model.Customer;

@Controller
public class GetAllCustomers {

	@Autowired
	private CustomerDAO customerDAO;

	public GetAllCustomers(CustomerDAO customerDAO) {
		super();
		this.customerDAO = customerDAO;
	}

	@RequestMapping(value = "/all_customers", method = RequestMethod.POST)
	public ResponseEntity<String> Login(@RequestParam("adminId") String adminEmail,
			@RequestParam("password") String adminPassword) {
		List<Customer> customers = customerDAO.getAllCustomers();
		JSONObject result = new JSONObject();
		JSONArray customerList = new JSONArray();
		for (Customer c : customers) {
			JSONObject tempCust = new JSONObject();
			tempCust.put("cid", c.getCid());
			tempCust.put("name", c.getName());
			tempCust.put("email", c.getEmail());
			tempCust.put("password", c.getPassword());
			customerList.put(tempCust);
		}
		result.put("customers", customerList);

		return new ResponseEntity<String>(result.toString(), HttpStatus.OK);
	}

}
