/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.asatyanarayan1.web;

import edu.iit.sat.itmd4515.asatyanarayan1.security.User;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.SecurityContext;
import javax.security.enterprise.authentication.mechanism.http.AuthenticationParameters;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.Password;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author amith
 */
@Named
@RequestScoped
public class LoginController {

    private static final Logger LOG = Logger.getLogger(LoginController.class.getName());

    private User user;

    @Inject
    SecurityContext securityContext;
    @Inject
    FacesContext facesContext;

    /**
     * Default constructor
     */
    public LoginController() {
    }

    @PostConstruct
    private void postConstruct() {

        user = new User();
        LOG.info("Inside login controller.postconstruct with");

    }
  

    /**
     * Helper method to get the current authenticated user
     * @return
     */
    public String getAuthenticatedUser(){
        //return securityContext.getCallerPrincipal().getName();
        return facesContext.getExternalContext().getRemoteUser();
    }

    /**
     * Helper method to check if the logged in user is a admin
     * @return
     */
    public boolean isAdmin(){
        return securityContext.isCallerInRole("ADMIN_ROLE"); 
    }

    /**
     * Helper method to check if the logged in user is a doctor
     * @return
     */
    public boolean isDoctor(){
        return securityContext.isCallerInRole("DOCTOR_ROLE"); 
    }

    /**
     *  Helper method to check if the logged in user is a patient
     * @return
     */
    public boolean isPatient(){
        return securityContext.isCallerInRole("PATIENT_ROLE"); 
    }

    /**
     * Helper method to check if the logged in user is a staff
     * @return
     */
    public boolean isStaff(){
        return securityContext.isCallerInRole("STAFF_ROLE"); 
    }
    
    /**
     * This function helps to perform the login operation by
     * Checking the username and password and authenticating it with the DB
     * @return
     */
    public String doLogin() {
        LOG.info("Inside dologin " + this.user.getUserName());

        //do the JSR-375 authN
        Credential cred = new UsernamePasswordCredential(
                this.user.getUserName(),
                new Password(this.user.getPassword()));

        AuthenticationStatus status = securityContext.authenticate(
                (HttpServletRequest) facesContext.getExternalContext().getRequest(),
                (HttpServletResponse) facesContext.getExternalContext().getResponse(),
                AuthenticationParameters.withParams().credential(cred));

        switch (status) {
            case SUCCESS:
                LOG.info(status.toString());
                break;
            case SEND_FAILURE:
                LOG.info(status.toString());
                return "/error.xhtml";
            case NOT_DONE:
                LOG.info(status.toString());
                return "/error.xhtml";
            case SEND_CONTINUE:
                LOG.info(status.toString());
                break;
        }

        return "/welcome.xhtml?faces-redirect=true";
    }
    
    /**
     * This function helps to log out the user from the application
     * @return
     */
    public String doLogout(){
        
        HttpServletRequest req=(HttpServletRequest) facesContext.getExternalContext().getRequest();
        
        try {
            req.logout();
        } catch (ServletException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
        return "/login.xhtml?faces-redirect=true";
    }

    /**
     * Get the value of User
     * @return
     */
    public User getUser() {
        return user;
    }

    /**
     * Set the value of the user
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
    }
}
