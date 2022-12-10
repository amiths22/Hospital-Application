/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.asatyanarayan1.web;

import edu.iit.sat.itmd4515.asatyanarayan1.domain.Doctor;
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
public class NewDoctorController {

    private static final Logger LOG = Logger.getLogger(NewDoctorController.class.getName());



    @EJB UserService userSvc;
    private Doctor doctor;

    /**
     * Default Constructor  
     */
    public NewDoctorController() {
    }
    
    @PostConstruct
    private void postConstruct(){
        
        LOG.info("Inside the NewPatientSignupController.postConstruct()");
        doctor=new Doctor();
        
        doctor.setUser(new User());
    }
    
    /**
     * This is the action method to create a new patient using sign up
     * @return
     */
    public String executeNewDoctorClick(){
        
        LOG.info(this.doctor.toString());
        userSvc.signupNewDoctorUser(this.doctor);
        return "/admin/welcome.xhtml?faces-redirect=true";
    }
    
   
    public Doctor getDoctor() {
        return doctor;
    }
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}


