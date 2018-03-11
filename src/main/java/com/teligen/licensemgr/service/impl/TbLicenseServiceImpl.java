package com.teligen.licensemgr.service.impl;

import com.teligen.licensemgr.entity.TbLicense;
import com.teligen.licensemgr.service.TbLicenseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("TbLicenseService")
@Transactional
public class TbLicenseServiceImpl extends BaseServiceImpl<TbLicense> implements TbLicenseService{
}
