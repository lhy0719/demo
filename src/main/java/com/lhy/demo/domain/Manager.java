/**
 * Company Copyright (C) 2004-2019 All Rights Reserved.
 */
package com.lhy.demo.domain;

import com.lhy.demo.service.StockOptionRecipient;
import java.math.BigDecimal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 *
 * @author xuhaitao
 * @version v 1.0.0 
 * @since v 1.0.0 2019-01-02 20:00
 */
public class Manager extends Employee implements StockOptionRecipient {
    private static final Logger log = LoggerFactory.getLogger(Manager.class);

    public Manager() {
    }

    public class DirectReports {
    }

    @Override
    public void processStockOptions(int numberOfOptions, BigDecimal price) {
        log.info("I can't believe I got " + numberOfOptions + " options at $" +
                price.toPlainString() + "!");
    }

}
