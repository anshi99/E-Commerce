package com.nagarro.Product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServer;
import org.springframework.web.bind.annotation.*;


import com.nagarro.Product.model.User;
import com.nagarro.Product.service.RegistrationService;



@RestController
public class RegistrationController {

    @Autowired
    private RegistrationService service;

    @GetMapping("/abc")
    @CrossOrigin(origins = "http://localhost:4200")
    public String myfirstAPI()
    {
        return "Anshika";
    }

    @PostMapping("/registeruser")
    @CrossOrigin(origins = "http://localhost:4200")
    public User registerUser(@RequestBody User user) throws Exception
    {
        System.out.println("Hello Anshika");
        String tempEmailId = user.getEmailId();


        if(tempEmailId !=null && !"".equals(tempEmailId)){
           User userobj = service.fetchUserBEmailId(tempEmailId);
           if(userobj != null)
           {
               throw new Exception("user with" + tempEmailId+" already exists");
           }
        }

        User userObj = null;
        userObj = service.saveUser(user);
        return userObj;
    }

    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:4200")
    public User loginUser(@RequestBody User user) throws Exception {
        String tempEmailId = user.getEmailId();
        String tempPass = user.getPassword();
        User userObj = null;
        if(tempEmailId !=null && tempPass != null)
        {
            userObj = service.fetchUserByEmailIdAndPassword(tempEmailId,tempPass);
        }

        if(userObj == null)
        {
            throw new Exception("Invalid Credentials");
        }
        return userObj;
    }
}
