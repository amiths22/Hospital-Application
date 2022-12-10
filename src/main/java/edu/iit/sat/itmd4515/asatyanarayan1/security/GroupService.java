/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.asatyanarayan1.security;

import edu.iit.sat.itmd4515.asatyanarayan1.service.AbstractService;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author amith
 */
@Stateless
public class GroupService extends AbstractService<Group> {

    /**
     * Default constructor
     */
    public GroupService() {
        super(Group.class);
    }

    /**
     * Find all method is to find all the groups in the system
     * @return
     */
    @Override
    public List<Group> findAll() {
        return em.createNamedQuery("Group.findAll", Group.class).getResultList();
    }

}
