package com.controller.aspcet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by yjy on 16-10-26.
 */

@Aspect
public class ControllerLog {

    private Log log = LogFactory.getLog(this.getClass());

    @Before("execution(* com.controller.impl..*.*(..))")
    public void logControllerInfo(){
        log.info("control mapping");
    }
}
