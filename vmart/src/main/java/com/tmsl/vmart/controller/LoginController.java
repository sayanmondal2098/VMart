package com.tmsl.vmart.controller;

import static com.tmsl.vmart.utils.Encryptionmd5.md5;

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


@Controller
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {
	
	@Autowired
	private CustomerDAO customerDAO;
	
	public LoginController(CustomerDAO customerDAO) {
		super();
		this.customerDAO = customerDAO;
	}
	
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public ResponseEntity<String> Login(@RequestParam("email") String email,
			@RequestParam("password") String password) {
		JSONObject result=new JSONObject();	
		if(customerDAO.isExistCustomer(email)) 
		{
			result.put("existence_check", "found");
			if(customerDAO.verifyCustomer(email, md5(password)))
			{
				result.put("login_status", "successful");
				Customer customer=customerDAO.getCustomerByLoginCredentials(email, md5(password));
				result.put("uid", customer.getCid());
				result.put("name", customer.getName());
			}
			else {
				result.put("login_status", "failed");
			}
		}
		else
		{
			result.put("existence_check", "not_found");
		}
		return new ResponseEntity<String>(result.toString(), HttpStatus.OK);
	}

}
