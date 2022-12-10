/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.asatyanarayan1.domain;

import edu.iit.sat.itmd4515.asatyanarayan1.security.User;
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
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 *
 * @author amith
 */
@Entity
@NamedQuery(name = "Doctor.findAll", query = "select d from Doctor d")
@NamedQuery(name = "Doctor.findByUsername", query = "select d from Doctor d where d.user.userName=:username")
public class Doctor extends AbstractNamedEntity {

    @NotBlank
    private String specialization;

    private Integer phone;

    @NotBlank
    private String address;

    //A doctor can have many patients,
    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointments = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "DOCTOR_STAFF",
            joinColumns = @JoinColumn(name = "DOCTOR_ID"),
            inverseJoinColumns = @JoinColumn(name = "STAFF_ID"))
    private List<Staff> staffs = new ArrayList<>();
    @OneToOne
    @JoinColumn(name = "USERNAME")
    private User user;

    /**
     * Default constructor
     */
    public Doctor() {
    }

    /**
     * Parameterised constructor
     * @param name
     * @param stream
     * @param phone
     * @param address
     */
    public Doctor(String name, String stream, Integer phone, String address) {
        this.name = name;
        this.specialization = stream;
        this.phone = phone;
        this.address = address;
    }

    /**
     * Helper method to add the staff
     * @param s
     */
    public void addStaff(Staff s) {
        if (!this.staffs.contains(s)) {
            this.staffs.add(s);
        }
        if (!s.getDoctors().contains(this)) {
            s.getDoctors().add(this);
        }
    }

    /**
     * Helper method to delete the staff
     * @param s
     */
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
     * Helper method to convert the object to string type
     * @return
     */
    @Override
    public String toString() {
        return "Doctor{" + "id=" + id + ", name=" + name + ", stream=" + specialization + ", phone=" + phone + ", address=" + address + '}';
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
        return hash;
    }

    /**
     *
     * @param obj
     * @return
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
        final Doctor other = (Doctor) obj;
        if ((this.id == null) || (other.id == null)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    /**
     * Getter method to fetch all the appointments associated with the doctor
     * @return
     */
    public List<Appointment> getAppointments() {
        return appointments;
    }

    /**
     * Setter method to set the appointments to associate with the doctor
     * @param appointments
     */
    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    /**
     * Getter method to fetch all the staffs working for the doctor
     * @return
     */
    public List<Staff> getStaffs() {
        return staffs;
    }

    /**
     * Setter method to set the staffs to work for the doctor
     * @param staffs
     */
    public void setStaffs(List<Staff> staffs) {
        this.staffs = staffs;
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

}
