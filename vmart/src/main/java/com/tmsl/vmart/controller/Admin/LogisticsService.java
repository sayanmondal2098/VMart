package com.tmsl.vmart.controller.Admin;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tmsl.vmart.dao.LogisticsDAO;
import com.tmsl.vmart.dao.SellerDAO;
import com.tmsl.vmart.model.Seller;

@CrossOrigin
@Controller
public class LogisticsService {
	
	@Autowired
	private LogisticsDAO logisticsDAO;
	private SellerDAO sellerDAO;

	public LogisticsService(LogisticsDAO logisticsDAO, SellerDAO sellerDAO) {
		this.logisticsDAO = logisticsDAO;
		this.sellerDAO = sellerDAO;
	}

	@RequestMapping(value = "/logistic_report", method = RequestMethod.POST)
	public ResponseEntity<String> logisticsReport(@RequestParam("seller_id") Long sellerID,
			@RequestParam("zip") String zip){
		JSONObject result=new JSONObject();
		
		Seller seller=sellerDAO.getSellerBySellerId(sellerID);
		return new ResponseEntity<String>(result.toString(), HttpStatus.OK);		
	}

}
