/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.asatyanarayan1.web;

import edu.iit.sat.itmd4515.asatyanarayan1.domain.Patient;
import edu.iit.sat.itmd4515.asatyanarayan1.service.PatientService;
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
public class PatientWelcomeController {

    @Inject
    LoginController loginController;
    @EJB
    PatientService patSvc;
    private static final Logger LOG = Logger.getLogger(PatientWelcomeController.class.getName());
    private Patient patient;

    /**
     * Default constructor
     */
    public PatientWelcomeController() {
    }

    /**
     * Post construct method
     */
    @PostConstruct
    public void postConstruct() {
        LOG.info("Inside PatientWelcomeController.postConstruct");
        patient = patSvc.findByPUsername(loginController.getAuthenticatedUser());

    }

    public void refreshPatient() {
        patient = patSvc.findByPUsername(loginController.getAuthenticatedUser());
    }

    /**
     * Get the value of patient
     *
     * @return
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * Set the value of patient
     *
     * @param patient
     */
    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
