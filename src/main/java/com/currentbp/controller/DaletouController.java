package com.currentbp.controller;

import com.currentbp.api.daletou.facade.DaletouServiceFacade;
import com.currentbp.api.daletou.facade.ForecastDaletouServiceFacade;
import com.currentbp.common.entity.ResultData;
import com.currentbp.daletou.bo.entity.DaletouBo;
import com.currentbp.daletou.condition.DaletouCondition;
import com.currentbp.daletou.entity.Daletou;
import com.currentbp.util.all.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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

    /**
     * 查询所有的大乐透列表
     *
     * @return 大乐透列表
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResultData all() {
        return ResultData.successed(daletouServiceFacade.queryDaletouAll());
    }

    /**
     * 分页查询
     *
     * @return 大乐透列表
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResultData list() {
        DaletouCondition daletouCondition = new DaletouCondition();
        daletouCondition.setPageNum(1);
        daletouCondition.setPageSize(10);
        List<Daletou> daletous = daletouServiceFacade.queryDaletouByCondition(daletouCondition);
        List<DaletouBo> daletouBos = new ArrayList<>();
        for (Daletou daletou : daletous) {
            daletouBos.add(new DaletouBo(daletou));
        }
        return ResultData.successed(daletouBos);
    }

    /**
     * 预测大乐透
     *
     * @return 结果
     */
    @RequestMapping(value = "/forecast", method = RequestMethod.GET)
    public ResultData forecast(int num,int daletouId) {
        return ResultData.successed(daletouServiceFacade.forecast(num,daletouId));
    }

    /**
     * 判断中奖个数
     *
     * @return 结果
     */
    @RequestMapping(value = "/win", method = RequestMethod.POST)
    public ResultData win(@RequestBody List<Daletou> daletous) {
        checkParams4Win(daletous);
        return ResultData.successed(daletouServiceFacade.isWin(daletous));
    }

    private void checkParams4Win(List<Daletou> daletous) {
        daletous.forEach((Daletou daletou) -> Assert.notNull(daletou.getId(), "大乐透的期号不能为空"));
    }
}
