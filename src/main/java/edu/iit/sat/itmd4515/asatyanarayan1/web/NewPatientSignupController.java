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

    
    public NewPatientSignupController() {
    }
    
    @PostConstruct
    private void postConstruct(){
        
        LOG.info("Inside the NewPatientSignupController.postConstruct()");
        patient=new Patient();
        
        patient.setUser(new User());
    }
    
    public String executeNewPatientSignupClick(){
        
        LOG.info(this.patient.toString());
        userSvc.signupNewPatientUser(this.patient);
        return "login.xhtml?faces-redirect=true";
    }
    
    public PatientGender[] getAllGenders(){
        return PatientGender.values();
    }
    public Patient getPatient() {
        return patient;
    }
    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
