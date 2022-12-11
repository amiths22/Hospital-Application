# itmd4515-f22-fp-asatyanarayan1 Final Project Readme file
itmd4515-f22-fp-asatyanarayan1 created by GitHub Classroom

- Project Summary

This is a Jakarta EE web application which contains domain model as the persistence layer with EJB as service layer, security structures and configuration.
Hospital Management system consists of Dcotor, Patient, Staff, Admin, and appointment.
New patients can sign up and book appointments with any doctors in the system.
Staffs can work for different doctors at the same time.
Doctors can manage staff by adding, modifying and deleting them. Doctor can also see the appointments which belong to them.
Admin can view all the users that is Doctors, Patients and list of all appointments. Admin has the rights to add new doctor


- Design

For the business domain I have selected Hospital application where a patient can sign up and book appointments with the doctor and it can also be used to maintain internal staffs of the hospital.
Below is the entity relationship model of Hospital Application system which contains entities like Doctor, Patient, Staff, Appointments.

Many to Many: Doctor & Staff can be related by many-to-many relationship where a doctor can have multiple staff. A staff member can work for many doctors.
One to Many: A patient and appointment has one to many relationships because a patient can have multiple appointments
One to Many: A doctor and appointment also have one-to-many relationships, where a doctor is linked to multiple appointments.

The initial page is the login page where doctor, staff, patient and admin can login. It also contains a link for patient to sign up and use the application.
If a doctor or staff is admin, they can access the admin module.


- Requirements

For this project we are using Apache netbeans as IDE, payara server, Mysql for database and persistence JPA, Maven, Jakarta validation, Junit Jupite, Jboss Logging and opentest4j

- Screen Captures
Login Page:

