/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.asatyanarayan1.service;

import edu.iit.sat.itmd4515.asatyanarayan1.domain.Doctor;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author amith
 */
@Stateless
public class DoctorService {

    @PersistenceContext(name = "itmd4515PU")
    private EntityManager em;

    public DoctorService() {
    }

    public void create(Doctor d) {
        em.persist(d);
    }

    public Doctor read(Long id) {
        return em.find(Doctor.class, id);
    }

    public void update(Doctor d) {
        em.merge(d);
    }

    public void delete(Doctor d) {
        em.remove(em.merge(d));
    }
    
    public List<Doctor> findAll(){
        return em.createNamedQuery("Doctor.findAll", Doctor.class).getResultList();
    }
    
    public Doctor findByUsername(String username){
        return em
                .createNamedQuery("Doctor.findByUsername",Doctor.class)
                .setParameter("username", username)
                .getSingleResult();
    }

}
