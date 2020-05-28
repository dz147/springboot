package com.dbcoding.mall.dao;

import com.dbcoding.mall.model.SellChannelAddress;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SellChannelAddressMapper {
    int deleteByPrimaryKey(String id);

    int insert(SellChannelAddress record);

    SellChannelAddress selectByPrimaryKey(String id);

    List<SellChannelAddress> selectAll();

    int updateByPrimaryKey(SellChannelAddress record);
}