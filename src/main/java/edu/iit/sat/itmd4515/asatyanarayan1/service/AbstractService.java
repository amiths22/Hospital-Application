/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.asatyanarayan1.service;

import edu.iit.sat.itmd4515.asatyanarayan1.domain.Doctor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author amith
 * @param <T> It can be any entity
 */
public abstract class AbstractService<T> {
    
    /**
     *
     */
    @PersistenceContext(name = "itmd4515PU")
    protected EntityManager em;
    
    /**
     *
     */
    protected final Class<T> entityclass;

    /**
     *
     * @param entityclass
     */
    public AbstractService(Class<T> entityclass) {
        this.entityclass=entityclass;
    }

    /**
     *
     * @param entity
     */
    public void create(T entity) {
        em.persist(entity);
    }

    /**
     *
     * @param id
     * @return
     */
    public T read(Long id) {
        return em.find(entityclass, id);
    }

    /**
     *
     * @param entity
     */
    public void update(T entity) {
        em.merge(entity);
    }

    /**
     *
     * @param entity
     */
    public void delete(T entity) {
        em.remove(em.merge(entity));
    }
    
    /**
     *
     * @return
     */
    abstract public List<T> findAll();
}
