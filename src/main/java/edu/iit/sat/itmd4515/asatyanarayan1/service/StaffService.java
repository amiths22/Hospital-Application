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

    public StaffService() {
        super(Staff.class);
    }

    @Override
    public List<Staff> findAll() {
        return em.createNamedQuery("Staff.findAll", Staff.class).getResultList();
    }
    
    public void saveStaffForDoctor(Staff s, Doctor d){
        //We know s is new entity
        em.persist(s);
        
        //Doctor already exists so no need to persist
        Doctor managedDoctorReference=em.getReference(Doctor.class, d.getId());
        managedDoctorReference.addStaff(s);
        em.merge(managedDoctorReference);
    }

}
