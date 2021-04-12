package com.currentbp.controller;

import com.currentbp.api.daletou.facade.DaletouServiceFacade;
import com.currentbp.common.entity.ResultData;
import com.currentbp.daletou.entity.Daletou;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author current_bp
 * @createTime 20180418
 */
@RestController
@RequestMapping("/daletou")
public class DaletouForcecastController {
    private static Logger logger = LoggerFactory.getLogger(DaletouForcecastController.class);

    @Autowired(required = false)
    private DaletouServiceFacade daletouServiceFacade;


    /**
     * 预测大乐透：第一版
     */
    @RequestMapping(value = "/forecastV1", method = RequestMethod.GET)
    public ResultData forecastV1(int num,int daletouId) {
        return ResultData.successed(daletouServiceFacade.forecastV1(num,daletouId));
    }

    /**
     * 预测大乐透：第二版
     */
    @RequestMapping(value = "/forecastV2", method = RequestMethod.GET)
    public ResultData forecastV2(int num, List<Daletou> daletous,int daletouId) {

        return ResultData.successed(daletouServiceFacade.forecastV2(num,daletous,daletouId));
    }

}
