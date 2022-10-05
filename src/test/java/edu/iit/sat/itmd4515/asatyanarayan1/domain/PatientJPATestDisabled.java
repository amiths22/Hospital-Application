/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.asatyanarayan1.domain;

import java.time.LocalDate;
import java.time.Month;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author amith
 */
public class PatientJPATestDisabled extends AbstractJPATest{
    
    //private static EntityManagerFactory emf;
    private static final Logger LOG = Logger.getLogger(PatientJPATestDisabled.class.getName());
    //private EntityManager em;
    //private EntityTransaction tx;
    
    
    @Test
    public void createTest(){
        Patient createMe=new Patient("Almitha",PatientGender.Female,LocalDate.of(1995, Month.AUGUST, 20),"Hassan");
        tx.begin();
        em.persist(createMe);
        tx.commit();
        
        Patient compareMe=em.find(Patient.class,createMe.getId());
        assertEquals(createMe.getName(),compareMe.getName());
        
        tx.begin();
        em.remove(createMe);
        tx.commit();
    }
    
    @Test
    public void readTest(){
        Patient readMe= em.createQuery("select p from Patient p WHERE p.name='Satya'", Patient.class).getSingleResult();
        
        assertEquals("Satya",readMe.getName());
    }
    
    @Test
    public void updateTest(){
        Patient updateMe= em.createQuery("select p from Patient p WHERE p.name='Satya'", Patient.class).getSingleResult();
        tx.begin();
        updateMe.setAddress("Banglore");
        tx.commit();
        
        Patient compareMe=em.find(Patient.class,updateMe.getId());
        assertEquals(updateMe.getAddress(),compareMe.getAddress());
    }
    
    @Test
    public void deleteTest(){
        Patient deleteMe=new Patient("Almitha",PatientGender.Female,LocalDate.of(1990, Month.MARCH, 20),"Hassan");
        tx.begin();
        em.persist(deleteMe);
        tx.commit();
        
        assertNotNull(deleteMe.getId());
        
        tx.begin();
        em.remove(deleteMe);
        tx.commit();
        
        Patient existanceCheck=em.find(Patient.class,deleteMe.getId());
        assertNull(existanceCheck);
    }
}
