/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.asatyanarayan1.web;

import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author amith
 */
@Named
@RequestScoped
public class PatientWelcomeController {

    private static final Logger LOG = Logger.getLogger(PatientWelcomeController.class.getName());

    public PatientWelcomeController() {
    }
    @PostConstruct
    public void postConstruct(){
        LOG.info("Inside PatientWelcomeController.postConstruct");
    }
}
