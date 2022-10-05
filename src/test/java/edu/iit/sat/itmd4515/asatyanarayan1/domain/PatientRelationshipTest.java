/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.asatyanarayan1.domain;

import org.junit.jupiter.api.Test;

/**
 *
 * @author amith
 */
public class PatientRelationshipTest extends AbstractJPATest {

    @Test
    public void testManyToManyBiDirDoctorStaffRelationship() {
        Doctor d = new Doctor("Amith", "Surgery", 12345, "hassan");
        Staff s = new Staff("test", "HR", 12222);
        d.getStaffs().add(s);
        //s.getDoctors().add(d);
        tx.begin();
        em.persist(d);
        em.persist(s);
        tx.commit();

    }
}
