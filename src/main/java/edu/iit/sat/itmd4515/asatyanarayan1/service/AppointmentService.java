/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.asatyanarayan1.service;

import edu.iit.sat.itmd4515.asatyanarayan1.domain.Appointment;
import edu.iit.sat.itmd4515.asatyanarayan1.domain.Doctor;
import edu.iit.sat.itmd4515.asatyanarayan1.domain.Patient;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;

/**
 *
 * @author amith
 */
@Named
@Stateless
public class AppointmentService extends AbstractService<Appointment> {

    /**
     * Default constructor
     */
    public AppointmentService() {
        super(Appointment.class);
    }

    /**
     *  Find all method is to find all the appointments in the system
     * @return List of Appointment
     */
    @Override
    public List<Appointment> findAll() {
        return em.createNamedQuery("Appointment.findAll", Appointment.class).getResultList();
    }
    
    /**
     * Helper method to schedule an appointment for the patient 
     * By setting the selected date, time and a particular doctor
     * @param appt
     */
    public void scheduleAppointment(Appointment appt){
        Appointment newAppt=new Appointment();
        newAppt.setAppointDate(appt.getAppointDate());
        newAppt.setAppointTime(appt.getAppointTime());
        
        Patient patientRef=em.getReference(Patient.class, appt.getPatient().getId());
        Doctor doctorRef=em.getReference(Doctor.class, appt.getDoctor().getId());
        
        newAppt.addAppt(patientRef, doctorRef);
        em.persist(newAppt);
    }
    
    public void cancelAppointment(Appointment appt){
        appt=em.getReference(Appointment.class, appt.getId());
        appt.delAppt();
        
        em.remove(appt);
    }
    
    public void changeAppointment(Appointment appt){
        Appointment managedAppt = em.getReference(Appointment.class, appt.getId());
        
        managedAppt.setAppointDate(appt.getAppointDate());
        managedAppt.setAppointTime(appt.getAppointTime()); 
        em.persist(managedAppt);
    }
    
    
}
