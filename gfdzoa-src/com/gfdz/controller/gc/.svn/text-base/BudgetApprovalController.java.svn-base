package com.gfdz.controller.gc;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.common.UploadFile;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.core.util.oConvertUtils;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gfdz.entity.gc.BudgetApprovalEntity;
import com.gfdz.entity.gc.BudgetApprovalFilesEntity;
import com.gfdz.service.gc.BudgetApprovalService;

/**
 * @Title: Controller
 * @Description: 预算审批表附件
 * @author ant
 * @date 2015-08-12 10:14:42
 * @version V1.0
 * 
 */
@Scope("prototype")
@Controller
@RequestMapping("/budgetApprovalController")
public class BudgetApprovalController extends BaseController {
	@Autowired
	private BudgetApprovalService budgetApprovalService;
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
	 * 预算审批表附件列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "budgetApprovalList")
	public ModelAndView budgetApprovalList(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/gc/budgetApprovalList");
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
	public void datagrid(BudgetApprovalEntity budgetApproval, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(BudgetApprovalEntity.class, dataGrid);
		// 查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, budgetApproval, request.getParameterMap());
		this.budgetApprovalService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除预算审批表附件
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(BudgetApprovalEntity budgetApproval, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		budgetApproval = systemService.getEntity(BudgetApprovalEntity.class, budgetApproval.getId());
		message = "预算审批表附件删除成功";
		budgetApprovalService.delete(budgetApproval);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);

		j.setMsg(message);
		return j;
	}

	/**
	 * 添加预算审批表附件
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(BudgetApprovalEntity budgetApproval, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		try {
			budgetApprovalService.budgetApproval(budgetApproval);
		} catch (Exception e) {
			if (StringUtil.isEmpty(e.getMessage())) {
				j.setMsg("操作异常！");
			} else {
				j.setMsg(e.getMessage());
			}
			j.setSuccess(false);
			e.printStackTrace();
		}
		j.setObj(budgetApproval);
		return j;
	}

	/**
	 * 预算审批表附件列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(BudgetApprovalEntity budgetApproval, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(budgetApproval.getId())) {
			budgetApproval = budgetApprovalService.getEntity(BudgetApprovalEntity.class, budgetApproval.getId());
			req.setAttribute("page", budgetApproval);
		}
		req.setAttribute("userName", ResourceUtil.getSessionUserName().getRealName());
		return new ModelAndView("com/gfdz/gc/budgetApproval");
	}

	@ResponseBody
	@RequestMapping(params = "saveFiles", method = RequestMethod.POST)
	public AjaxJson saveFiles(HttpServletRequest request, HttpServletResponse response, BudgetApprovalFilesEntity budgetApprovalFiles) {
		AjaxJson j = new AjaxJson();
		Map<String, Object> attributes = new HashMap<String, Object>();
		String fileKey = oConvertUtils.getString(request.getParameter("fileKey"));// 文件ID
		String budgetApprovalId = oConvertUtils.getString(request.getParameter("budgetApprovalId"));// ID

		if (StringUtil.isNotEmpty(fileKey)) {
			budgetApprovalFiles.setId(fileKey);
			budgetApprovalFiles = systemService.getEntity(BudgetApprovalFilesEntity.class, fileKey);

		}
		BudgetApprovalEntity budgetApproval = systemService.getEntity(BudgetApprovalEntity.class, budgetApprovalId);
		budgetApprovalFiles.setBudgetApproval(budgetApproval);
		UploadFile uploadFile = new UploadFile(request, budgetApprovalFiles);
		uploadFile.setCusPath("files");
		uploadFile.setSwfpath("swfpath");
		uploadFile.setByteField(null);// 不存二进制内容
		budgetApprovalFiles = systemService.uploadFile(uploadFile);
		attributes.put("fileKey", budgetApprovalFiles.getId());
		attributes.put("viewhref", "commonController.do?objfileList&fileKey=" + budgetApprovalFiles.getId());
		attributes.put("delurl", "commonController.do?delObjFile&fileKey=" + budgetApprovalFiles.getId());
		j.setMsg("文件添加成功");
		j.setAttributes(attributes);

		return j;
	}

	/**
	 * 
	 * @Title: delFile
	 * @Description: 删除附件
	 * @param request
	 * @return AjaxJson
	 * @throws
	 * @exception
	 * @author fly
	 * @date 2015年6月2日 下午4:44:26
	 */
	@RequestMapping(params = "delFile")
	@ResponseBody
	public AjaxJson delFile(HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String id = request.getParameter("id");
		BudgetApprovalFilesEntity file = budgetApprovalService.getEntity(BudgetApprovalFilesEntity.class, id);
		message = "" + file.getAttachmenttitle() + "被删除成功";
		budgetApprovalService.deleteFile(file);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		j.setSuccess(true);
		j.setMsg(message);
		return j;
	}

	/**
	 * 流程处理
	 * 
	 * @author WU
	 * @date 2015-8-12 下午3:19:10
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "budgetApprovalHandle")
	public ModelAndView budgetApprovalHandle(HttpServletRequest req) {
		String pid = req.getParameter("processInstanceId");
		BudgetApprovalEntity page = budgetApprovalService.findUniqueByProperty(BudgetApprovalEntity.class, "processInstanceId", pid);
		if (page != null && page.getBudgetApprovalFiles() != null && page.getBudgetApprovalFiles().size() > 0) {
			req.setAttribute("fileId", page.getBudgetApprovalFiles().get(0).getId());
		}
		req.setAttribute("page", page);
		if ("apply".equals(req.getParameter("taskKey"))) {
			return new ModelAndView("com/gfdz/gc/budgetApprovalUpdate");
		} else {
			return new ModelAndView("com/gfdz/gc/budgetApprovalHandle");
		}
	}

	/**
	 * 
	 * @author WU
	 * @date 2015-8-5 上午9:52:50
	 * @param pid
	 * @return
	 */
	@RequestMapping(params = "budgetApprovalView")
	public ModelAndView budgetApprovalView(HttpServletRequest req) {
		String pid = req.getParameter("pid");
		BudgetApprovalEntity page = budgetApprovalService.findUniqueByProperty(BudgetApprovalEntity.class, "processInstanceId", pid);
		if (page != null && page.getBudgetApprovalFiles() != null && page.getBudgetApprovalFiles().size() > 0) {
			req.setAttribute("fileId", page.getBudgetApprovalFiles().get(0).getId());
		}
		req.setAttribute("page", page);
		return new ModelAndView("com/gfdz/gc/budgetApprovalView");
	}

	/**
	 * 执行任务
	 * 
	 * @author WU
	 * @date 2015-8-12 下午3:20:20
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(params = "completeTask")
	public AjaxJson completeTask(BudgetApprovalEntity budgetApproval, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		try {
			budgetApprovalService.completeTask(budgetApproval, request);
			j.setObj(budgetApproval);
		} catch (Exception e) {
			String message = "办理失败";
			if (StringUtil.isNotEmpty(e.getMessage())) {
				message = e.getMessage();
			}
			j.setSuccess(false);
			j.setMsg(message);
			e.printStackTrace();
		}
		return j;
	}
}
