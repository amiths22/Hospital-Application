/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.asatyanarayan1.web;

import edu.iit.sat.itmd4515.asatyanarayan1.domain.Appointment;
import edu.iit.sat.itmd4515.asatyanarayan1.domain.Doctor;
import edu.iit.sat.itmd4515.asatyanarayan1.domain.Patient;
import edu.iit.sat.itmd4515.asatyanarayan1.service.AppointmentService;
import edu.iit.sat.itmd4515.asatyanarayan1.service.DoctorService;
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
public class PatientApptController {

    private static final Logger LOG = Logger.getLogger(PatientApptController.class.getName());
    private Patient pat;

    private Doctor doc;

    private Appointment appt;
    @Inject
    PatientWelcomeController patientWelcomeController;
    @EJB DoctorService docSvc;
    @EJB AppointmentService apptSvc;

    /**
     * Default constructor
     */
    public PatientApptController() {
    }

    @PostConstruct
    private void postConstruct() {
        LOG.info("Inside PatientApptController.postConstruct");
        appt = new Appointment();
        appt.setPatient(patientWelcomeController.getPatient());
        appt.setDoctor(new Doctor());
        
        LOG.info("Leaving PatientApptController.postConstruct with"+appt.toString());
    }

    /**
     * This method is used to initialize the appt by setting the doctor 
     * Doctor is fetched by the doctor id parameter
     */
    public void initDocById() {
        appt.setDoctor(docSvc.read(this.appt.getDoctor().getId()));
    }
    
    public void initApptById() {
        this.appt=apptSvc.read(appt.getId());
        appt.setDoctor(docSvc.read(this.appt.getDoctor().getId()));
    }


    /**
     * this action method helps to display the appointment scheduling page
     * and setting the parameter of appt object
     * @param d
     * @return
     */
    public String displaySchedApptPage(Doctor d) {
        LOG.info("inside displaySchedApptPage " + d.toString());

        this.doc = d;
        appt.setDoctor(doc);
        LOG.info("inside displaySchedApptPage " + appt.getDoctor().toString());

        return "/patient/schedAppt.xhtml";
    }

    /**
     * This is the action method to schedule the appointment the Schedule button is clicked
     * It saves the data to the DB
     * It redirects the user to welcome page
     * @return
     */
    public String executeScheduleButtonClick() {
        LOG.info("Inside executeScheduleButtonClick with" + this.appt.toString());
        LOG.info("Inside executeScheduleButtonClick with" + this.appt.getPatient().toString());
//        LOG.info("Inside executeScheduleButtonClick with" + this.doc.toString());
        LOG.info("Inside executeScheduleButtonClick with" + this.appt.getDoctor().toString());
        apptSvc.scheduleAppointment(appt);
        patientWelcomeController.refreshPatient();
        return "/patient/welcome.xhtml";
    }
    
    public String executeChangeButtonClick() {
        LOG.info("Inside executeChangeButtonClick with" + this.appt.toString());
        LOG.info("Inside executeChangeButtonClick with" + this.appt.getPatient().toString());
//        LOG.info("Inside executeScheduleButtonClick with" + this.doc.toString());
        LOG.info("Inside executeChangeButtonClick with" + this.appt.getDoctor().toString());
        apptSvc.changeAppointment(appt);
        patientWelcomeController.refreshPatient();
        return "/patient/welcome.xhtml";
    }
    public String executeCancelButtonClick() {
        LOG.info("Inside executeCancelButtonClick with" + this.appt.toString());
        LOG.info("Inside executeCancelButtonClick with" + this.appt.getPatient().toString());
//        LOG.info("Inside executeScheduleButtonClick with" + this.doc.toString());
        LOG.info("Inside executeCancelButtonClick with" + this.appt.getDoctor().toString());
        apptSvc.cancelAppointment(appt);
        patientWelcomeController.refreshPatient();
        return "/patient/welcome.xhtml";
    }

    /**
     * Get the value of patient
     * @return
     */
    public Patient getPat() {
        return pat;
    }

    /**
     * Set the value of patient
     * @param pat
     */
    public void setPat(Patient pat) {
        this.pat = pat;
    }

    /**
     * Get the value of Doctor
     * @return
     */
    public Doctor getDoc() {
        return doc;
    }

    /**
     *Set the value of Doctor
     * @param doc
     */
    public void setDoc(Doctor doc) {
        this.doc = doc;
    }

    /**
     * Get the value of appointment
     * @return
     */
    public Appointment getAppt() {
        return appt;
    }

    /**
     *Set the value of appointment
     * @param appt
     */
    public void setAppt(Appointment appt) {
        this.appt = appt;
    }
}
