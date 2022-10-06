/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.asatyanarayan1.lab3;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;


/**
 *
 * @author amith
 */
@Entity
public class City {
    
    public City(){
        
    }
    @Id
    @NotNull (message="City ID is required & should be less than 999")
    @Positive
    private Integer cityId;
    @NotBlank (message="City name is required")
    private String city;
    @NotNull (message="Country ID is required & should be less than 109")
    private Integer countryId;

    public City(Integer cityId,String city, Integer countryId) {
        this.cityId = cityId;
        this.city = city;
        this.countryId = countryId;
    } 

    /**
     * Get the value of countryId
     *
     * @return the value of countryId
     */
    public Integer getCountryId() {
        return countryId;
    }

    /**
     * Set the value of countryId
     *
     * @param countryId new value of countryId
     */
    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }


    /**
     * Get the value of city
     *
     * @return the value of city
     */
    public String getCity() {
        return city;
    }

    /**
     * Set the value of city
     *
     * @param city new value of city
     */
    public void setCity(String city) {
        this.city = city;
    }


    /**
     * Get the value of cityId
     *
     * @return the value of cityId
     */
    public Integer getCityId() {
        return cityId;
    }

    /**
     * Set the value of cityId
     *
     * @param cityId new value of cityId
     */
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    @Override
    public String toString() {
        return "City{" + "cityId=" + cityId + ", city=" + city + ", countryId=" + countryId + '}';
    }
    
    

}
