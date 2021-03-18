package com.dhl.shipping.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ShippingLabel {
	
	private Long customerId;
	
	private String sourceLocation;
	
	private String destinationLocation;
	
	private String parcelType;
	
	private String shippingPriority;
	
	@Id
	private String trackingNumber;
	
	private Long packageWeight;

}
