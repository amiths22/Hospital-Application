/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.asatyanarayan1.web;

import edu.iit.sat.itmd4515.asatyanarayan1.domain.Patient;
import edu.iit.sat.itmd4515.asatyanarayan1.domain.PatientGender;
import edu.iit.sat.itmd4515.asatyanarayan1.security.User;
import edu.iit.sat.itmd4515.asatyanarayan1.security.UserService;
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
public class NewPatientSignupController {

    private static final Logger LOG = Logger.getLogger(NewPatientSignupController.class.getName());

    private Patient patient;

    @EJB UserService userSvc;

    /**
     * Default Constructor  
     */
    public NewPatientSignupController() {
    }
    
    @PostConstruct
    private void postConstruct(){
        
        LOG.info("Inside the NewPatientSignupController.postConstruct()");
        patient=new Patient();
        
        patient.setUser(new User());
    }
    
    /**
     * This is the action method to create a new patient using sign up
     * @return
     */
    public String executeNewPatientSignupClick(){
        
        LOG.info(this.patient.toString());
        userSvc.signupNewPatientUser(this.patient);
        return "login.xhtml?faces-redirect=true";
    }
    
    /**
     * This function returns all the values of the enumerator in the form of an array
     * @return
     */
    public PatientGender[] getAllGenders(){
        return PatientGender.values();
    }

    /**
     * Get the value of patient
     * @return
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * Set the value of patient
     * @param patient
     */
    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
