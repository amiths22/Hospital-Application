/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.asatyanarayan1.service;

import edu.iit.sat.itmd4515.asatyanarayan1.domain.Staff;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author amith
 */

@Stateless
public class StaffService extends AbstractService<Staff> {

    public StaffService() {
        super(Staff.class);
    }

    @Override
    public List<Staff> findAll() {
        return em.createNamedQuery("Staff.findAll", Staff.class).getResultList();
    }

}
