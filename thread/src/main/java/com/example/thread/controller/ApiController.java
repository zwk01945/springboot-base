package com.example.thread.controller;

import com.example.thread.bean.CoustomerZt;
import com.example.thread.dao.CoustomerZtDao;
import com.example.thread.general.computed.read.CountRead;
import com.example.thread.utils.ExecuteUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

@RestController
@RequestMapping(value = "/api/v1")
public class ApiController {

    Logger logger = LoggerFactory.getLogger(ApiController.class);
    @Autowired
    ExecuteUtils utils;

    @Autowired
    CoustomerZtDao coustomerZtDao;

    @RequestMapping(value = "/s")
    public Object select() {
        Map<String,Object> param = new ConcurrentHashMap<>();
        param.put("start",0);
        param.put("endPage",10);
        List<CoustomerZt> coustomerZts =
                coustomerZtDao.selectAll(param);
        return coustomerZts;
    }


}

