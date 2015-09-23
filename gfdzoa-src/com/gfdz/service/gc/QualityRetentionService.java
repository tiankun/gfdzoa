package com.gfdz.service.gc;

import javax.servlet.http.HttpServletRequest;

import org.jeecgframework.core.common.service.CommonService;

import com.gfdz.entity.gc.QualityRetentionEntity;

public interface QualityRetentionService extends CommonService{
	
	/**
	 * 
	  * @Title: qrWorkFlowStart
	  * @Description: 质保金发放申请开始
	  * @param qualityRetention
	  * @param request void
	  * @throws 
	  * @exception
	  * @author fly
	  * @date 2015年8月24日 上午10:30:24
	 */
	public void qrWorkFlowStart(QualityRetentionEntity qualityRetention,HttpServletRequest request);

	/**
	 * 
	  * @Title: completeTask
	  * @Description: 办理质保金发放申请任务
	  * @param qualityRetention
	  * @param request void
	  * @throws 
	  * @exception
	  * @author fly
	  * @date 2015年8月24日 上午10:30:44
	 */
	public void completeTask(QualityRetentionEntity qualityRetention,HttpServletRequest request);

}
