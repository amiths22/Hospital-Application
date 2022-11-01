/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.asatyanarayan1.web;

import edu.iit.sat.itmd4515.asatyanarayan1.domain.Patient;
import edu.iit.sat.itmd4515.asatyanarayan1.domain.PatientGender;
import edu.iit.sat.itmd4515.asatyanarayan1.service.PatientService;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author amith
 */
@Named
@RequestScoped
public class PatientController {

    private static final Logger LOG = Logger.getLogger(PatientController.class.getName());

    @EJB private PatientService patSvc;

    private Patient patient;
    public PatientController() {
    }


    @PostConstruct
    private void postConstruct() {
        LOG.info("PatientController.postconstruct");
        patient=new Patient();
    }
    //helper method
    public PatientGender[] getAllGenders(){
        return PatientGender.values();
    }

    //axtion methods
    public String savePatient() {
        LOG.info("Inside savePatient "+ this.patient.toString());
        
        patSvc.create(patient);
        
        return "confirmation.xhtml"; 

    }
    public Patient getPatient() {
        return patient;
    }
    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
