package com.nagarro.Product.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

import com.nagarro.Product.model.Products;

public interface Productdao extends JpaRepository<Products, Integer> {

    public List<Products> findByName(String name);

    public List<Products> findByBrand(String brand);

    public List<Products> findByIdOrNameOrBrand(int id,String name,String brand);

    public List<Products> findByIdAndNameAndBrand(int id,String name,String brand);

    public List<Products> findPriceByIdAndBrandAndName(int id, String productName,
                                                      String brandName, String productCode ,
                                                       int min, int max);







    //Optional<Products> findByName(String filename);

}
