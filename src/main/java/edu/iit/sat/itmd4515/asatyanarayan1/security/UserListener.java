/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.asatyanarayan1.security;

import javax.inject.Inject;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;

/**
 *
 * @author amith
 */
public class UserListener {
    
    @Inject private Pbkdf2PasswordHash hash;
    
    
    @PrePersist
    @PreUpdate
    private void prePersistAndUpdate(User u){
        //hash the password value before it hits the database
        u.setPassword(hash.generate(u.getPassword().toCharArray()));
        
    }
}
