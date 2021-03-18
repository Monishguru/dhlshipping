package com.dhl.shipping.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.dhl.shipping.entity.ShippingLabel;

@FeignClient("MESSAGE-GEN-SERVICE")
public interface MessageGenClient {
	
	@PostMapping("/generate/trackingMessage")
	void callDropMessageService(@RequestBody ShippingLabel label);

}
