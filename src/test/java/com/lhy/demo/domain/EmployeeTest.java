package com.lhy.demo.domain;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmployeeTest {

    @Test
    public void test() {
        Logger l = LoggerFactory.getLogger(EmployeeTest.class);
        Integer integer1 = Integer.valueOf(1);
        Integer integer2 = Integer.valueOf(1);
        l.info("Q: integer1 == integer2 ? A: " + (integer1 == integer2));
        l.info("Q: integer1.equals(integer2) ? A: " + integer1.equals(integer2));
        integer1 = new Integer(integer1);
        integer2 = new Integer(integer2);
        l.info("Q: integer1 == integer2 ? A: " + (integer1 == integer2));
        l.info("Q: integer1.equals(integer2) ? A: " + integer1.equals(integer2));
        Employee employee1 = new Employee();
        Employee employee2 = new Employee();
        l.info("Q: employee1 == employee2 ? A: " + (employee1 == employee2));
        l.info("Q: employee1.equals(employee2) ? A : " + employee1.equals(employee2));
    }
}
