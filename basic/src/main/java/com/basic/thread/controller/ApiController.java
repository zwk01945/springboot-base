package com.basic.thread.controller;

import com.basic.thread.bean.CoustomerZt;
import com.basic.thread.dao.CoustomerZtDao;
import com.basic.thread.utils.ExecuteUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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

