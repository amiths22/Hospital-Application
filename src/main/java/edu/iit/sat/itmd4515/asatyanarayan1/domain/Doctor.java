/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.asatyanarayan1.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 *
 * @author amith
 */
@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank

    @Size(min = 4, max = 40)
    private String name;

    private String specialization;

    private Integer phone;

    private String address;

    //A doctor can have many patients,
    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointments = new ArrayList<>();

    
    @ManyToMany
    @JoinTable(name = "DOCTOR_STAFF",
        joinColumns = @JoinColumn(name = "DOCTOR_ID"),
        inverseJoinColumns = @JoinColumn(name = "STAFF_ID"))
    private List<Staff> staffs = new ArrayList<>();

    public Doctor() {
    }



    public Doctor(String name, String stream, Integer phone, String address) {
        this.name = name;
        this.specialization = stream;
        this.phone = phone;
        this.address = address;
    }
    
    public void addStaff(Staff s) {
        if (!this.staffs.contains(s)) {
            this.staffs.add(s);
        }
        if (!s.getDoctors().contains(this)) {
            s.getDoctors().add(this);
        }
    }
    
    public void removeStaff(Staff s) {
        if (this.staffs.contains(s)) {
            this.staffs.remove(s);
        }
        if (s.getDoctors().contains(this)) {
            s.getDoctors().remove(this);
        }
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
     * Get the value of phone
     *
     * @return the value of phone
     */
    public Integer getPhone() {
        return phone;
    }

    /**
     * Set the value of phone
     *
     * @param phone new value of phone
     */
    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    /**
     * Get the value of stream
     *
     * @return the value of stream
     */
    public String getSpecialization() {
        return specialization;
    }

    /**
     * Set the value of stream
     *
     * @param stream new value of stream
     */
    public void setSpecialization(String stream) {
        this.specialization = stream;
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

    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public Long getId() {
        return id;
    }

    /**
     * Set the value of id
     *
     * @param id new value of id
     */
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Doctor{" + "id=" + id + ", name=" + name + ", stream=" + specialization + ", phone=" + phone + ", address=" + address + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final Doctor other = (Doctor) obj;
        if ((this.id == null) || (other.id == null)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
    public List<Staff> getStaffs() {
        return staffs;
    }
    public void setStaffs(List<Staff> staffs) {
        this.staffs = staffs;
    }


}
