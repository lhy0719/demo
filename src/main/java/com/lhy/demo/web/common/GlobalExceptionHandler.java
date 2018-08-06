/**
 * Company Copyright (C) 2004-2018 All Rights Reserved.
 */
package com.lhy.demo.web.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理
 *
 * @author xuhaitao
 * @version v 1.0.0
 * @since v 1.0.0 2018-08-02 15:45
 */
@ControllerAdvice
class GlobalExceptionHandler {

  private static final String DEFAULT_ERROR_VIEW = "errors";

  @ExceptionHandler(value = Exception.class)
  public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
    ModelAndView mav = new ModelAndView();
    mav.addObject("exception", e);
    mav.addObject("url", req.getRequestURL());
    mav.setViewName(DEFAULT_ERROR_VIEW);
    return mav;
  }

}
