package com.currentbp.controller;

import com.currentbp.api.daletou.facade.DaletouServiceFacade;
import com.currentbp.api.daletou.facade.ForecastDaletouServiceFacade;
import com.currentbp.common.entity.ResultData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author current_bp
 * @createTime 20180418
 */
@RestController
@RequestMapping("/daletou")
public class DaletouController {
    private static Logger logger = LoggerFactory.getLogger(DaletouController.class);

    @Autowired(required = false)
    private DaletouServiceFacade daletouServiceFacade;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResultData daletouList(){
        return ResultData.successed(daletouServiceFacade.queryDaletouAll());
    }
}
