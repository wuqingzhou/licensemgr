package com.teligen.licensemgr.service.impl;

import com.teligen.licensemgr.entity.City;
import com.teligen.licensemgr.service.CityService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("CityService")
@Transactional
public class CityServiceImpl extends BaseServiceImpl<City> implements CityService {
}
