<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>发票开具记录</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/kindeditor/kindeditor.js"></script>
  <script type="text/javascript" src="plug-in/kindeditor/lang/zh_CN.js"></script>
      <script type="text/javascript">
 	   $(function(){
 	       $("#billInfo tr td").each(function(){
 	           $(this).find("input").attr("disabled",true);
 	           $(this).find("textarea").attr("disabled",true);
 	       });
 	   });
 	  $(function(){
 		    //隐藏增值税
 		   $(".zengzs").attr("style","display:none");
 		   /* $("#billpath input[name$=stype]").live("change",function(){
 					  getCriterion($(this).parent("td").parent("tr"));
 				}); */
 				change();
 		  //查看模式情况下,删除和上传附件功能禁止使用
 			if(location.href.indexOf("load=detail")!=-1){
 				$(".jeecgDetail").hide();
 			}		
 				
 		 });
 		 
 		 function change(){
 		 var ftype=$("#ftype").val();

 		 if(ftype==3){
 		   
 		  $(".zengzs").removeAttr("style");
 		  getStype(ftype);
 		  
 		 }else if(ftype==2){
 		 
 		 $(".zengzs").attr("style","display:none");
 		  getStype(ftype);
 		 }else if(ftype==1){
 		 
 		 $(".zengzs").attr("style","display:none");
 		  getStype(ftype);
 		 }else if(ftype==""){
 		 
 		 $(".zengzs").attr("style","display:none");
 		  getStype(ftype);
 		 }
 		 
 		 }
 		 
 		//开具发票类型
 		function getStype(ftype){
 		    $("#stype").html("");
 			$.getJSON("billController.do?getStype",{"ftype":ftype},function(data){ 
 			if(data && data.length>0){
 			          var o='<option value="">==请选择==</option>';
 					  for(var i=0;i<data.length;i++){
 						  var test=data[i].typecode;
 						  var flag = test1(test);
 						  if(flag){
 						 o+='<option value="'+data[i].typecode+'" selected>'+data[i].typename+'</option>';
 					  	}else {
 					  	o+='<option value="'+data[i].typecode+'">'+data[i].typename+'</option>';
 					  	}
 						  
 					  }
 					 $("#stype").append(o);
 					
 				  }
 			  });
 			 
 			}
 		 function test1(aa){
 			var bb=${stype};
 			  if(bb==aa){
 				  return true;
 			  }else{
 				  return false;
 			  }
 		  }
 		  	function uploadFile(data){
 		  		$("#billId").val(data.attributes.id);
 		  		if($(".uploadify-queue-item").length>0){
 		  			upload();
 		  		}else{
 		  			frameElement.api.opener.reloadTable();
 		  			frameElement.api.close();
 		  		}
 		  	}
 		  	
 		  	function close(){
 		  		frameElement.api.close();
 		  	}
    </script>
 </head>
 <body style="overflow-y: hidden" scroll="no">
 <div class="formtitle">发票开具记录</div>	
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="billController.do?completeTask">
			<input id="id" name="id" type="hidden" value="${billPage.id }">
			<table style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable" id="billpath">
				<tr>
					<td align="right">
						<label class="Validform_label">
							用户名称:
						</label>
					</td>
					<td class="value">
					    <input class="inputxt" id="userId" name="userId.id" type="hidden"
							   value="${billPage.userId.id!=null ?billPage.userId.id:user.id}" datatype="*">
						<input class="inputxt" id="username" name="username" readonly="readonly"
							   value="${billPage.userId.realName!=null ?billPage.userId.realName : user.realName}">   
							   
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							发票类型:
						</label>
					</td>
					<td class="value" >
						<select name="ftype" id="ftype" style="width: 75%" onchange="change();" datatype="*">
							<option value="">
								未选择
							</option>
							
							<c:forEach var="ftypelist" items="${ftype}">
								<option  value="${ftypelist.typecode}" <c:if test="${billPage.ftype==ftypelist.typecode}">selected</c:if>>
									${ftypelist.typename}
								</option>
							</c:forEach>
				      </select>
						
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							开具发票类型:
						</label>
					</td>
					<td class="value">
				<select id="stype" name="stype" style="width: 75%" datatype="*">
							
				</select>
						<span class="Validform_checktip"></span>
					</td> 
				
					<td align="right">
						<label class="Validform_label">
							客户单位名称:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="unit" name="unit" ignore="ignore"
							   value="${billPage.unit}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							开具金额:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="money" name="money"  datatype="d"
							   value="${billPage.money}" >
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							计划收款时间:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width: 150px" id="planDate" name="planDate" ignore="ignore"
							     value="<fmt:formatDate value='${billPage.planDate}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							申请时间:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width: 150px" id="inputDate" name="inputDate" ignore="ignore"
							     value="<fmt:formatDate value='${billPage.inputDate}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							开具发票内容:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="content" name="content" ignore="ignore"
							   value="${billPage.content}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							发票号:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="num" name="num" ignore="ignore"
							   value="${billPage.num}">
						<span class="Validform_checktip"></span>
					</td>
					
				
					<td align="right">
						<label class="Validform_label">
							付款单位:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="payUnit" name="payUnit" ignore="ignore"
							   value="${billPage.payUnit}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					
				
					<td align="right">
						<label class="Validform_label">
							地税国税号:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="disgsh" name="disgsh" ignore="ignore"
							   value="${billPage.disgsh}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
						
						</label>
					</td>
					<td class="value">
						
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr class="zengzs" style="display:none">
					<td align="right">
						<label class="Validform_label">
							纳税人识别号(针对增值税):
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="shibh" name="shibh" ignore="ignore"
							   value="${billPage.shibh}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							地址(针对增值税):
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="addr" name="addr" ignore="ignore"
							   value="${billPage.addr}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr class="zengzs">
					<td align="right">
						<label class="Validform_label">
							电话(针对增值税):
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="phone" name="phone" ignore="ignore"
							   value="${billPage.phone}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							开户行(针对增值税):
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="kaihh" name="kaihh" ignore="ignore"
							   value="${billPage.kaihh}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr class="zengzs">
					<td align="right">
						<label class="Validform_label">
							账号(针对增值税):
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="account" name="account" ignore="ignore"
							   value="${billPage.account}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
	
						</label>
					</td>
					<td class="value">

						<span class="Validform_checktip"></span>
					</td>
					
					
				</tr>
				<tr class="zengzs">
				<td align="right">
						<label class="Validform_label">
							附件（针对增值税）:
						</label>
					</td>
					<td class="value" colspan="2">
					<input type="hidden" value="${billPage.id }" id="billId" name="billId" />
						<table>
							<c:forEach items="${billPage.billFiles}" var="billFile">
								<tr style="height: 34px;">
									<td>${billFile.attachmenttitle}</td>
									<td><a href="commonController.do?viewFile&fileid=${billFile.id}&subclassname=com.gfdz.entity.cw.BillFilesEntity" title="下载">下载</a></td>
									<td><a href="javascript:void(0);"
										onclick="openwindow('预览','commonController.do?openViewFile&fileid=${billFile.id}&subclassname=com.gfdz.entity.cw.BillFilesEntity','fList',1000,700)">预览</a></td>
									<td><a href="javascript:void(0)" class="jeecgDetail" onclick="delFile('billController.do?delFile&id=${billFile.id}',this)">删除</a></td>
								</tr>
							</c:forEach>
						</table>
					</td>
				
				
				<td class="value">
				    <div class="form" id="filediv"></div>
					<div class="form jeecgDetail">
					<t:upload name="fiels" id="file_upload" extend="*.doc;*.docx;*.txt;*.ppt;*.xls;*.xlsx;*.html;*.htm;*.pdf;" buttonText="添加文件" formData="billId" uploader="billController.do?saveFiles">
					</t:upload>
					</div>
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							备注:
						</label>
					</td>
					<td class="value" colspan="3">
						<input class="inputxt" id="remark" style="width: 430px" name="remark" ignore="ignore"
							   value="${billPage.remark}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
			<div class="formtitle">审批信息</div>	
			<c:if test="${taskKey!='cashierExecute'}">
			<table style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right" width="60px">
						<label class="Validform_label">
							审批结果:
						</label>
					</td>
					<td class="value">
					<input id="taskKey" name="taskKey" type="hidden" value="${taskKey}">			
					<input id="taskId" name="taskId" type="hidden" value="${taskId}">			
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
			</table>
			</c:if>
			<c:if test="${taskKey=='cashierExecute'}">
			<table style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right" width="60px">
						<label class="Validform_label">
							出纳操作:
						</label>
					</td>
					<td class="value">
					<input id="taskKey" name="taskKey" type="hidden" value="${taskKey}">			
					<input id="taskId" name="taskId" type="hidden" value="${taskId}">			
					<select name="billState" id="billState" style="width: 50%"  datatype="*">
							     <option  value="true" selected>
									入账
								</option>
								<option  value="false">
									作废
								</option>
							
				      </select>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							备注:
						</label>
					</td>
					<td class="value">
					<textarea class="textarea" id="postil" name="postil"></textarea>
					</td>
				</tr>
			</table>
			</c:if>
		</t:formvalid>
 </body>