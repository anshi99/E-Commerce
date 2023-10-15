package com.nagarro.Product.dao;

import com.nagarro.Product.model.FileData;
import com.nagarro.Product.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FileDataRepository extends JpaRepository<Products,Integer> {
    Optional<Products> findByName(String fileName);
}