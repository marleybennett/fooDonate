package com.example.juliettecoia.essai_carte;

/**
 * Created by Legol on 8/8/2016.
 */
public class Account {

    boolean acceptsDonation;
    private String name, org, address, phone, email, verified, food;

    public Account(String namee, String orgg, String addresss,String  phonee, String emaill, boolean accptDonn, String foodd, String verifiedd)
    {
        name = namee;
        org = orgg;
        address = addresss;
        phone = phonee;
        email = emaill;
        acceptsDonation = accptDonn;
        verified = verifiedd;
        food = foodd;
    }

    public String getName()
    {
        return name;
    }

    public String getOrg()
    {
        return org;
    }

    public String getAddress()
    {
        return address;
    }

    public String getPhone()
    {
        return phone;
    }

    public String getEmail()
    {
        return email;
    }


    public String getVerified()
    {
        return verified;
    }

    public Boolean getAcceptDon()
    {
        return acceptsDonation;
    }

    public String getFood()
    {
        return food;
    }

    public void setFood(String f)
    {
        food = f;
    }

}
