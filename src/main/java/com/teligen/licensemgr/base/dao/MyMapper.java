package com.teligen.licensemgr.base.dao;

import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

public interface MyMapper<T> extends Mapper<T>,
        InsertListMapper<T>,
        IdsMapper<T>,
        ConditionMapper<T> {
}
