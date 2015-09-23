<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>出差记录</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
	$(function(){
		var iszz='${travel.iszanzhi}';
		  if(iszz=='1'){
			  $("#zzmoney").show();
		  }else{
			  $("#zzmoney").hide();
		  }
       $("#travelinfo tr td").each(function(){
           $(this).find("input").attr("disabled",true);
           $(this).find("textarea").attr("disabled",true);
           $(this).find("checkbox").attr("disabled",true);
	       $(this).find("select").attr("disabled",true);
       });
   });
</script>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="travelController.do?completeTask">
		  	<div class="formtitle" title="基本信息">基本信息</div>
			<input id="id" name="id" type="hidden" value="${travel.id }">
			<table id="travelinfo" style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							出差申请人:
						</label>
					</td>
					<td class="value">
						<input type="hidden" id="traveluser" name="travelUser.id" value="${travel.travelUser.id!=null ?travel.travelUser.id:user.id }">
						<input class="inputxt" id="username" name="username" readonly="readonly"
							   value="${travel.travelUser.realName!=null ? travel.travelUser.realName : user.realName}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							部门:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="departname" name="departname" readonly="readonly"
							   value="${travel.depart.departname!=null ?travel.depart.departname:user.currentDepart.departname }">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							开始时间:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  style="width: 150px" id="beginDate" name="beginDate" ignore="ignore"
							     value="<fmt:formatDate value='${travel.beginDate}' type="date" pattern="yyyy-MM-dd"/>">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							结束时间:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  style="width: 150px" id="endDate" name="endDate" ignore="ignore"
							     value="<fmt:formatDate value='${travel.endDate}' type="date" pattern="yyyy-MM-dd"/>">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							是否暂支:
						</label>
					</td>
					<td class="value">
						<t:dictSelect hasLabel="false" field="iszanzhi" id="iszanzhi" typeGroupCode="yesorno" defaultVal="${travel.iszanzhi !=null ? travel.iszanzhi : 0 }"></t:dictSelect>
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							暂支金额:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="zzmoney" name="zzmoney"  maxlength="10" 
						value="${travel.zzmoney}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							住宿类别:
						</label>
					</td>
					<td class="value" colspan="3">
						<t:dictSelect hasLabel="false" field="stayType" id="stayType" typeGroupCode="stayType" defaultVal="${travel.stayType!=null ? travel.stayType:4 }"></t:dictSelect>
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							出差事由:
						</label>
					</td>
					<td class="value" colspan="3">
						<input class="inputxt" id="travelReason" name="travelReason" ignore="ignore" style="width:98%"
							   value="${travel.travelReason}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
					<div class="formtitle" title="随行人员">随行人员</div>
						<table cellpadding="0" cellspacing="1" class="formtable" id="travelpath"
						id="Travel_table" class="formtable">
						<tr bgcolor="#E6E6E6" style="line-height:25px">
							<td align="center" bgcolor="#EEEEEE">序号</td>
							<td align="center" bgcolor="#EEEEEE">姓名</td>
							<td align="center" bgcolor="#EEEEEE">部门</td>
						</tr>
						<tbody id="add_Travel_table">
							<c:if test="${fn:length(travelOtheruser)  > 0 }">
								<c:forEach items="${travelOtheruser}" var="poVal" varStatus="stuts">
									<tr id="${stuts.index+1}" style="line-height:25px">
										<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
										<td align="center">
										${poVal.tsUser.realName }
										</td>
										<td align="center">
										${poVal.tsDepart.departname }
										</td>
									</tr>
								</c:forEach>
							</c:if>
						</tbody>
					</table>
		<div class="formtitle" title="出差路线">出差路线</div>
				<div style="width: auto; height: auto; ">
					<table cellpadding="0" cellspacing="1" class="formtable" id="travelpath"
						id="Travel_table" class="formtable">
						<tr bgcolor="#E6E6E6" style="line-height:25px">
							<td align="center" bgcolor="#EEEEEE">序号</td>
							<td align="center" bgcolor="#EEEEEE">目的地</td>
							<td align="center" bgcolor="#EEEEEE">交通工具</td>
							<td align="center" bgcolor="#EEEEEE">到达时间</td>
							<td align="center" bgcolor="#EEEEEE">离开时间</td>
							<td align="center" bgcolor="#EEEEEE">报销标准</td>
						</tr>
						<tbody id="add_Travel_table">
							<c:if test="${fn:length(travel.travelPaths)  > 0 }">
								<c:set value="0" var="summoney" />
								<c:set value="" var="isplane" />
								<c:forEach items="${travel.travelPaths}" var="poVal" varStatus="stuts">
									<c:set var="summoney" value="${ poVal.criterion+summoney}"></c:set>
									<c:set var="isplane" value="${isplane}${','}${ poVal.vehicle}"></c:set>
									<tr id="${stuts.index+1}" style="line-height:25px">
										<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
										<td align="center">
										${poVal.county.fullname }
										</td>
										<td align="center">
										<t:Code typeGroupCode="vehicle" value="${poVal.vehicle }"/>
										</td>
										<td align="center">
										<fmt:formatDate value='${poVal.beginDate}' type="date" pattern="yyyy-MM-dd"/>
										</td>
										<td align="center">
										<fmt:formatDate value='${poVal.endDate}' type="date" pattern="yyyy-MM-dd"/>
										</td>
										<td align="center">
										${poVal.criterion }
										</td>
									</tr>
								</c:forEach>
							</c:if>
						</tbody>
						<tfoot>
						<tr bgcolor="#E6E6E6" style="line-height:25px">
							<td align="center" bgcolor="#EEEEEE" colspan="5">总额</td>
							<td align="center" bgcolor="#EEEEEE">${summoney }</td>
						</tr>
						</tfoot>
					</table>
				</div>
				<div class="formtitle" title="审批信息">审批信息</div>
			<table style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
				<input id="taskKey" name="taskKey" type="hidden" value="${taskKey}">			
				<input id="taskId" name="taskId" type="hidden" value="${taskId}">
				<input id="applyUserId" name="applyUserId" type="hidden" value="${travel.travelUser.id}">
				<input id="iszanzhi" name="iszanzhi" type="hidden" value="${travel.iszanzhi}">
				<input id="isplane" name="isplane" type="hidden" value="${isplane}">		
				<c:if test="${taskKey=='deptLeaderAudit' || taskKey=='leaderManagerAudit' || taskKey=='treasurerAudit' }">
						<tr>
							<td align="right" width="60px">
								<label class="Validform_label">
									审批结果:
								</label>
							</td>
							<td class="value">
							<t:dictSelect hasLabel="false" field="auditType" id="auditType" typeGroupCode="auditType" defaultVal=""></t:dictSelect>
							</td>
						</tr>
						<tr>
							<td align="right">
								<label class="Validform_label">
									审批意见:
								</label>
							</td>
							<td class="value">
							<textarea class="textarea" id="postil" name="postil"></textarea>
							</td>
						</tr>
				</c:if>	
				</table>
		</t:formvalid>
 </body>