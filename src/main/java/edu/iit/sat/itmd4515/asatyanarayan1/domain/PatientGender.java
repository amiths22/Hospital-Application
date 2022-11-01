/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.asatyanarayan1.domain;

/**
 *
 * @author amith
 */
public enum PatientGender {
    Male("Male"),
    Female("Female");
   
    private String description;

    private PatientGender(String description) {
        this.description = description;
    }
    

    /**
     * Get the value of description
     *
     * @return the value of description
     */
    public String getDescription() {
        return description;
    }


}
