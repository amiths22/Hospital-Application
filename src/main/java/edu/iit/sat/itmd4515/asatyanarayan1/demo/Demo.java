/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.asatyanarayan1.demo;

import edu.iit.sat.itmd4515.asatyanarayan1.domain.Patient;
import edu.iit.sat.itmd4515.asatyanarayan1.domain.PatientGender;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author amith
 */
public class Demo {

    /**
     *
     * @param args arguments
     */
    public static void main(String ... args){
        System.out.println("Hello");
        
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("itmd4515testPU");
        EntityManager em=emf.createEntityManager();
        EntityTransaction tx=em.getTransaction();
        tx.begin();
        
        Patient pat=new Patient();
        //pat.setId();
        pat.setName("amith");
        pat.setGender(PatientGender.Male);
        System.out.println(pat.toString());
        em.persist(pat);
        
        tx.commit();
        
    }
    
}
