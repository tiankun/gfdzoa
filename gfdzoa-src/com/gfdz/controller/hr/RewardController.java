package com.gfdz.controller.hr;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.hibernate.criterion.Restrictions;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import com.gfdz.entity.hr.RewardEntity;
import com.gfdz.service.hr.RewardService;

/**   
 * @Title: Controller
 * @Description: 人员奖惩信息
 * @author ant
 * @date 2015-06-11 11:25:21
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/rewardController")
public class RewardController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(RewardController.class);

	@Autowired
	private RewardService rewardService;
	@Autowired
	private SystemService systemService;
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	/**
	 * 人员奖惩信息列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "rewardList")
	public ModelAndView rewardList(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/hr/rewardList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(RewardEntity reward,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(RewardEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, reward, request.getParameterMap());
		String personId = request.getParameter("personId");
		cq.add(Restrictions.eq("personId", personId));
		this.rewardService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除人员奖惩信息
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(RewardEntity reward, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		reward = systemService.getEntity(RewardEntity.class, reward.getId());
		message = "人员奖惩信息删除成功";
		rewardService.delete(reward);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加人员奖惩信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(RewardEntity reward, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(reward.getId())) {
			message = "人员奖惩信息更新成功";
			RewardEntity t = rewardService.get(RewardEntity.class, reward.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(reward, t);
				rewardService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "人员奖惩信息更新失败";
			}
		} else {
			message = "人员奖惩信息添加成功";
			rewardService.save(reward);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 人员奖惩信息列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(RewardEntity reward, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(reward.getId())) {
			reward = rewardService.getEntity(RewardEntity.class, reward.getId());
			req.setAttribute("reward", reward);
		}
		return new ModelAndView("com/gfdz/hr/reward");
	}
}
