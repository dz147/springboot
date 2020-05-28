package com.dbcoding.mall.cms.controller;

import com.dbcoding.mall.cms.aspect.annotation.SystemLogs;
import com.dbcoding.mall.model.ResultVO;
import com.dbcoding.mall.model.SellChannelAddress;
import com.dbcoding.mall.cms.service.SellChannelAddressService;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sellChannel")
@Slf4j
public class SellChannelAddressController {

    @Autowired
    private SellChannelAddressService sellChannelAddressService;


    @GetMapping(value = "/getList", produces = {"application/json;charset=UTF-8"})
    @SystemLogs(key = "1007")
    public @ResponseBody ResultVO getChannelAddress() {
        ResultVO resultVO = new ResultVO();

        PageHelper.startPage(1, 2);
        List<SellChannelAddress> sellList = sellChannelAddressService.getSellChannelAddress();
        log.info("cms");
        resultVO.setData(sellList);
        return resultVO;
    }
}
