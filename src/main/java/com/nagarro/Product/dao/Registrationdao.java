package com.nagarro.Product.dao;

import com.nagarro.Product.model.User;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface Registrationdao extends JpaRepository<User, Integer> {

    //List<Object> ;

    public User findByEmailId(String emailId);

    public User findByEmailIdAndPassword(String emailId, String password);
}
