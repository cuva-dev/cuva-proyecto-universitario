
package com.mycompany.cuvaproject.services;

import com.mycompany.cuvaproject.models.User;

public class serviceUser {
    
    public User create(String name, String lastName, String username, String password, String email, String post){
    
        User user = new User(name, lastName, username,  password,  email,  post);
        
        
        return user;
    
    }
}
