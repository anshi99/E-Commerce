package com.nagarro.Product.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String emailId;

    private String userName;

    private String password;

    private boolean isAdmin=false;



    public User()
    { }

        public User(int id, String emailId, String userName, String password, boolean isAdmin){
            super();

            this.id = id;
            this.emailId= emailId;
            this.userName=userName;
            this.password=password;
            this.isAdmin = isAdmin;
    }

    public Boolean getIsAdmin() { return isAdmin; }

    public void setIsAdmin(Boolean isAdmin) { this.isAdmin = isAdmin; }

    public int getId(){ return id;}

    public void setId(int id) { this.id = id;}

    public String getEmailId(){ return emailId; }

    public void setEmailId(String emailId){this.emailId = emailId; }

    public String getUserName(){ return userName; }

    public void setUserName(){ this.userName = userName; }

    public String getPassword(){ return password; }

    public void setPassword(String password) {this.password = password; }
}

