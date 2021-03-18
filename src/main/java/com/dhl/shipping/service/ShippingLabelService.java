package com.dhl.shipping.service;

import java.util.List;

import com.dhl.shipping.entity.ShippingLabel;

public interface ShippingLabelService{
	
	public ShippingLabel generateTracking(ShippingLabel shippingLabel) throws Exception;
	
	public List<ShippingLabel> getShippingsOfCustomer (Long id);

}
