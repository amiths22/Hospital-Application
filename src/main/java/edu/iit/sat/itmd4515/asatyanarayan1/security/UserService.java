/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.asatyanarayan1.security;

import edu.iit.sat.itmd4515.asatyanarayan1.domain.Doctor;
import edu.iit.sat.itmd4515.asatyanarayan1.domain.Patient;
import edu.iit.sat.itmd4515.asatyanarayan1.service.AbstractService;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author amith
 */
@Stateless
public class UserService extends AbstractService<User>{

    /**
     * Default Constructor
     */
    public UserService() {
        super(User.class);
    }
    
    /**
     * Find all method is to find all the user in the system
     * @return
     */
    @Override
    public List<User> findAll() {
                return em.createNamedQuery("User.findAll", User.class).getResultList();
    }
    
    /**
     * Helper method to add a new patient using the signup module
     * @param p
     */
    public void signupNewPatientUser(Patient p){
        //
        Group patientGroup=em.createQuery("select g from Group g where g.groupName='PATIENT_GROUP'", Group.class).getSingleResult();
        p.getUser().addGroup(patientGroup);
        p.getUser().setEnabled(true);
        em.persist(p.getUser());
        
        em.persist(p);
    }

    /**
     * Helper method to add a new doctor using the admin module
     * @param d
     */
    public void signupNewDoctorUser(Doctor d){
        //
        Group doctorGroup=em.createQuery("select g from Group g where g.groupName='DOCTOR_GROUP'", Group.class).getSingleResult();
        d.getUser().addGroup(doctorGroup);
        d.getUser().setEnabled(true);
        em.persist(d.getUser());
        
        em.persist(d);
    }
}
