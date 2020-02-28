package com.condeinsyt.skuulba.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {


    @Test
    void getFirstName() {
        Student newStudent = new Student();
        newStudent.setStudentClass("Kofi");
        assertEquals("kofi", newStudent.getStudentClass());
    }

    @Test
    void setFirstName() {
        Student newStudent = new Student();
        newStudent.setStudentClass("Kofi");
        assertEquals("kofi", newStudent.getStudentClass());
    }

    @Test
    void getLastName() {
        Student newStudent = new Student();
        newStudent.setLastName("Annan");
        assertEquals("annan", newStudent.getLastName());
    }

    @Test
    void setLastName() {
        Student newStudent = new Student();
        newStudent.setLastName("Annan");
        assertEquals("annan", newStudent.getLastName());
    }

    @Test
    void getOtherNames() {
        Student newStudent = new Student();
        newStudent.setLastName("Kwame asante");
        assertEquals("kwame asante", newStudent.getLastName());
    }

    @Test
    void setOtherNames() {
        Student newStudent = new Student();
        newStudent.setLastName("Kwame asante");
        assertEquals("kwame asante", newStudent.getLastName());
    }

    @Test
    void getMotherTongue() {
        Student newStudent = new Student();
        newStudent.setMotherTongue("Twi");
        assertEquals("twi", newStudent.getMotherTongue());
    }

    @Test
    void setMotherTongue() {
        Student newStudent = new Student();
        newStudent.setMotherTongue("Twi");
        assertEquals("twi", newStudent.getMotherTongue());
    }

    @Test
    void getHomeTown() {
        Student newStudent = new Student();
        newStudent.setMotherTongue("Twi");
        assertEquals("twi", newStudent.getMotherTongue());
    }

    @Test
    void setHomeTown() {
        Student newStudent = new Student();
        newStudent.setHomeTown("Kumasi");
        assertEquals("kumasi", newStudent.getHomeTown());
    }

    @Test
    void getLivingWith() {
        Student newStudent = new Student();
        newStudent.setLivingWith("Both");
        assertEquals("both",newStudent.getLivingWith());
    }

    @Test
    void setLivingWith() {
    }

    @Test
    void getNoSiblings() {
    }

    @Test
    void setNoSiblings() {
    }

    @Test
    void getDob() {
    }

    @Test
    void setDob() {
    }

    @Test
    void getLanguages() {
    }

    @Test
    void setLanguages() {
    }

    @Test
    void getCreatedAt() {
    }

    @Test
    void setCreatedAt() {
    }

    @Test
    void testToString() {
    }
}