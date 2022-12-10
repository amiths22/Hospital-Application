/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.asatyanarayan1.web;

import edu.iit.sat.itmd4515.asatyanarayan1.domain.Doctor;
import edu.iit.sat.itmd4515.asatyanarayan1.service.DoctorService;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author amith
 */
@Named
@RequestScoped
public class DoctorWelcomeController {

    private static final Logger LOG = Logger.getLogger(DoctorWelcomeController.class.getName());

    //model- To find all the staff working under the doctor
    private Doctor doctor;

    @Inject
    LoginController loginController;
    @EJB
    DoctorService docSvc;

    /**
     * Default constructor
     */
    public DoctorWelcomeController() {
    }

    /**
     * Post construct method
     */
    @PostConstruct
    public void postConstruct() {
        LOG.info("Inside DoctorWelcomeController.postConstruct ");
        doctor = docSvc.findByUsername(loginController.getAuthenticatedUser());
        LOG.info("Leaving Doctor welcomeController.postconstruct with" + doctor.toString());
    }

    //utility method

    /**
     * This is the utility method which helps to refresh the logged in user and update the data in the view
     */
    public void refreshDoctor() {
        doctor = docSvc.findByUsername(loginController.getAuthenticatedUser());
    }

    /**
     * This method is used to find all the doctors in the system
     * @return
     */
    public List<Doctor> findAllDoctors() {
        return docSvc.findAll();
    }
    /**
     * Get the value of doctor
     *
     * @return the value of doctor
     */
    public Doctor getDoctor() {
        return doctor;
    }

    /**
     * Set the value of doctor
     *
     * @param doctor new value of doctor
     */
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

}
