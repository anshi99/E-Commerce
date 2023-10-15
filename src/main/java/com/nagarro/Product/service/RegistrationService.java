package com.nagarro.Product.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.nagarro.Product.model.User;
import com.nagarro.Product.dao.Registrationdao;

@Service
public class RegistrationService {

    @Autowired
    private Registrationdao repo;

    public User saveUser(User user){return repo.save(user);}


    public User fetchUserBEmailId(String email){ return repo.findByEmailId(email);}

    public User fetchUserByEmailIdAndPassword(String email, String password){
        return repo.findByEmailIdAndPassword(email,password);
    }

    //public Long countUsers(){ return repo.count();}
}


