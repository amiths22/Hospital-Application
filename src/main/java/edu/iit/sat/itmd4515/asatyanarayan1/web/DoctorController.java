/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.asatyanarayan1.web;

import edu.iit.sat.itmd4515.asatyanarayan1.domain.Doctor;
import edu.iit.sat.itmd4515.asatyanarayan1.domain.Staff;
import edu.iit.sat.itmd4515.asatyanarayan1.service.DoctorService;
import java.util.ArrayList;
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
public class DoctorController {

    private static final Logger LOG = Logger.getLogger(DoctorWelcomeController.class.getName());

    //model- To find all the staffworking under the doctor
    private Doctor doctor;

    @EJB
    DoctorService docSvc;
//  private List<Doctor> doctors = new ArrayList<>();
    private List<Doctor> doctors = new ArrayList<>();

    public DoctorController() {
    }

    @PostConstruct
    public void postConstruct() {
        LOG.info("Inside DoctorController.postConstruct ");
        doctors = docSvc.findAll();
        LOG.info("Leaving Doctor Controller.postconstruct");
    }

    //utility method
    public String displayReadDoctorPage(Doctor d) {
        this.doctor = d;

        LOG.info("Inside displayReadDoctorPage with" + this.doctor.toString());

        return "/patient/readDoctor.xhtml";

    }

    /*public List<Doctor> findAllDoctors() {
        return docSvc.findAll();
    }*/
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

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

}
