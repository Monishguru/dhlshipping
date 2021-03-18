package com.dhl.shipping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dhl.shipping.entity.ShippingLabel;
import com.dhl.shipping.service.ShippingLabelService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/shipping")
@Slf4j
public class ShippingLabelController {
	
	@Autowired
	ShippingLabelService shippingLabelService;
	
	@PostMapping(path="/generateTrackingId", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ShippingLabel generateTrackingNumber(@RequestBody ShippingLabel label) throws Exception {
		log.info("Request received to get tracking");
		return shippingLabelService.generateTracking(label);
		
	}
	
	@GetMapping("/getShippingsOfCustomer/{id}")
	public List<ShippingLabel> getShippingsOfCustomer(@PathVariable("id") Long customerId){
		log.info("Request received to get shippings of customer");
		return shippingLabelService.getShippingsOfCustomer(customerId);
		
	}

}
