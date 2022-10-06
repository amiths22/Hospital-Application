/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.asatyanarayan1.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author amith
 */
public class PatientValdationTest {
      private static Validator validator;
    
    @BeforeAll
    public static void BeforeAll(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    
    @BeforeEach
    public void beforeEach(){}
    
    @Test
    public void patientIsValid(){
        Patient p= new Patient("Satya",PatientGender.Male,LocalDate.of(1980, Month.MARCH, 15),"Hassan");
        Set<ConstraintViolation<Patient>> violations = validator.validate(p);
        assertEquals(0,violations.size());
                }
    
    @Test
    public void patientIsInValid_malformedname() {
        Patient p= new Patient("",PatientGender.Male,LocalDate.of(1980, Month.MARCH, 15),"Hassan");
        Set<ConstraintViolation<Patient>> violations = validator.validate(p);
        
       for(ConstraintViolation<Patient> violation : violations){
           System.out.println(violation.toString());
       }
        
        assertEquals( 2, violations.size() );
    }
    
    @Test
     public void patientIsInValid_correctdate() {
        Patient p= new Patient("Anu",PatientGender.Male,LocalDate.of(2022, Month.MARCH, 15),"Hassan");
        Set<ConstraintViolation<Patient>> violations = validator.validate(p);
       for(ConstraintViolation<Patient> violation : violations){
           System.out.println(violation.toString());
       }
        
        assertEquals( 1, violations.size() );
    }
    @Test
     public void patientIsInValid_malformeddate() {
        Patient p= new Patient("Anu",PatientGender.Male,LocalDate.of(2023, Month.MARCH, 15),"Hassan");
        Set<ConstraintViolation<Patient>> violations = validator.validate(p);
        
       for(ConstraintViolation<Patient> violation : violations){
           System.out.println(violation.toString());
       }
        
        assertEquals( 2, violations.size() );
    }
     
    @Test
     public void AppointmentIsValid_apptdate() {
        Appointment a = new Appointment(LocalDate.of(2023, Month.MARCH, 1),LocalTime.of(4, 0));
        Set<ConstraintViolation<Appointment>> violations = validator.validate(a);
       for(ConstraintViolation<Appointment> violation : violations){
           System.out.println(violation.toString());
       }
        
        assertEquals( 0, violations.size() );
    }
     
     @Test
     public void AppointmentIsInValid_apptdate() {
        Appointment a = new Appointment(LocalDate.of(2020, Month.MARCH, 1),LocalTime.of(4, 0));
        Set<ConstraintViolation<Appointment>> violations = validator.validate(a);
       for(ConstraintViolation<Appointment> violation : violations){
           System.out.println(violation.toString());
       }
        
        assertEquals( 1, violations.size() );
    }
     
     
    @Test
    public void DoctorIsValidName(){
        Doctor d = new Doctor("Amith", "Surgery", 12345, "hassan");
        Set<ConstraintViolation<Doctor>> violations = validator.validate(d);
        assertEquals(0,violations.size());
                }
    
    @Test
    public void DoctorIsInValidName() {
        Doctor d = new Doctor("", "Surgery", 12345, "hassan");
        Set<ConstraintViolation<Doctor>> violations = validator.validate(d);
        
       for(ConstraintViolation<Doctor> violation : violations){
           System.out.println(violation.toString());
       }
        
        assertEquals( 2, violations.size() );
    }
    
    @Test
    public void DoctorIsValidSpecialization(){
        Doctor d = new Doctor("Amith", "Surgery", 12345, "hassan");
        Set<ConstraintViolation<Doctor>> violations = validator.validate(d);
        assertEquals(0,violations.size());
                }
    
    @Test
    public void DoctorIsInValidSpecialization() {
        Doctor d = new Doctor("Amith", "", 12345, "hassan");
        Set<ConstraintViolation<Doctor>> violations = validator.validate(d);
        
       for(ConstraintViolation<Doctor> violation : violations){
           System.out.println(violation.toString());
       }
        
        assertEquals( 1, violations.size() );
    }
    
    @Test
    public void DoctorIsValidAddress(){
        Doctor d = new Doctor("Amith", "Surgery", 12345, "hassan");
        Set<ConstraintViolation<Doctor>> violations = validator.validate(d);
        assertEquals(0,violations.size());
                }
    
    @Test
    public void DoctorIsInValidAddress() {
        Doctor d = new Doctor("Amith", "Surgery", 12345, "");
        Set<ConstraintViolation<Doctor>> violations = validator.validate(d);
        
       for(ConstraintViolation<Doctor> violation : violations){
           System.out.println(violation.toString());
       }
        
        assertEquals( 1, violations.size() );
    }
    
    @Test
    public void StaffIsValidName(){
        Staff s = new Staff("test", "HR", 12222);
        Set<ConstraintViolation<Staff>> violations = validator.validate(s);
        assertEquals(0,violations.size());
                }
    
    @Test
    public void StaffIsInValidName() {
        Staff s = new Staff("", "HR", 12222);
        Set<ConstraintViolation<Staff>> violations = validator.validate(s);
        
       for(ConstraintViolation<Staff> violation : violations){
           System.out.println(violation.toString());
       }
        
        assertEquals( 2, violations.size() );
    }
    
    @Test
    public void StaffIsValidDepartment(){
        Staff s = new Staff("test", "HR", 12222);
        Set<ConstraintViolation<Staff>> violations = validator.validate(s);
        assertEquals(0,violations.size());
                }
    
    @Test
    public void StaffIsInValidDepartment() {
        Staff s = new Staff("test", "", 12222);
        Set<ConstraintViolation<Staff>> violations = validator.validate(s);
        
       for(ConstraintViolation<Staff> violation : violations){
           System.out.println(violation.toString());
       }
        
        assertEquals( 1, violations.size() );
    }
    
    @AfterEach
    public void afterEach(){}
    
    @AfterAll
    public static void AfterAll(){}

}
