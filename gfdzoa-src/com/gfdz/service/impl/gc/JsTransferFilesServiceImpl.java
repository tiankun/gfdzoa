package com.gfdz.service.impl.gc;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gfdz.service.gc.JsTransferFilesServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("jsTransferFilesService")
@Transactional
public class JsTransferFilesServiceImpl extends CommonServiceImpl implements JsTransferFilesServiceI {
	
}