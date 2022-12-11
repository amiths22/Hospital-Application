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


- Expected Results

Login:
username: admin
password: admin

username: patient1
password: patient1

username: patient2
password: patient2

username: doctor1
password: doctor1

username: doctor2
password: doctor2

username: doctor3
password: doctor3

username: staff1
password: staff1

Below are the details which was added during the execution.
Sign Up:
username: amiths
password: amiths

New Doctor:
username: doc1
password:doc1

- Development Insights 

This project is mainly for patients to book an appointment with the doctors. Doctors can also manage staffs who are working under them.
I was able to improve my understanding of JAVA EE standards, database persistence, security, and presentation components thanks to this particular course and the project. I am quite knowledgeable about. I gained knowledge of the JPA Query Language, JPA annotations, authorization, and authentication, as well as how web services may be created using EJB components and a variety of other ideas.
I just knew the basics of Java. After completing this course and project. I learnt a lot about Java, this course has motivated me to learn more about java. I will continue to learn more things like hibernate, spring
I would like Thank you professor for the wonderful lessons you taught. This class will help me for lifetime.