package com.gfdz.service.impl.gc;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gfdz.service.gc.QualityCheckServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("qualityCheckService")
@Transactional
public class QualityCheckServiceImpl extends CommonServiceImpl implements QualityCheckServiceI {
	
}