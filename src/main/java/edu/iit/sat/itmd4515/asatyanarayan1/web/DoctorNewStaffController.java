/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.asatyanarayan1.web;

import edu.iit.sat.itmd4515.asatyanarayan1.domain.Staff;
import edu.iit.sat.itmd4515.asatyanarayan1.service.StaffService;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author amith
 */
@Named
@RequestScoped
public class DoctorNewStaffController {

    private static final Logger LOG = Logger.getLogger(DoctorNewStaffController.class.getName());

    @EJB private StaffService staffSvc;
    @Inject DoctorWelcomeController doc;

    private Staff staff;
    public DoctorNewStaffController() {
    }


    @PostConstruct
    private void postConstruct() {
        LOG.info("StaffsController.postconstruct");
        staff=new Staff();
    }
 

    //axtion methods
    public String saveStaff() {
        LOG.info("Inside saveStaff "+ this.staff.toString());
        
        //staffSvc.create(staff);
        staffSvc.saveStaffForDoctor(staff,doc.getDoctor());
        
        return "/doctor/CreateStaffConfirmation.xhtml"; 

    }
    public Staff getStaff() {
        return staff;
    }
    public void setStaff(Staff staff) {
        this.staff = staff;
    }
}
