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

import com.tmsl.vmart.dao.PromoDAO;
import com.tmsl.vmart.model.PromoImage;


@Controller
@CrossOrigin
public class PromoController {
	
	@Autowired
	private PromoDAO promoDAO;
	
	public PromoController(PromoDAO promoDAO) {
		super();
		this.promoDAO = promoDAO;
	}
	
	@RequestMapping(value = "/promoimages",method = RequestMethod.GET)
	public ResponseEntity<String> promoImages() {
		JSONObject result=new JSONObject();	
		List<PromoImage> imgList=promoDAO.getAllPromoImages();
		if(imgList.size()==0)
		{
			result.put("status", "error");
			result.put("message", "no_images_found");
		}
		else
		{
			JSONArray array=new JSONArray();
			for(PromoImage p:imgList)
			{
				JSONObject obj=new JSONObject();
				obj.put("id", p.getPromoID());
				obj.put("name", p.getName());
				obj.put("url", p.getUrl());
				obj.put("redirect", p.getRedirect());
				array.put(obj);
			}
			result.put("images", array);
			result.put("status", "success");
			result.put("message", "images_found");
		}
		return new ResponseEntity<String>(result.toString(), HttpStatus.OK);
	}

}
