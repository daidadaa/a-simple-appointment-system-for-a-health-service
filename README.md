# A Simple Appointment System for a Health Service

**Author:** Wu Shaowei  
**Student ID:** 24832850 
**Unit:** PROG2004 Object Oriented Programming  
**Assessment:** A1 – Appointment System  

---

## Project Overview

This project implements a simple appointment system for a health service.  
It demonstrates object-oriented programming concepts such as **inheritance, polymorphism, encapsulation**, and the use of **collections**.

The system allows:

- Creating health professionals (General Practitioners and Other Specialists)
- Creating appointments with basic validation (mobile number, time format)
- Managing appointments with conflict detection and cancellation
- Printing details of professionals and appointments

---

## Project Structure

wushaowei-A1/
├── README.md
└── src/
├── AssignmentOne.java
├── HealthProfessional.java
├── GeneralPractitioner.java
├── OtherProfessional.java
├── Appointment.java
├── AppointmentManager.java
└── AppointmentExceptions.java

---

## Compilation & Run Instructions

1. Open a terminal in the project root (`wushaowei-A1`)
2. Compile all Java files into the `bin` directory:

```bash
javac -d bin src/*.java

3.Run the main program:

java -cp bin AssignmentOne

4.You should see output for Part 3 (health professionals) and Part 5 (appointments).
After the demo, an interactive menu allows creating, cancelling, and viewing appointments.

Mapping to Assessment Rubric
| Part                          | Description                                                                    | Files                                                                     |
| ----------------------------- | ------------------------------------------------------------------------------ | ------------------------------------------------------------------------- |
| Part 1–2 (25%)                | HealthProfessional base class and GP/OtherProfessional subclasses              | HealthProfessional.java, GeneralPractitioner.java, OtherProfessional.java |
| Part 3 (10%)                  | Demonstration of creating health professionals and printing their details      | AssignmentOne.java                                                        |
| Part 4 (20%)                  | Appointment class with patient info, mobile validation, time format validation | Appointment.java                                                          |
| Part 5 (25%)                  | AppointmentManager with create, print, cancel, and conflict detection          | AppointmentManager.java                                                   |
| Accuracy & Validations (7.5%) | Mobile & time validation, doctor conflict detection                            | Appointment.java, AppointmentManager.java                                 |
| Concept Understanding (12.5%) | OOP concepts, collections, encapsulation, polymorphism                         | All files, main demo in AssignmentOne.java                                |


Repository & Demonstration

Video Demonstration: [Insert Video Link Here]