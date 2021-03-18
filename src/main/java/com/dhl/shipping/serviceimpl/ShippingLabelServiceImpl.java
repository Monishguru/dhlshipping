package com.dhl.shipping.serviceimpl;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhl.shipping.clients.MessageGenClient;
import com.dhl.shipping.constants.ShippingConstants;
import com.dhl.shipping.entity.ShippingLabel;
import com.dhl.shipping.repository.ShippingLabelRepository;
import com.dhl.shipping.service.ShippingLabelService;

@Service
public class ShippingLabelServiceImpl implements ShippingLabelService {

	@Autowired
	ShippingLabelRepository shippingLabelRepository;
	
	@Autowired
	MessageGenClient messageClient;


	@Override
	public ShippingLabel generateTracking(ShippingLabel shippingLabel) throws Exception {
		String trackingNumber = null;
		if (shippingLabel.getShippingPriority() != null) {
			if (shippingLabel.getShippingPriority().equalsIgnoreCase(ShippingConstants.ECONOMY)) {
				trackingNumber = ShippingConstants.ECONOMY.concat(RandomStringUtils.randomAlphanumeric(10));
			} else if (shippingLabel.getShippingPriority().equalsIgnoreCase(ShippingConstants.STANDARD_OVERNGHT)) {
				trackingNumber = ShippingConstants.STANDARD_OVERNGHT.concat(RandomStringUtils.randomAlphanumeric(10));
			} else if (shippingLabel.getShippingPriority().equalsIgnoreCase(ShippingConstants.PRIORITY_OVERNIGHT)) {
				trackingNumber = ShippingConstants.PRIORITY_OVERNIGHT.concat(RandomStringUtils.randomAlphanumeric(10));
			} else {
				trackingNumber = "NORM".concat(RandomStringUtils.randomAlphanumeric(10));
			}

		}
		else {
			throw new Exception("Priority is mandatory to generate tracking number");
		}
		shippingLabel.setTrackingNumber(trackingNumber);
		//messageClient.callDropMessageService(shippingLabel);
		
		return shippingLabelRepository.save(shippingLabel);
	}

	@Override
	public List<ShippingLabel> getShippingsOfCustomer(Long id) {
		return shippingLabelRepository.findByCustomerId(id);
	}

}
