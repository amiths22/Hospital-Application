/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.asatyanarayan1.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Future;

/**
 *
 * @author amith
 */
@Entity
@NamedQuery(name="Appointment.findAll",query="select a from Appointment a")

public class Appointment extends AbstarctEntity {


    
    @Future
    private LocalDate appointDate;

    private LocalTime appointTime;

    //Anappointment is made by an patient with a particular doctor
    @ManyToOne
    private Doctor doctor;
    @ManyToOne
    private Patient patient;

    /**
     * Default constructor
     */
    public Appointment() {
    }

    /**
     * Parameterized constructor
     * @param date is of type localDate
     * @param time is of type localtime
     */
    public Appointment(LocalDate date, LocalTime time) {
        this.appointDate = date;
        this.appointTime = time;
    }
    
    /**
     * This is the helper method to create an appointment using patient and doctor parameters
     * @param p is the object of patient
     * @param d is the object of doctor
     */
    public void addAppt(Patient p,Doctor d){
        
        this.doctor=d;
        this.patient=p;
        
        if(!p.getAppointments().contains(this)){
            p.getAppointments().add(this);
        }
        if(!d.getAppointments().contains(this)){
            d.getAppointments().add(this);
        }
        
    }

    /**
     * This is the helper method to delete the appointment
     */
    public void delAppt(){
        
        if(this.patient.getAppointments().contains(this)){
            this.patient.getAppointments().remove(this);
        }
        if(this.doctor.getAppointments().contains(this)){
            this.doctor.getAppointments().remove(this);
        }
        this.doctor=null;
        this.patient=null;
        
    }

    /**
     * Getter method for appointment date
     * @return date
     */
    public LocalDate getAppointDate() {
        return appointDate;
    }

    /**
     * Setter method for appointment date
     * @param appointDate is of type localDate
     */
    public void setAppointDate(LocalDate appointDate) {
        this.appointDate = appointDate;
    }

    /**
     * Getter method for appointment time
     * @return localTime
     */
    public LocalTime getAppointTime() {
        return appointTime;
    }

    /**
     * Setter method for appointment time
     * @param appointTime is of type Localtime 
     */
    public void setAppointTime(LocalTime appointTime) {
        this.appointTime = appointTime;
    }

    /**
     * To string method to convert the object to string type
     * @return String
     */
    @Override
    public String toString() {
        return "Appoinment{" + "id=" + id + ", date=" + appointDate + ", time=" + appointTime + '}';
    }

    /**
     *
     * @return ....
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
        return hash;
    }

    /**
     *
     * @param obj is the object
     * @return ...
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Appointment other = (Appointment) obj;
        if ((this.id == null) || (other.id == null)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    /**
     * Getter method to fetch the doctor object associated with the appointment
     * @return doctor object
     */
    public Doctor getDoctor() {
        return doctor;
    }

    /**
     * Setter method to set the doctor object to associate with the appointment
     * @param doctor is set
     */
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    /**
     * Getter method to fetch the patient object associated with the appointment
     * @return patient object
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * Setter method to set the patient object to associate with the appointment
     * @param patient is set
     */
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

}
