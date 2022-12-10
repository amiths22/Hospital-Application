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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author amith
 */
@Entity
@NamedQuery(name = "Staff.findAll", query = "select s from Staff s")
public class Staff extends AbstractNamedEntity {

    @NotBlank
    private String department;

    private Integer phone;

    @ManyToMany(mappedBy = "staffs")
    private List<Doctor> doctors = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "USERNAME")
    private User user;

    /**
     * Default constructor 
     */
    public Staff() {
    }

    /**
     * Parameterized  Constructor
     * @param name
     * @param department
     * @param phone
     */
    public Staff(String name, String department, Integer phone) {
        this.name = name;
        this.department = department;
        this.phone = phone;
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
     * Get the value of department
     *
     * @return the value of department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Set the value of department
     *
     * @param department new value of department
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * Helper method to convert the object to string type
     * @return
     */
    @Override
    public String toString() {
        return "Staff{" + "id=" + id + ", name=" + name + ", department=" + department + ", phone=" + phone + '}';
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
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
        final Staff other = (Staff) obj;
        if ((this.id == null) || (other.id == null)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    /**
     * Getter method to get the set of doctors for which the staff is working
     * @return
     */
    public List<Doctor> getDoctors() {
        return doctors;
    }

    /**
     * Setter method to assign the set of doctors to the staff.
     * @param doctors
     */
    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
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
