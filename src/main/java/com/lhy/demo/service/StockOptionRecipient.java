/**
 * Company Copyright (C) 2004-2019 All Rights Reserved.
 */
package com.lhy.demo.service;

import java.math.BigDecimal;

/**
 *
 *
 * @author xuhaitao
 * @version v 1.0.0 
 * @since v 1.0.0 2019-01-02 20:11
 */
public interface StockOptionRecipient {
    void processStockOptions(int numberOfOptions, BigDecimal price);

}
