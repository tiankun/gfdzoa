package com.gfdz.service.impl.gc;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gfdz.service.gc.MaterialBaseServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("materialBaseService")
@Transactional
public class MaterialBaseServiceImpl extends CommonServiceImpl implements MaterialBaseServiceI {
	
}