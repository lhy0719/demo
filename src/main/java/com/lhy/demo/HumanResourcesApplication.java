/**
 * Company Copyright (C) 2004-2018 All Rights Reserved.
 */
package com.lhy.demo;

import com.lhy.demo.domain.Employee;
import java.math.BigDecimal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 *
 * @author xuhaitao
 * @version v 1.0.0 
 * @since v 1.0.0 2018-12-29 19:18
 */
public class HumanResourcesApplication {
    private static final Logger log = LoggerFactory.getLogger(HumanResourcesApplication.class.getName());
    public static void main(String[] args) {
        Employee e = new Employee();
        e.setName("J Smith");
        e.setEmployeeNumber("0001");
        e.setTaxpayerIdentificationNumber("123-45-6789");
        e.setSalary(BigDecimal.valueOf(45000.0));
        e.printAudit(log);
    }

}
