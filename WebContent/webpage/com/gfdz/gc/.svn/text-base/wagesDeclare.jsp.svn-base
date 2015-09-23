<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>工资申报</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  $(function() {
	  $("#amount").live("change keyup",function(){
		  $("#guaranteeMoney").val(($("#amount").val()*0.05).toFixed(2));
	  });
	  
  });
  function choose() {
  		$.dialog({
  			content : "url:transferController.do?selectProject",
  			zIndex : 2100,
  			title : "工程列表",
  			lock : true,
  			width : 1000,
  			height : 550,
  			left : '50%',
  			top : '50%',
  			opacity : 0.4,
  			button : [ {
  				name : '确认',
  				callback :function(){
  					clearAll();
  					var iframe = this.iframe.contentWindow;
  					var data=iframe.getProjectInfo();
  					$("#projectId").val(data.id);
  					$("#projectName").val(data.projectName);
  					getCostApproval(data.id);
  					getHiWages(data.id);
  				},
  				focus : true
  			}, {
  				name : '取消',
  				callback : function() {
  				}
  			} ]
  		});
  	}

  	function clearAll(){
  		$("#projectName").val("");
  		$("#projectId").val("");
  	}
  	
  	function getHiWages(val){
  		$('#wagesDeclareList').datagrid({queryParams: {'pId': val}});
  		$('#wagesDeclareList').datagrid('reload');
  	}
  	function getCostApproval(val){
  		$.post("costApprovalController.do?getCostApproval",{"pId":val},function(data){
  			if(data.msg){
  				$("#jd input,#hd input").each(function(){
  					this.value=data[this.id];
  				});
  				$("#jd label,#hd label").each(function(){
  					$(this).html(data[this.id]);
  				});
  			}else{
  				alert("请先设置工程建设内容！");
  			}
  		},"json");
  	}
    </script>
 </head>
 <body style="overflow-y:auto">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="wagesDeclareController.do?save">
			<input id="id" name="id" type="hidden" value="${wagesDeclare.id }">
			<div class="formtitle">工资申报信息</div>
			<table style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							项目编号:
						</label>
					</td>
					<td class="value" colspan="3">
						<input class="inputxt" style="width: 230px" readonly="readonly" id="projectName" value="${wagesDeclare.project.projectName }">
						<input style="width: 230px" id="projectId" name="project.id" value="${wagesDeclare.project.id }" type="hidden">
						<a href="#" class="easyui-linkbutton" plain="true" icon="icon-search" onClick="choose()">选择</a>
		             	<a href="#" class="easyui-linkbutton" plain="true" icon="icon-redo" onClick="clearAll();">清空</a>
						<span class="Validform_checktip"></span>
					</td>
					
					<td align="right">
						<label class="Validform_label">
							申报人:
						</label>
					</td>
					<td class="value">
					
						<input class="inputxt" id="declare" name="declare" ignore="ignore"
							   value="${wagesDeclare.declare != null ? wagesDeclare.declare : user.realName}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							申报日期:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker()"  style="width: 150px" id="declareDate" name="declareDate" ignore="ignore"
							   value="<fmt:formatDate value='${wagesDeclare.declareDate != null ? wagesDeclare.declareDate : date}' type="date" pattern="yyyy-MM-dd"/>">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							本次申报金额:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="amount" name="amount" ignore="ignore"
							   value="${wagesDeclare.amount}">
						<span class="Validform_checktip"></span>
					</td>
					
					<td align="right">
						<label class="Validform_label">
							应扣质保金:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="guaranteeMoney" name="guaranteeMoney" ignore="ignore"
							   value="${wagesDeclare.guaranteeMoney}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							安全互助金:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="mutualMoney" name="mutualMoney" ignore="ignore"
							   value="${wagesDeclare.mutualMoney !=null ? wagesDeclare.mutualMoney : 10}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							月份:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="month" name="month" ignore="ignore"
							   value="${wagesDeclare.month}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				
				<tr>
					<td align="right">
						<label class="Validform_label">
							施工队:
						</label>
					</td>
					<td class="value" colspan="3">
						<input class="inputxt" id="constructionTeam" name="constructionTeam" ignore="ignore"
							   value="${wagesDeclare.constructionTeam}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							备注:
						</label>
					</td>
					<td class="value" colspan="3">
						<input class="inputxt" id="remarks" name="remarks" ignore="ignore"
							   value="${wagesDeclare.remarks}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
			<div class="formtitle">工程费用核定</div>
			<table id="hd" style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="center" colspan="2">
						<label class="Validform_label">
							审定内容
						</label>
					</td>
					<td align="center" >
						<label class="Validform_label">
							增减变更金额
						</label>
					</td>
					<td align="center">
						<label class="Validform_label">
							合计金额
						</label>
					</td>
					<td colspan="4"></td>
				</tr>
				
				<tr>
					<td align="right">
						<label class="Validform_label">
							审定施工费:
						</label>
					</td>
					<td class="value" width="150px">
						<label id="sdsgf" >${costApproval.sdsgf}</label>
					</td>
					<td class="value">
						<label id="bgje" width="150px">${costApproval.bgje}</label>
					</td>
					<td class="value" width="150px">
						<label id="hj" >${costApproval.sdsgf+costApproval.bgje}</label>
					</td>
					<td align="center">
							<label class="Validform_label">
								截至上月累计申报金额:
							</label>
						</td>
						<td class="value">
								<input class="inputxt" id="jzsyje" name="jzsyje" ignore="ignore"
									   value="${wagesDeclare.jzsyje}">
								<span class="Validform_checktip"></span>
							</td>
						<td align="center">
							<label class="Validform_label">
								占审定费用比例(%):
							</label>
						</td>
						<td class="value">
								<input class="inputxt" id="jzsybl" name="jzsybl" ignore="ignore"
									   value="${wagesDeclare.jzsybl}">
								<span class="Validform_checktip"></span>
							</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								质保金:
							</label>
						</td>
						<td class="value">
							<label id="zbj" >${costApproval.sdsgf*0.05}</label>
						</td>
						<td class="value">
							<label id="bgzbj" >${costApproval.bgje*0.05}</label>
						</td>
						<td class="value">
							<label id="bzjhj" >${(costApproval.sdsgf+costApproval.bgje)*0.05}</label>
						</td>
						<td align="center">
						<label class="Validform_label">
							截至本月累计申报金额:
						</label>
						</td>
						<td class="value">
								<input class="inputxt" id="jzbyje" name="jzbyje" ignore="ignore"
									   value="${wagesDeclare.jzbyje}">
								<span class="Validform_checktip"></span>
							</td>
						<td align="center">
							<label class="Validform_label">
								截至本月累计申报金额占审定施工费用比例(%):
							</label>
						</td>
						<td class="value">
								<input class="inputxt" id="jzbybl" name="jzbybl" ignore="ignore"
									   value="${wagesDeclare.jzbybl}">
							<span class="Validform_checktip"></span>
						</td>
					</tr>
				</table>
				<div class="formtitle">工程进度(%)</div>
				<table id="jd" style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="center">
							<label class="Validform_label">
								管网进度
							</label>
						</td>
						<td align="center">
							<label class="Validform_label">
								线缆进度
							</label>
						</td>
						<td align="center">
							<label class="Validform_label">
								设备进度
							</label>
						</td>
						<td align="center">
							<label class="Validform_label">
								总体进度
							</label>
						</td>
					</tr>
					<tr>
						<td class="value" align="center" style="height: 20px">
							<label  id="gwjd" >${costApproval.gwjd}</label>
						</td>
						<td class="value" align="center">
							<label id="xljd" >${costApproval.xljd}</label>
						</td>
						<td class="value" align="center">
							<label id="sbjd" >${costApproval.sbjd}</label>
						</td>
						<td class="value"  align="center">
							<label id="ztjd" >${costApproval.ztjd}</label>
						</td>
					</tr>
				</table>
			<div class="easyui-layout" fit="true">
				 <div region="center" style="padding:1px;">
				   <t:datagrid name="wagesDeclareList" title="工资发放历史记录" actionUrl="wagesDeclareController.do?datagrid" queryParams="{pId:${pId != null ? pId : 0 }}"  idField="id" fit="true">
				   	<t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
			   		<t:dgCol title="项目名称" field="project.projectName" ></t:dgCol>
				    <t:dgCol title="月份" field="month" ></t:dgCol>
				    <t:dgCol title="本次申报金额" field="amount" ></t:dgCol>
				    <t:dgCol title="质保金" field="guaranteeMoney" ></t:dgCol>
				    <t:dgCol title="安全互助金" field="mutualMoney" ></t:dgCol>
				    <t:dgCol title="申报人" field="declare" ></t:dgCol>
				    <t:dgCol title="申报日期" field="declareDate" formatter="yyyy-MM-dd"></t:dgCol>
				    <t:dgCol title="施工队" field="constructionTeam" ></t:dgCol>
				   	<t:dgCol title="备注" field="remarks" ></t:dgCol>
				  </t:datagrid>
				</div>
 			</div>
		</t:formvalid>
 </body>
 </html>