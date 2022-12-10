/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.asatyanarayan1.domain;

import edu.iit.sat.itmd4515.asatyanarayan1.security.User;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

/**
 *
 * @author amith
 */
@Entity
@NamedQuery(name = "Patient.findByName", query = "select p from Patient p WHERE p.name=:NAME")
@NamedQuery(name = "Patient.findAll", query = "select p from Patient p")
@NamedQuery(name = "Patient.findByPUsername", query = "select p from Patient p where p.user.userName=:username")
public class Patient extends AbstarctEntity {

    @NotBlank
    @Size(min = 4, max = 40)
    @Column(name = "patient_name", nullable = false, unique = true)
    private String name;
    @Enumerated(EnumType.STRING)
    private PatientGender gender;

    
    @PastOrPresent
    private LocalDate dob;
 
    private String address;

    @OneToMany(mappedBy = "patient")
    //private List<Appointment> appointments = new ArrayList<>();
    private List<Appointment> appointments = new ArrayList<>();
    @OneToOne
    @JoinColumn(name="USERNAME")    
    private User user;
    
    /**
     * Parameterised default constructor
     * @param name
     * @param gender
     * @param dob
     * @param address
     */
    public Patient(String name, PatientGender gender, LocalDate dob, String address) {
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
    }

    /**
     * Default constructor
     */
    public Patient() {
    }

    /**
     * Get the value of gender
     *
     * @return the value of gender
     */
    public PatientGender getGender() {
        return gender;
    }

    /**
     * Set the value of gender
     *
     * @param gender new value of gender
     */
    public void setGender(PatientGender gender) {
        this.gender = gender;
    }

    /**
     * Get the value of address
     *
     * @return the value of address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set the value of address
     *
     * @param address new value of address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Get the value of dob
     *
     * @return the value of dob
     */
    public LocalDate getDob() {
        return dob;
    }

    /**
     * Set the value of dob
     *
     * @param dob new value of dob
     */
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }

    /*@Override
    public String toString() {
        return "Patient{" + "id=" + id + ", name=" + name + ", dob=" + dob + ", address=" + address + '}';
    }*/

    /**
     *
     * @return
     */


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
        return hash;
    }

    /**
     *
     * @param that
     * @return
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        final Patient other = (Patient) that;
        if ((this.id == null) || (other.id == null)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    /**
     * Getter method to fetch all the appointments associated with the patient
     * @return
     */
    public List<Appointment> getAppointments() {
        return appointments;
    }

    /**
     * Setter method to assign the appointments associated to the patient
     * @param appointments
     */
    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    /**
     * Getter method to fetch the user in security domain
     * @return
     */
    public User getUser() {
        return user;
    }

    /**
     * Setter method to set the user in security domain
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Helper method to convert the object to string type
     * @return
     */
    @Override
    public String toString() {
        return "Patient{" + "name=" + name + ", gender=" + gender + ", dob=" + dob + ", address=" + address + ", user=" + user + '}';
    }

}
