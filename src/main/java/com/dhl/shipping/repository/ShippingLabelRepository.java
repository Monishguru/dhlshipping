package com.dhl.shipping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dhl.shipping.entity.ShippingLabel;

@Repository
public interface ShippingLabelRepository extends JpaRepository<ShippingLabel, String>{
	
	public List<ShippingLabel> findByCustomerId(Long id);

}
