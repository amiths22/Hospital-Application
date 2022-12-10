/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.asatyanarayan1.service;

import edu.iit.sat.itmd4515.asatyanarayan1.domain.Appointment;
import edu.iit.sat.itmd4515.asatyanarayan1.domain.Doctor;
import edu.iit.sat.itmd4515.asatyanarayan1.domain.Patient;
import edu.iit.sat.itmd4515.asatyanarayan1.domain.PatientGender;
import edu.iit.sat.itmd4515.asatyanarayan1.domain.Staff;
import edu.iit.sat.itmd4515.asatyanarayan1.security.Group;
import edu.iit.sat.itmd4515.asatyanarayan1.security.GroupService;
import edu.iit.sat.itmd4515.asatyanarayan1.security.User;
import edu.iit.sat.itmd4515.asatyanarayan1.security.UserService;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;


/**
 *
 * @author amith
 */
@Startup
@Singleton
public class StartupSampleDataService {

    private static final Logger LOG = Logger.getLogger(StartupSampleDataService.class.getName());
    //@PersistenceContext(name = "itmd4515PU")
    //private EntityManager em;

    @EJB
    private DoctorService docSvc;
    @EJB
    private PatientService patSvc;
    @EJB
    private StaffService stSvc;
    @EJB
    private AppointmentService apptSvc;
    @EJB
    private UserService userSvc;
    @EJB
    private GroupService grpSvc;

    /**
     * Default Constructor
     */
    public StartupSampleDataService() {
    }

    @PostConstruct
    private void postConstruct() {

        Group patientGroup = new Group("PATIENT_GROUP", "This group represent the patients");
        Group doctorGroup = new Group("DOCTOR_GROUP", "This group represent the doctors");
        Group adminGroup = new Group("ADMIN_GROUP", "This group represent the admins");
        Group staffGroup = new Group("STAFF_GROUP", "This group represent the staffs");
        grpSvc.create(adminGroup);
        grpSvc.create(patientGroup);
        grpSvc.create(doctorGroup);
        grpSvc.create(staffGroup);

        User admin = new User("admin", "admin", true);
        admin.addGroup(adminGroup);
        userSvc.create(admin);
        User doctor1 = new User("doctor1", "doctor1", true);
        User doctor2 = new User("doctor2", "doctor2", true);
        doctor1.addGroup(doctorGroup);
        doctor1.addGroup(adminGroup);
        doctor2.addGroup(doctorGroup);
        userSvc.create(doctor1);
        userSvc.create(doctor2);

        User patient1 = new User("patient1", "patient1", true);
        patient1.addGroup(patientGroup);
        userSvc.create(patient1);
        User patient2 = new User("patient2", "patient2", true);
        patient2.addGroup(patientGroup);
        userSvc.create(patient2);

        User staff1 = new User("staff1", "staff1", true);
        staff1.addGroup(staffGroup);
        staff1.addGroup(adminGroup);
        userSvc.create(staff1);
        User staff2 = new User("staff2", "staff2", true);
        staff2.addGroup(staffGroup);
        userSvc.create(staff2);

        // 
        LOG.info("Inside StartupSampleDataService.postConstruct method");

        // First step to create data for entities that dont own relationship
        Staff s1 = new Staff("bharath", "receptionist", 1234567);
        Staff s2 = new Staff("ABK", "nurse", 1234567);
        Staff s3 = new Staff("zwefv", "Nurse", 12345);
        Staff s4 = new Staff("BWK", "Receptionist", 12345);
        Staff s5 = new Staff("AWK", "Nurse", 12345);
        stSvc.create(s1);
        s1.setUser(staff1);
        stSvc.create(s2);
        stSvc.create(s3);
        stSvc.create(s4);
        stSvc.create(s5);

        //Doctor d1 = new Doctor("Amith", "Heart", 1234567, "chicago");
        //Doctor d2 = new Doctor("Alk", "surgery", 12345, "abcd");
        //em.persist(d1);
        //em.persist(d2);
        // docSvc.create(d1);
        // docSvc.create(d2);
        Patient p1 = new Patient("Aakash", PatientGender.Male, LocalDate.of(1998, 03, 22), "Hassan");
        Patient p2 = new Patient("Ankitha", PatientGender.Female, LocalDate.of(1996, 05, 23), "Banglore");
        Patient p3 = new Patient("Karthik", PatientGender.Male, LocalDate.of(1997, 01, 21), "Hassan");
        patSvc.create(p1);
        p1.setUser(patient1);
        patSvc.create(p2);
        p2.setUser(patient2);
        patSvc.create(p3);

        //second step is to create data for entities that own relationship
        Doctor d1 = new Doctor("Amith", "Heart", 1234567, "chicago");
        Doctor d2 = new Doctor("Alk", "surgery", 12345, "abcd");
        d1.addStaff(s1);
        d1.addStaff(s2);
        d1.addStaff(s3);
        d2.addStaff(s5);
        d2.addStaff(s4);

        docSvc.create(d1);
        d1.setUser(doctor1);
        docSvc.create(d2);
        d2.setUser(doctor2);

        Appointment a1 = new Appointment(LocalDate.of(2023, Month.MARCH, 1), LocalTime.of(9, 0));
        a1.addAppt(p1, d1);
        Appointment a2 = new Appointment(LocalDate.of(2023, Month.APRIL, 1), LocalTime.of(10, 00));
        a2.addAppt(p3, d1);
        Appointment a3 = new Appointment(LocalDate.of(2023, Month.JUNE, 1), LocalTime.of(10, 00));
        a3.addAppt(p2, d2);

        apptSvc.create(a1);
        apptSvc.create(a2);
        apptSvc.create(a3);

        for (Patient p : patSvc.findAll()) {
            LOG.info("Patient---------------->" + p.toString());
        }

        for (Doctor d : docSvc.findAll()) {
            LOG.info("Doctor------------>" + d.toString());

            for (Staff s : d.getStaffs()) {
                LOG.info("\t\t-------------->" + s.toString());
            }
            for (Appointment a : d.getAppointments()) {
                LOG.info("\t\t-------------->" + a.toString());
                LOG.info("\t\t\t-------------->" + a.getPatient().toString());
                LOG.info("\t\t\t-------------->" + a.getDoctor().toString());

            }
        }
    }
}