![image](https://user-images.githubusercontent.com/112361486/206887442-b0029469-39ba-4552-b979-9d10b5deff86.png)

Sign Up page:

![image](https://user-images.githubusercontent.com/112361486/206887547-6f6844c7-04fd-4d43-b088-2ff1d5c9bff0.png)

Newpatient is signed up
![image](https://user-images.githubusercontent.com/112361486/206887563-1b829fcc-2671-4ce8-b1bf-93ac11afe62f.png)

Admin Login:
![image](https://user-images.githubusercontent.com/112361486/206887599-42c14494-015f-4cdb-8e32-2a6edba3afa5.png)

Admin module:
![image](https://user-images.githubusercontent.com/112361486/206887603-d27d3ad5-7308-448c-bb75-806296b2addb.png)
![image](https://user-images.githubusercontent.com/112361486/206887607-19e5321f-47d7-42b0-ad47-049122dfac05.png)

Admin can add new doctor
![image](https://user-images.githubusercontent.com/112361486/206887638-189d6eaf-58cb-4cf2-8d92-20c067a84ca3.png)
![image](https://user-images.githubusercontent.com/112361486/206887649-7ac758fe-c5ac-402b-b9d3-db9b8259d3e3.png)

![image](https://user-images.githubusercontent.com/112361486/206887671-379cbc40-6f9c-4163-8f84-ce363814b9e1.png)

Doctor Login
![image](https://user-images.githubusercontent.com/112361486/206887694-fdd8f101-7893-4b69-b5c5-adc44dc54dd1.png)

Doctor1 is also an admin, so admin module is displayed
![image](https://user-images.githubusercontent.com/112361486/206887703-4db48abb-c9ab-4e03-8d8d-580497563175.png)

Doctor module
It has list of staffs working for that particular doctor. List of appointments which belong to that doctor
![image](https://user-images.githubusercontent.com/112361486/206887725-ab918d46-b033-41a2-a117-2c8a7086b345.png)

Creation of new staff using doctor module
![image](https://user-images.githubusercontent.com/112361486/206887755-5d792bee-27f5-495e-accc-0196b65201cc.png)

![image](https://user-images.githubusercontent.com/112361486/206887762-de879553-407e-49c6-a55d-b8fa9af11539.png)
![image](https://user-images.githubusercontent.com/112361486/206887768-df8917a0-9038-4dac-b302-85ee8abc787f.png)

We can read about a particular staff details by clicking the read button
![image](https://user-images.githubusercontent.com/112361486/206887807-979b9a1f-792d-4077-97f6-707f121fd24d.png)

We can update a particular staff details by clicking the update button

![image](https://user-images.githubusercontent.com/112361486/206887828-3622d0e2-010d-42ce-bde9-011591449dfc.png)
![image](https://user-images.githubusercontent.com/112361486/206887860-d2adabff-e628-4c9d-bf91-3c5687384776.png)

We can delete a particular staff by clicking delete button
![image](https://user-images.githubusercontent.com/112361486/206887873-9372921a-265f-47a9-a9a2-33a931c35ce3.png)

![image](https://user-images.githubusercontent.com/112361486/206887877-295e5081-9a13-48be-b0e6-eb24ca7745c3.png)

Staff Module Login:
![image](https://user-images.githubusercontent.com/112361486/206887898-c8379517-6f3e-45d2-bf6a-14a2725aa94e.png)

![image](https://user-images.githubusercontent.com/112361486/206887906-6d6ff9e8-2bc4-4817-9eb5-33be810071b2.png)

Staff is also an admin and can access admin module
![image](https://user-images.githubusercontent.com/112361486/206887917-2e5b6727-df74-44e6-9728-18355ce3e8b1.png)

![image](https://user-images.githubusercontent.com/112361486/206887921-34593abf-eceb-483f-ab88-9434d3fc97cb.png)

Logout button returns to login page
![image](https://user-images.githubusercontent.com/112361486/206887935-d2471e5a-f743-4615-a612-3230711559e6.png)

Patient module Login 
![image](https://user-images.githubusercontent.com/112361486/206887949-1c0fb70e-5570-4b32-a83f-7e712ebbaa76.png)
![image](https://user-images.githubusercontent.com/112361486/206887959-ab286167-6307-4c92-a248-0ef40ee3dc82.png)

In patient module list of all doctors present in the system is displayed.
A patient can read about a particular doctor by clicking on read button
![image](https://user-images.githubusercontent.com/112361486/206887978-a25c1cd1-ef07-4d95-9ec6-7eb230d34a4c.png)

Below is the new doctor added by admin

![image](https://user-images.githubusercontent.com/112361486/206887988-d58e3fbd-734d-436a-a645-32007cba14c6.png)

A patient can schedule an appointment with a particular doctor by clicking schedule appointment button

![image](https://user-images.githubusercontent.com/112361486/206888028-a0ad5142-a04e-4a8b-9b00-4a26d70d616f.png)

![image](https://user-images.githubusercontent.com/112361486/206888037-205bf262-2a76-4c6f-96e8-df7aee19e5a8.png)

![image](https://user-images.githubusercontent.com/112361486/206888059-1569a9b6-e3ef-410c-b4b2-4f1f698af1cf.png)

In the list of appointments we can see the new scheduled appointment

![image](https://user-images.githubusercontent.com/112361486/206888044-b2f1cfa2-b686-4c9e-b281-177822658dc9.png)

Patient can also read, modify or delete the appointment from list of appointments by selecting appropriate buttons.

Viewing the appointment

![image](https://user-images.githubusercontent.com/112361486/206888104-110467a0-b42c-40c9-ad9b-fdced4af60c0.png)

Changing the appointment

![image](https://user-images.githubusercontent.com/112361486/206888120-870b4379-5d82-43e4-b099-c2f36b5657ab.png)
we can see the updated timing in list of appointments
![image](https://user-images.githubusercontent.com/112361486/206888124-f3a6e990-dbab-427c-a198-33a6c388481c.png)

Deleting the appointment

![image](https://user-images.githubusercontent.com/112361486/206888143-1783fd05-351e-4716-aebc-edad142bc4b0.png)

The selected appointment is deleted
![image](https://user-images.githubusercontent.com/112361486/206888154-15f96c9e-3ea1-414c-86d1-2b9d81b93638.png)


Logging in to the new signed up user

![image](https://user-images.githubusercontent.com/112361486/206888165-ca97c6d3-4d94-4044-b8e6-b50343007371.png)

![image](https://user-images.githubusercontent.com/112361486/206888169-6bf0e3e2-beb1-4050-935b-d9a3ff1a90d9.png)

![image](https://user-images.githubusercontent.com/112361486/206888174-a4c22bb0-a0b5-4a90-ac46-29a3be24c9b1.png)
As it is a new user we dont have any appointments.

After scheduling an appointment
![image](https://user-images.githubusercontent.com/112361486/206888197-cf71693b-7f79-4699-b7bc-ac3de0083117.png)


Javadoc can be accessed by clicking on apidocs in the login page

![image](https://user-images.githubusercontent.com/112361486/206888236-72acdde1-c145-49e8-b7ef-5ebfd8ff521b.png)


- Expected Results

Login:

Admin user login can be accessed by below creds
username: admin
password: admin

Patient user login can be accessed by below creds

username: patient1
password: patient1

username: patient2
password: patient2

Doctor user login can be accessed by below creds

username: doctor1
password: doctor1

username: doctor2
password: doctor2

username: doctor3
password: doctor3

Staff user login can be accessed by below creds
username: staff1
password: staff1

username: staff2
password: staff2

Below are the details which was added during the execution.
Sign Up: it is the new patient
username: almitha
password: almitha

New Doctor: It is creds of new doctor added.
username: doc1
password:doc1

- Development Insights 

This project is mainly for patients to book an appointment with the doctors. Doctors can also manage staffs who are working under them.
I was able to improve my understanding of JAVA EE standards, database persistence, security, and presentation components thanks to this particular course and the project. I am quite knowledgeable about. I gained knowledge of the JPA Query Language, JPA annotations, authorization, and authentication, as well as how web services may be created using EJB components and a variety of other ideas.
I just knew the basics of Java. After completing this course and project. I learnt a lot about Java, this course has motivated me to learn more about java. I will continue to learn more things like hibernate, spring
I would like Thank you professor for the wonderful lessons you taught. This class will help me for lifetime.
