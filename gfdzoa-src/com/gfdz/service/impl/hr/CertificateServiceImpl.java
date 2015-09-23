package com.gfdz.service.impl.hr;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gfdz.entity.hr.CertificateFilesEntity;
import com.gfdz.service.hr.CertificateService;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.ContextHolderUtils;
import org.jeecgframework.core.util.FileUtils;

@Service("certificateService")
@Transactional
public class CertificateServiceImpl extends CommonServiceImpl implements CertificateService {

	
}