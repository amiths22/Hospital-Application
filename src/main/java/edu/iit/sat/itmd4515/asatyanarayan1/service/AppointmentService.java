/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.asatyanarayan1.service;

import edu.iit.sat.itmd4515.asatyanarayan1.domain.Appointment;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author amith
 */
@Stateless
public class AppointmentService extends AbstractService<Appointment> {

    public AppointmentService() {
        super(Appointment.class);
    }

    
    @Override
    public List<Appointment> findAll() {
        return em.createNamedQuery("Appointment.findAll", Appointment.class).getResultList();
    }
    
    
    
}
