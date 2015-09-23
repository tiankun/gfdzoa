package com.gfdz.service.gc;

import javax.servlet.http.HttpServletRequest;

import org.jeecgframework.core.common.service.CommonService;

import com.gfdz.entity.gc.ProjectInfoEntity;

public interface ProjectInfoServiceI extends CommonService{
	
	/**
	 * 
	  * @Title: saveProject
	  * @Description: 保存项目设计
	  * @param projectInfo
	  * @param request void
	  * @throws 
	  * @exception
	  * @author fly
	  * @date 2015年8月12日 上午9:32:27
	 */
	public void saveProject(ProjectInfoEntity projectInfo,HttpServletRequest request);
	
	/**
	 * 
	  * @Title: updateProject
	  * @Description: 更新项目设计
	  * @param projectInfo
	  * @param request
	  * @throws Exception void
	  * @throws 
	  * @exception
	  * @author fly
	  * @date 2015年8月12日 上午9:33:15
	 */
	public void updateProject(ProjectInfoEntity projectInfo,HttpServletRequest request) throws Exception;

}
