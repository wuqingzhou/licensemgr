package com.teligen.licensemgr.service.impl;

import com.teligen.licensemgr.dao.TbConfigMapper;
import com.teligen.licensemgr.entity.TbConfig;
import com.teligen.licensemgr.service.TbConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;

@Service("TbConfigService")
@Transactional
public class TbConfigServiceImpl extends BaseServiceImpl<TbConfig> implements TbConfigService {
    @Autowired
    TbConfigMapper tbConfigMapper;

    @Override
    public TbConfig getWarnDay() {
        Condition condition = new Condition(TbConfig.class);
        condition.or().andEqualTo("codeKey", "warn_day");
        List<TbConfig> tbconfigList = tbConfigMapper.selectByCondition(condition);
        if(tbconfigList.isEmpty()){
            return null;
        }
        return tbconfigList.get(0);
    }
}
