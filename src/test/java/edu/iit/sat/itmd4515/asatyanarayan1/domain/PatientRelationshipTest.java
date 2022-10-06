/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.asatyanarayan1.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
        //d.getStaffs().add(s);
        //s.getDoctors().add(d);

        d.addStaff(s);
        tx.begin();
        em.persist(d);
        em.persist(s);
        tx.commit();

        System.out.println("Navigating the relationship from the owning side" + d.getStaffs().toString());
        System.out.println("Navigating the relationship from the inverse side" + s.getDoctors().toString());

        assertTrue(d.getStaffs().size() == 1);
        assertTrue(s.getDoctors().size() == 1);

        tx.begin();
        d.removeStaff(s);
        em.remove(d);
        em.remove(s);
        tx.commit();

        System.out.println("Navigating the relationship from the owning side" + d.getStaffs().toString());
        System.out.println("Navigating the relationship from the inverse side" + s.getDoctors().toString());

    }
    
    @Test
    public void testManyToOneUniDirDoctorStaffRelationship() {
        
        Patient p=new Patient("amith",PatientGender.Male,LocalDate.of(1998, Month.MARCH, 22),"hassan");
        Appointment a = new Appointment(LocalDate.of(2023, Month.MARCH, 1),LocalTime.of(4, 0));
        
        p.getAppointments().add(a);
        
         tx.begin();
        em.persist(p);
        em.persist(a);
        tx.commit();
        
        System.out.println("Navigating the relationship from the owning side" + p.getAppointments().toString());
        
        assertTrue(p.getAppointments().size() == 1);
        
        tx.begin();
        p.getAppointments().remove(a);
        em.remove(p);
        em.remove(a);
        tx.commit();
    }
}
