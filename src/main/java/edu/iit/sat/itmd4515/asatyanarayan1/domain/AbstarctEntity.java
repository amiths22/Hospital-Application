/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.asatyanarayan1.domain;

import java.time.LocalDateTime;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;

/**
 *
 * @author amith
 */
@MappedSuperclass
public class AbstarctEntity {

    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    /**
     *
     */
    @Version
    protected Long version;

    private LocalDateTime createdTimestamp;

    private LocalDateTime updatedTimestamp;

    /**
     *
     */
    @PrePersist
    public void createdTimestamp() {
        createdTimestamp = LocalDateTime.now();
    }

    /**
     *
     */
    @PreUpdate
    public void updatedTimestamp() {
        createdTimestamp = LocalDateTime.now();
    }

    /**
     *
     */
    public AbstarctEntity() {
    }

    /**
     * Get the value of Id
     *
     * @return the value of Id
     */
    public Long getId() {
        return id;
    }

    /**
     * Set the value of Id
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public Long getVersion() {
        return version;
    }

    /**
     *
     * @param version
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    /**
     *
     * @return
     */
    public LocalDateTime getCreatedTimestamp() {
        return createdTimestamp;
    }

    /**
     *
     * @param createdTimestamp
     */
    public void setCreatedTimestamp(LocalDateTime createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    /**
     *
     * @return
     */
    public LocalDateTime getUpdatedTimestamp() {
        return updatedTimestamp;
    }

    /**
     *
     * @param updatedTimestamp
     */
    public void setUpdatedTimestamp(LocalDateTime updatedTimestamp) {
        this.updatedTimestamp = updatedTimestamp;
    }

}
