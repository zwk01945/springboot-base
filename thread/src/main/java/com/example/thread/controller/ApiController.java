package com.example.thread.controller;

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


}
