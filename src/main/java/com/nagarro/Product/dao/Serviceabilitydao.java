package com.nagarro.Product.dao;

import com.nagarro.Product.model.Serviceability;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Serviceabilitydao extends JpaRepository<Serviceability,Integer> {

    Serviceability findByPincode(int pincode);
}
