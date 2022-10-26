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
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author amith
 */
public class AbstractJPATest {
     protected static EntityManagerFactory emf;
    //private static final Logger LOG = Logger.getLogger(PatientJPATest.class.getName());
    protected EntityManager em;
    protected EntityTransaction tx;
    
    @BeforeAll
    public static void beforeAll(){
        emf=Persistence.createEntityManagerFactory("itmd4515testPU");
    }
    @BeforeEach
    public void beforeEach(){
    //em
    em=emf.createEntityManager();
    
    //tx
    tx=em.getTransaction();
          
    //create test data for use in every test case
    Patient test=new Patient("Satya",PatientGender.Male,LocalDate.of(1980, Month.MARCH, 15),"Hassan");
    tx.begin();
    em.persist(test);
    tx.commit();
    }
    
    @AfterEach
    public void afterEach(){
    //close some resources
    Patient deleteMe= //em.createQuery("select p from Patient p WHERE p.name='Satya'", Patient.class).getSingleResult();
    em.createNamedQuery("Patient.findByName", Patient.class).setParameter("NAME", "Satya").getSingleResult();
    tx.begin();
    em.remove(deleteMe);
    tx.commit();
    em.close();
    //clean up test data
    }
    
    @AfterAll
    public static void afterAll(){
        emf.close();
    }
}
