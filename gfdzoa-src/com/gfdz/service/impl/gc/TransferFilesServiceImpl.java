package com.gfdz.service.impl.gc;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gfdz.service.gc.TransferFilesServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("transferFilesService")
@Transactional
public class TransferFilesServiceImpl extends CommonServiceImpl implements TransferFilesServiceI {
	
}