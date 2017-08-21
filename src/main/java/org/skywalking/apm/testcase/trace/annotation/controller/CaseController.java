package org.skywalking.apm.testcase.trace.annotation.controller;

import org.skywalking.apm.testcase.trace.annotation.service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CaseController {

    @Autowired
    private CaseService caseService;

    @RequestMapping("/trace-activation")
    public ModelAndView selectUser() throws InterruptedException {
        caseService.queryUser("201708180001");
        caseService.updateUser("201708180001");
        ModelAndView modelAndView = new ModelAndView("success");
        return modelAndView;
    }
}
