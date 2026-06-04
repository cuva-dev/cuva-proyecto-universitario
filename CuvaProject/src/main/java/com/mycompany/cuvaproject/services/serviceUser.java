
package com.mycompany.cuvaproject.services;

import com.mycompany.cuvaproject.models.User;

public class serviceUser {
    
    public User create(String name, String lastName, String id, String password, String email, String post){
    
        User user = new User(name, lastName, id,  password,  email,  post);
        
        
        return user;
    
    }
}
