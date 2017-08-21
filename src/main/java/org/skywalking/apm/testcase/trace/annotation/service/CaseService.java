package org.skywalking.apm.testcase.trace.annotation.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.skywalking.apm.toolkit.trace.ActiveSpan;
import org.skywalking.apm.toolkit.trace.Trace;
import org.springframework.stereotype.Service;

@Service
public class CaseService {

    private Logger logger = LogManager.getLogger(CaseService.class);

    @Trace
    public void queryUser(String id) throws InterruptedException {
        Thread.sleep(1000L);
        logger.info("query user info");
        ActiveSpan.tag("user.id", id);
    }

    @Trace(operationName = "updateUser")
    public void updateUser(String id){

    }
}
