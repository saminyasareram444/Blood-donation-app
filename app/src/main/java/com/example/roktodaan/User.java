package com.example.roktodaan;

import android.widget.Spinner;

public class User {
    String UserId;
    String Name;
    String Contact;
    String Bloodgroup;

    public User()
    {

    }

    public User(String userId, String name, String contact, String bloodgroup) {
        UserId = userId;
        Name = name;
        Contact = contact;
        Bloodgroup = bloodgroup;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public void setBloodgroup(String bloodgroup) {
        Bloodgroup = bloodgroup;
    }

    public String getUserId() {
        return UserId;
    }

    public String getName() {
        return Name;
    }

    public String getContact() {
        return Contact;
    }

    public String getBloodgroup() {
        return Bloodgroup;
    }
}
