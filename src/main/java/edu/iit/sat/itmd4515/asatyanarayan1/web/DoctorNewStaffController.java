/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.asatyanarayan1.web;

import edu.iit.sat.itmd4515.asatyanarayan1.domain.Staff;
import edu.iit.sat.itmd4515.asatyanarayan1.service.DoctorService;
import edu.iit.sat.itmd4515.asatyanarayan1.service.StaffService;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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

    @EJB
    private DoctorService doctorSvc;
    @Inject
    DoctorWelcomeController doc;

    @Inject
    FacesContext facesContext;

    private Staff staff;

    private boolean showFacesMessage = false;

    public DoctorNewStaffController() {
    }

    @PostConstruct
    private void postConstruct() {
        LOG.info("StaffsController.postconstruct");
        staff = new Staff();
    }

    //axtion methods
    //these display methods are step 1 in the "MVC" style JSF
    public String displayReadStaffPage(Staff s) {

        LOG.info("Inside displayReadStaffPage with" + this.staff.toString());
 
        this.staff = s;
        return "/doctor/readStaff.xhtml";

    }

    public String displayUpdateStaffPage(Staff s) {

        LOG.info("Inside displayUpdateStaffPage with" + this.staff.toString());

        this.staff = s;
        return "/doctor/updateStaff.xhtml";

    }

    public String displayDeleteStaffPage(Staff s) {

        LOG.info("Inside displayDeleteStaffPage with" + this.staff.toString());

        this.staff = s;
        return "/doctor/deleteStaff.xhtml";

    }

    public String executeCreateButton() {
        LOG.info("Inside executeCreate Button " + this.staff.toString());

        //staffSvc.create(staff);
        //option 1
        //doc.getDoctor().addStaff(staff);
        doctorSvc.createStaffForDoctor(staff, doc.getDoctor());
        
        //option2 refresh the doctor
        doc.refreshDoctor();
        

        facesContext.addMessage(null, new FacesMessage(
                FacesMessage.SEVERITY_INFO,
                "Success!",
                "New Staff " + this.staff.getName() + " was created."));

        this.showFacesMessage = true;
        //return "/doctor/welcome.xhtml?faces-redirect=true";
        return "/doctor/welcome.xhtml";

    }

    public String executeUpdateButton() {
        LOG.info("Inside executeUpdateButton " + this.staff.toString());
        
        doctorSvc.updateStaffForDoctor(staff);

        //staffSvc.create(staff);
        //calling a service here
        return "/doctor/welcome.xhtml?faces-redirect=true";

    }

    public String executeDeleteButton() {
        LOG.info("Inside executeDeleteButton     " + this.staff.toString());
        
        doctorSvc.deleteStaffForDoctor(staff);

        //staffSvc.create(staff);
        // calling a service here
        return "/doctor/welcome.xhtml?faces-redirect=true";

    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public boolean isShowFacesMessage() {
        return showFacesMessage;
    }

    public void setShowFacesMessage(boolean showFacesMessage) {
        this.showFacesMessage = showFacesMessage;
    }

}
