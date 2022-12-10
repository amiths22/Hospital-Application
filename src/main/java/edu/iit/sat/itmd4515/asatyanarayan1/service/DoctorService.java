/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.asatyanarayan1.service;

import edu.iit.sat.itmd4515.asatyanarayan1.domain.Doctor;
import edu.iit.sat.itmd4515.asatyanarayan1.domain.Staff;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author amith
 */
@Named
@Stateless
public class DoctorService {

    @PersistenceContext(name = "itmd4515PU")
    private EntityManager em;

    /**
     *
     */
    public DoctorService() {
    }

    /**
     *
     * @param d
     */
    public void create(Doctor d) {
        em.persist(d);
    }

    /**
     *
     * @param id
     * @return
     */
    public Doctor read(Long id) {
        return em.find(Doctor.class, id);
    }

    /**
     *
     * @param d
     */
    public void update(Doctor d) {
        em.merge(d);
    }

    /**
     *
     * @param d
     */
    public void delete(Doctor d) {
        em.remove(em.merge(d));
    }

    /**
     *
     * @return
     */
    public List<Doctor> findAll() {
        return em.createNamedQuery("Doctor.findAll", Doctor.class).getResultList();
    }

    /**
     *
     * @param username
     * @return
     */
    public Doctor findByUsername(String username) {
        return em
                .createNamedQuery("Doctor.findByUsername", Doctor.class)
                .setParameter("username", username)
                .getSingleResult();
    }

    /**
     *
     * @param s
     * @param d
     */
    public void createStaffForDoctor(Staff s, Doctor d) {
        //We know s is new entity
        em.persist(s);

        //Doctor already exists so no need to persist
        Doctor managedDoctorReference = em.getReference(Doctor.class, d.getId());
        managedDoctorReference.addStaff(s);
        em.merge(managedDoctorReference);
    }

    /**
     *
     * @param s
     */
    public void deleteStaffForDoctor(Staff s) {

        Staff managedStaffReference = em.getReference(Staff.class, s.getId());
        for(Doctor d:new ArrayList<Doctor>(managedStaffReference.getDoctors())){
            d.removeStaff(managedStaffReference);
            em.merge(d);
        }
        
        em.remove(managedStaffReference);
    }

    /**
     *
     * @param s
     */
    public void updateStaffForDoctor(Staff s) {
        //step1 get a managed ref
        Staff managedStaffReference = em.getReference(Staff.class, s.getId());

        //step 2 update field which we want to
        if (!managedStaffReference.getName().equals(s.getName())) {
            managedStaffReference.setName(s.getName());
        }
        if (s.getDepartment() != null) {
            managedStaffReference.setDepartment(s.getDepartment());
        }
        managedStaffReference.setPhone(s.getPhone());

        //step3 merge the updated ref
        em.merge(managedStaffReference);
    }
}
