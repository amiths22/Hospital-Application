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

    public PatientApptController() {
    }

    @PostConstruct
    private void postConstruct() {
        LOG.info("Inside PatientApptController.postConstruct");
        appt = new Appointment();
        appt.setPatient(patientWelcomeController.getPatient());
        appt.setDoctor(new Doctor());
    }

    public void initDocById() {
        appt.setDoctor(docSvc.read(this.appt.getDoctor().getId()));
    }

    public String displaySchedApptPage(Doctor d) {
        LOG.info("inside displaySchedApptPage " + d.toString());

        this.doc = d;
        appt.setDoctor(doc);
        LOG.info("inside displaySchedApptPage " + appt.getDoctor().toString());

        return "/patient/schedAppt.xhtml";
    }

    public String executeScheduleButtonClick() {
        LOG.info("Inside executeScheduleButtonClick with" + this.appt.toString());
        LOG.info("Inside executeScheduleButtonClick with" + this.appt.getPatient().toString());
//        LOG.info("Inside executeScheduleButtonClick with" + this.doc.toString());
        LOG.info("Inside executeScheduleButtonClick with" + this.appt.getDoctor().toString());
        apptSvc.scheduleAppointment(appt);
        return "/patient/welcome.xhtml";
    }

    public Patient getPat() {
        return pat;
    }

    public void setPat(Patient pat) {
        this.pat = pat;
    }

    public Doctor getDoc() {
        return doc;
    }

    public void setDoc(Doctor doc) {
        this.doc = doc;
    }

    public Appointment getAppt() {
        return appt;
    }

    public void setAppt(Appointment appt) {
        this.appt = appt;
    }
}
