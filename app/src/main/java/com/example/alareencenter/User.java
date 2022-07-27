package com.example.alareencenter;

public class User {
    String Name;
    String ID;
    String Email;


    public void User(){

    }

    public User(String Name, String ID, String Email) {
        this.Name = Name;
        this.ID = ID;
        this.Email = Email;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}