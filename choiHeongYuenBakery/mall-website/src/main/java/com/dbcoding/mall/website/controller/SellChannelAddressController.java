package com.dbcoding.mall.website.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.dbcoding.mall.model.ResultVO;
import com.dbcoding.mall.model.SellChannelAddress;
import com.dbcoding.mall.website.redis.RedisUtil;
import com.dbcoding.mall.website.service.SellChannelAddressService;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sellChannel")
@Slf4j
public class SellChannelAddressController {

    @Autowired
    private SellChannelAddressService sellChannelAddressService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisUtil redisUtil;


    /**
     * @Description: TODO
     * @Param: null
     * @return: List<SellChannelAddress>
     * @Author: Stephen.Zhang
     * @Date: 2020-5-13 17:58:59
     */
    @GetMapping(value = "/getList", produces = {"application/json;charset=UTF-8"})
    public @ResponseBody
    ResultVO getChannelAddress(@RequestParam String key) {
        ResultVO resultVO = new ResultVO();
        PageHelper.startPage(1, Integer.parseInt(key));
        List<SellChannelAddress> sellList = sellChannelAddressService.getSellChannelAddress();
        resultVO.setData(sellList);
        return resultVO;
    }
}
