/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.asatyanarayan1.service;

import edu.iit.sat.itmd4515.asatyanarayan1.domain.Doctor;
import edu.iit.sat.itmd4515.asatyanarayan1.domain.Staff;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;

/**
 *
 * @author amith
 */
@Named
@Stateless
public class StaffService extends AbstractService<Staff> {

    /**
     * Default Constructor
     */
    public StaffService() {
        super(Staff.class);
    }

    /**
     * Find all method is to find all the staffs in the system
     * @return
     */
    @Override
    public List<Staff> findAll() {
        return em.createNamedQuery("Staff.findAll", Staff.class).getResultList();
    }
    
    
}
