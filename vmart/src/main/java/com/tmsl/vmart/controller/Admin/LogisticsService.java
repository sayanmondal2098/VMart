package com.tmsl.vmart.controller.Admin;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tmsl.vmart.config.SecureConstants;
import com.tmsl.vmart.dao.LogisticsDAO;
import com.tmsl.vmart.dao.SellerDAO;
import com.tmsl.vmart.model.Logistics;
import com.tmsl.vmart.model.Seller;
import com.tmsl.vmart.utils.HttpRequester;

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
		
		Map<String, String> params=new HashMap<>();
		params.put("q", zip);
		params.put("apiKey", SecureConstants.HERE_MAPS_API_KEY);
		
		try {
			JSONObject zipToCoord=new JSONObject(HttpRequester
					.getResponseGET("https://geocode.search.hereapi.com/v1/geocode", params));
			JSONObject coordinates=zipToCoord.getJSONArray("items")
					.getJSONObject(0)
					.getJSONObject("position");
			result.put("user_coordinates",coordinates.get("lat")+","+coordinates.get("lng"));
		} catch (JSONException | IOException | InterruptedException | URISyntaxException e) {
			e.printStackTrace();
			result.put("user_coordinates", "Unable to retrieve coordinates from ZIP");
			return new ResponseEntity<String>(result.toString(), HttpStatus.OK);
		}
		
		Seller seller=sellerDAO.getSellerBySellerId(sellerID);
		result.put("seller_coordinates", seller.getGpsCoordinates());
		
		Map<String, String> paramDistance=new HashMap<>();
		paramDistance.put("origin", result.getString("seller_coordinates"));
		paramDistance.put("destination", result.getString("user_coordinates"));
		paramDistance.put("return", "summary");
		paramDistance.put("transportMode", "truck");
		paramDistance.put("apiKey", SecureConstants.HERE_MAPS_API_KEY);
		
		try {
			JSONObject route=new JSONObject(HttpRequester
					.getResponseGET("https://router.hereapi.com/v8/routes", paramDistance));
			JSONObject summary=route.getJSONArray("routes")
					.getJSONObject(0)
					.getJSONArray("sections")
					.getJSONObject(0)
					.getJSONObject("summary");
			result.put("distanceInMetres", summary.get("length"));
			result.put("durationInMinutes", summary.get("duration"));
		} catch (JSONException | IOException | InterruptedException | URISyntaxException e) {
			e.printStackTrace();
			result.put("distanceInMetres", "Unable to track truck route distance");
			result.put("durationInMinutes", "Unable to track truck route duration");
			return new ResponseEntity<String>(result.toString(), HttpStatus.OK);
		}	
		
		Logistics logistics=logisticsDAO.getLogisticalInfo(Double.parseDouble(result.get("distanceInMetres").toString()));
		if(null==logistics)
		{
			result.put("deliveryAmount", "not_deliverable");
		}
		else
		{
			result.put("deliveryAmount", logistics.getDeliveryChargeAmount());
		}		
		
		return new ResponseEntity<String>(result.toString(), HttpStatus.OK);		
	}

}
