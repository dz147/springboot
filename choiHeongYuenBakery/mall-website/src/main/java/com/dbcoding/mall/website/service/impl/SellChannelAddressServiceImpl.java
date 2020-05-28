package com.dbcoding.mall.website.service.impl;

import com.dbcoding.mall.dao.SellChannelAddressMapper;
import com.dbcoding.mall.model.SellChannelAddress;
import com.dbcoding.mall.website.service.SellChannelAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SellChannelAddressServiceImpl implements SellChannelAddressService {

    @Autowired
    private SellChannelAddressMapper sellChannelAddressMapper;//这里会报错，但是并不会影响

    @Override
    public List<SellChannelAddress> getSellChannelAddress() {
        return sellChannelAddressMapper.selectAll();
    }
}
