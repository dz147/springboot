package com.dbcoding.mall.website.scheduled;

import com.dbcoding.mall.model.SellChannelAddress;
import com.dbcoding.mall.website.service.SellChannelAddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @ClassName: AAA
 * @Description: TODO
 * @Author: Stephen.Zhang
 * @CreateDate: 2020-05-14 14:35
 * @Version: 1.0
 **/
@Slf4j
@Component
public class OrderScheduled {

    @Autowired
    private SellChannelAddressService sellChannelAddressService;

    @Scheduled(cron = "0 0/5 * * * ?")
    public void querySell() {
        log.info("start push data scheduled!");
        for (SellChannelAddress s : sellChannelAddressService.getSellChannelAddress()) {
            log.info(s.toString());
        }
        log.info("end push data scheduled!");
    }

}
