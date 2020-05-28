package com.dbcoding.mall.website;


import com.dbcoding.mall.model.SellChannelAddress;
import com.dbcoding.mall.website.service.SellChannelAddressService;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@EnableCaching
public class SellChannelTests extends MallWebsiteApplicationTests {
    @Autowired
    private SellChannelAddressService sellChannelAddressService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testSellChannelList() {
        PageHelper.startPage(1, 1);
        List<SellChannelAddress> list = sellChannelAddressService.getSellChannelAddress();
        Assert.assertNotNull("list地址", list);
        for (SellChannelAddress s : list) {
            log.info(s.toString());
        }
    }

    @Test
    public void testRedis() {
        redisTemplate.opsForValue().set("test:set:address","what 我的世界？");
        String value = (String)redisTemplate.opsForValue().get("test:set:address");
        log.info(value);
    }

}
