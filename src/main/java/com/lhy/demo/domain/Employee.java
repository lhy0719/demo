/**
 * Company Copyright (C) 2004-2018 All Rights Reserved.
 */
package com.lhy.demo.domain;

import java.math.BigDecimal;

/**
 *
 *
 * @author xuhaitao
 * @version v 1.0.0 
 * @since v 1.0.0 2018-12-29 17:46
 */
public class Employee extends Person{

    private String taxpayerIdentificationNumber;
    private String employeeNumber;
    private BigDecimal salary;

    @Override
    public void printAudit(StringBuilder buffer) {
        super.printAudit(buffer);

        buffer.append("TaxpayerIdentificationNumber=");
        buffer.append(getTaxpayerIdentificationNumber());
        buffer.append(","); buffer.append("EmployeeNumber=");
        buffer.append(getEmployeeNumber());
        buffer.append(","); buffer.append("Salary=");
        buffer.append(getSalary().setScale(2).toPlainString());
    }

    public Employee() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Employee(String name, int age, int height, int weight,
            String eyeColor, String gender) {
        super(name, age, height, weight, eyeColor, gender);
        // TODO Auto-generated constructor stub
    }

    public String getTaxpayerIdentificationNumber() {
        return taxpayerIdentificationNumber;
    }

    public void setTaxpayerIdentificationNumber(String taxpayerIdentificationNumber) {
        this.taxpayerIdentificationNumber = taxpayerIdentificationNumber;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
