package com.lhy.demo.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PersonTest {

    @Test
    public void testPerson() {
        Person p = new Person("Joe Q Author", 42, 173, 82, "Brown", "MALE");
        Logger l = LoggerFactory.getLogger(Person.class);
        l.error("Name: " + p.getName());
        l.info("Age:" + p.getAge());
        l.info("Height (cm):" + p.getHeight());
        l.info("Weight (kg):" + p.getWeight());
        l.info("Eye Color:" + p.getEyeColor());
        l.info("Gender:" + p.getGender());
        assertEquals("Joe Q Author", p.getName());
        assertEquals(42, p.getAge());
        assertEquals(173, p.getHeight());
        assertEquals(82, p.getWeight());
        assertEquals("Brown", p.getEyeColor());
        assertEquals("MALE", p.getGender());
    }
}
