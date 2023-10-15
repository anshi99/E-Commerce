package com.nagarro.Product.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nagarro.Product.dao.Serviceabilitydao;
import com.nagarro.Product.controller.ProductController;
import com.nagarro.Product.model.Serviceability;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceabilityService {

    @Autowired
    Serviceabilitydao serviceabilitydao;

    ObjectMapper objectMapper = new ObjectMapper();

    public String searchDaysByPinCode(int pincode) throws JsonProcessingException{

        Serviceability Days = serviceabilitydao.findByPincode(pincode);
        return objectMapper.writeValueAsString(Days);
    }
}
