Amith Satyanarayan Lab4 Readme

Paragraph that describes the business domain you have chosen to work with, and why.

Business Domain Name - Heathcare
    Health domain is a very big and critical system that is built and managed. These days with everything 
being online,maintaining patient's past record is so important. It also helps other doctors to handle the case easily


There is only one entity required for Lab 4, but what other entities from your business domain can you think of? 
    I would think of 2 more entities
        1.Doctor - Healthcare is mainly dependent on doctors. This entity is as important as patient
        2. Staff - This is an entity which uses this system for announcements, billing and other stuff



**Test Cases:**
**Test Create**
#Create

  Patient createMe=new Patient("Almitha",PatientGender.Female,LocalDate.of(1995, Month.AUGUST, 20),"Hassan");
        tx.begin();
        em.persist(createMe);
        tx.commit();
        
        Patient compareMe=em.find(Patient.class,createMe.getId());
        assertEquals(createMe.getName(),compareMe.getName());
        
        tx.begin();
        em.remove(createMe);
        tx.commit();
        
 //In this block we are creating a new row and checking if its available  
 ----------------------------------------------------------------------------------------------------
**Test Read**
 #Read
    Patient readMe= em.createQuery("select p from Patient p WHERE p.name='Satya'", Patient.class).getSingleResult();
        
        assertEquals("Satya",readMe.getName());
//In this block we are using select query to find the given value from the table
-----------------------------------------------------------------------------------------------------
**Test Update**
#Update
    @Test
    public void updateTest(){
        
         Patient updateMe= em.createQuery("select p from Patient p WHERE p.name='Satya'", Patient.class).getSingleResult();
        tx.begin();
        updateMe.setAddress("Banglore");
        tx.commit();
        
        Patient compareMe=em.find(Patient.class,updateMe.getId());
        assertEquals(updateMe.getAddress(),compareMe.getAddress());
//In this block we are updating a row in the table and checking if it gets updated in the database
----------------------------------------------------------------------------------------------------
**Test Delete**
#Delete
    public void deleteTest(){
        Patient deleteMe=new Patient("Almitha",PatientGender.Female,LocalDate.of(1990, Month.MARCH, 20),"Hassan");
        tx.begin();
        em.persist(deleteMe);
        tx.commit();
        
        assertNotNull(deleteMe.getId());
        
        tx.begin();
        em.remove(deleteMe);
        tx.commit();
        
        Patient existanceCheck=em.find(Patient.class,deleteMe.getId());
        assertNull(existanceCheck);
    }    
//In this block we are creating a new row and deleting it.
-----------------------------------------------------------------------------------------------
**Test Invalid Name**
    public void patientIsInValid_malformedname() {
        Patient p= new Patient("",PatientGender.Male,LocalDate.of(1980, Month.MARCH, 15),"Hassan");
        Set<ConstraintViolation<Patient>> violations = validator.validate(p);
        
       for(ConstraintViolation<Patient> violation : violations){
           System.out.println(violation.toString());
       }
        
        assertEquals( 2, violations.size() );
    }
  
//In this block we are passing empty name in the column Name and checking for violation
  -----------------------------------------------------------------------------------------------
**Test Valid Name**
    public void patientIsValid(){
        Patient p= new Patient("Satya",PatientGender.Male,LocalDate.of(1980, Month.MARCH, 15),"Hassan");
        Set<ConstraintViolation<Patient>> violations = validator.validate(p);
        assertEquals(0,violations.size());
                }
  //In this block we are passing the correct value and checking for violation
  ----------------------------------------------------------------------------------------------------------
  **Test Invalid Date**
    public void patientIsInValid_malformeddate() {
        Patient p= new Patient("Anu",PatientGender.Male,LocalDate.of(2023, Month.MARCH, 15),"Hassan");
        Set<ConstraintViolation<Patient>> violations = validator.validate(p);
        
       for(ConstraintViolation<Patient> violation : violations){
           System.out.println(violation.toString());
       }
        
        assertEquals( 2, violations.size() );
    }
    
  //Future date is passed in Date of Birth column
  ---------------------------------------------------------------------------------------------------------------
 ***Test Valid Date***
    public void patientIsInValid_correctdate() {
        Patient p= new Patient("Anu",PatientGender.Male,LocalDate.of(2022, Month.MARCH, 15),"Hassan");
        Set<ConstraintViolation<Patient>> violations = validator.validate(p);
       for(ConstraintViolation<Patient> violation : violations){
           System.out.println(violation.toString());
       }
        
        assertEquals( 1, violations.size() );
    }
    
  //Past or present date is passed
  -------------------------------------------------------------------------------------------------------------------
    
    Screenshot of All 8 test cases passed
    
    ------------------------------------------------------------------------------------------------------------------
    
    ![image](https://user-images.githubusercontent.com/112361486/192438415-07bc988f-c613-457f-9bf1-15326c8b1ea4.png)



