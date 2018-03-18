package com.teligen.licensemgr.service;

import com.teligen.licensemgr.entity.TbConfig;

public interface TbConfigService extends BaseService<TbConfig> {
    TbConfig getWarnDay();
}
