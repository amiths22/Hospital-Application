/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.asatyanarayan1.security;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author amith
 */
@Entity
@Table(name = "sec_user")
@EntityListeners(UserListener.class)
@NamedQuery(name = "User.findAll", query = "select u from User u")
public class User {

    @Id
    @NotBlank(message="Username Required!")
    private String userName;
    @NotBlank(message="Password Required!")
    private String password;
    private Boolean enabled;

    @ManyToMany
    @JoinTable(name = "sec_user_groups",
            joinColumns = @JoinColumn(name = "USERNAME"),
            inverseJoinColumns = @JoinColumn(name = "GROUPNAME"))
    private List<Group> groups = new ArrayList<>();

    /**
     * Default Constructor
     */
    public User() {
    }

    /**
     * Parameterized Constructor
     * @param userName
     * @param password
     * @param enabled
     */
    public User(String userName, String password, Boolean enabled) {
        this.userName = userName;
        this.password = password;
        this.enabled = enabled;
    }

    /**
     * Helper method to add a group to the user
     * @param g
     */
    public void addGroup(Group g) {

        if (!this.groups.contains(g)) {
            this.groups.add(g);
        }
        if (!g.getUsers().contains(this)) {
            g.getUsers().add(this);
        }

    }

    /**
     * Helper method to delete a group from the user
     * @param g
     */
    public void removeGroup(Group g) {

        if (this.groups.contains(g)) {
            this.groups.remove(g);
        }
        if (g.getUsers().contains(this)) {
            g.getUsers().remove(this);
        }
    }

    /**
     * Get the value of userName
     *
     * @return the value of userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Set the value of userName
     *
     * @param userName new value of userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Get the value of password
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the value of password
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *  Get the value of enabled
     * @return
     */
    public Boolean isEnabled() {
        return enabled;
    }

    /**
     *  Set the value of enabled
     * @param enabled
     */
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * Getter method to get the list of groups for a particular user
     * @return
     */
    public List<Group> getGroups() {
        return groups;
    }

    /**
     * Setter method to set the list of groups to a particular user
     * @param groups
     */
    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    /**
     * Helper method to convert the object to string type
     * @return
     */
    @Override
    public String toString() {
        return "User{" + "userName=" + userName + ", enabled=" + enabled + ", groups=" + groups + '}';
    }

}
