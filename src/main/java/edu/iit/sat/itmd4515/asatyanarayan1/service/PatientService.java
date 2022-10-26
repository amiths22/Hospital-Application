/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.asatyanarayan1.service;

import edu.iit.sat.itmd4515.asatyanarayan1.domain.Patient;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author amith
 */
@Stateless
public class PatientService extends AbstractService<Patient> {

    public PatientService() {
        super(Patient.class);
    }

    
    @Override
    public List<Patient> findAll() {
        return em.createNamedQuery("Patient.findAll", Patient.class).getResultList();
    }
    
    
    
}
