/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.asatyanarayan1.service;

import edu.iit.sat.itmd4515.asatyanarayan1.domain.Doctor;
import edu.iit.sat.itmd4515.asatyanarayan1.domain.Patient;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;

/**
 *
 * @author amith
 */
@Named
@Stateless
public class PatientService extends AbstractService<Patient> {

    /**
     * Default Constructor
     */
    public PatientService() {
        super(Patient.class);
    }

    /**
     * Find all method is to find all the patients in the system
     * @return List of Patient
     */
    @Override
    public List<Patient> findAll() {
        return em.createNamedQuery("Patient.findAll", Patient.class).getResultList();
    }
    
    /**
     * FindByPUsername method is to find the patient in the system by giving username as a parameter
     * @param username
     * @returns a single patient object 
     */
    public Patient findByPUsername(String username) {
        return em
                .createNamedQuery("Patient.findByPUsername", Patient.class)
                .setParameter("username", username)
                .getSingleResult();
    }
    
}
