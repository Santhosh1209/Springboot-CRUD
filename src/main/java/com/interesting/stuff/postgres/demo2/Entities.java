package com.interesting.stuff.postgres.demo2;

import jakarta.persistence.*;

import java.time.LocalDate;
// basically, this file is going to translate into the Postgres database
// Hibernate is going to use this to create the table!

@Entity // used to create entities with can talk with the database
@Table
public class Entities {
    @Id
    // @Id annotation is used to denote the primary key field of the entity class. Here, it's the id field.

    // The Sequence Generator is used to generate consecutive primary key values!
    @SequenceGenerator(
            name = "student_sequence", // name of the seq generator
            sequenceName = "student_sequence", // name of the seq that is generated
            allocationSize = 1 // number by which each value is incremented
    )
    //
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE, // denotes the type (here, its a seq)
            generator = "student_sequence" // name of seq
    )
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //@Column(name = "first_name")
    private String firstName;

    //@Column(name = "last_name")
    private String lastName;

    //@Column(name = "email")
    private String email;

    //@Column(name = "gender")
    private String gender;

    //@Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    //@Column(name = "country")
    private String country;

    public Entities() {
        // Default no-arg constructor required by JPA
    }

    public Entities(int id,String firstName, String lastName, String email, String gender, LocalDate dateOfBirth, String country) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.country = country;
    }
    public Entities(String firstName, String lastName, String email, String gender, LocalDate dateOfBirth, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.country = country;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    // toString method for easy debugging
    @Override
    public String toString() {
        return "Entities{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", country='" + country + '\'' +
                '}';
    }
}

