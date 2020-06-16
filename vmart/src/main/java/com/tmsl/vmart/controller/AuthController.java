package com.tmsl.vmart.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tmsl.vmart.dao.CustomerDAO;
import com.tmsl.vmart.model.Customer;

import static com.tmsl.vmart.utils.Encryptionmd5.md5;

@Controller
@CrossOrigin
public class AuthController {
	
	@Autowired
	private CustomerDAO customerDAO;

	public AuthController(CustomerDAO customerDAO) {
		super();
		this.customerDAO = customerDAO;
	}
	
	@RequestMapping(value = "/register",method = RequestMethod.POST)
	public ResponseEntity<String> register(@RequestParam("name") String name,
			@RequestParam("email") String email,
			@RequestParam("password") String password){
		JSONObject result=new JSONObject();			
		if(!customerDAO.isExistCustomer(email)) 
		{
			result.put("existence_check", "not_found");
			Customer customer=new Customer();
			customer.setEmail(email);
			customer.setName(name);
			customer.setPassword(md5(password));
			if(customerDAO.saveCustomer(customer))
			{
				result.put("registration_status", "successful");
				Customer cust=customerDAO.getCustomerByLoginCredentials(email, md5(password));
				result.put("uid", cust.getCid());
				result.put("name", cust.getName());
			}
			else
			{
				result.put("registration_status", "failed");
			}
		}
		else
		{
			result.put("existence_check", "found");
		}
		return new ResponseEntity<String>(result.toString(), HttpStatus.OK);
	}
}
