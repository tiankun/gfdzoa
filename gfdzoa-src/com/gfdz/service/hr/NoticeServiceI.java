package com.gfdz.service.hr;

import org.jeecgframework.core.common.service.CommonService;

import com.gfdz.entity.hr.NoticeFilesEntity;

public interface NoticeServiceI extends CommonService{

	public void deleteFile(NoticeFilesEntity file);

}
