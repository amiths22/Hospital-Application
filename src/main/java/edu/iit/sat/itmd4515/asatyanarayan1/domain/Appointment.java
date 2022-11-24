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

    public Appointment() {
    }

    public Appointment(LocalDate date, LocalTime time) {
        this.appointDate = date;
        this.appointTime = time;
    }
    
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
    public LocalDate getAppointDate() {
        return appointDate;
    }

    public void setAppointDate(LocalDate appointDate) {
        this.appointDate = appointDate;
    }

    public LocalTime getAppointTime() {
        return appointTime;
    }

    public void setAppointTime(LocalTime appointTime) {
        this.appointTime = appointTime;
    }


    @Override
    public String toString() {
        return "Appoinment{" + "id=" + id + ", date=" + appointDate + ", time=" + appointTime + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
        return hash;
    }

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

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

}
