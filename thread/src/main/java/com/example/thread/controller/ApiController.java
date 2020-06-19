package com.example.thread.controller;

import com.example.thread.test.CountExector;
import com.example.thread.test.TestExecutor;
import com.example.thread.utils.ExecuteUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
public class ApiController {

    Logger logger = LoggerFactory.getLogger(ApiController.class);
    @Autowired
    ExecuteUtils utils;

    @RequestMapping("/e")
    public String execute() {
        try {
            Object submit = utils.submit(TestExecutor.class, new TestExecutor());
            System.out.println(submit);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok";
    }

    @RequestMapping("/c")
    public Integer executeCount() {
        Integer result = null;
        try {
            result =(Integer) utils.submit(CountExector.class, new CountExector());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


}
