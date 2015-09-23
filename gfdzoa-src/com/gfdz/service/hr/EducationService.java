package com.gfdz.service.hr;

import org.jeecgframework.core.common.service.CommonService;

import com.gfdz.entity.hr.EducationFilesEntity;

public interface EducationService extends CommonService{

	public void deleteFile(EducationFilesEntity file);

}
