package com.dbcoding.mall.dao;

import com.dbcoding.mall.model.SellChannel;
import java.util.List;

public interface SellChannelMapper {
    int deleteByPrimaryKey(String id);


    int insert(SellChannel record);

    SellChannel selectByPrimaryKey(String id);

    List<SellChannel> selectAll();

    int updateByPrimaryKey(SellChannel record);
}