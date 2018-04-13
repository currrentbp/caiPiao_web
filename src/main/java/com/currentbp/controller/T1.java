package com.currentbp.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/4/13.
 */
@RestController
@RequestMapping("/t")
public class T1 {
    private static Logger logger = LoggerFactory.getLogger(T1.class);
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String sss(){
        logger.info("=====>t1");
        return null;
    }

}
