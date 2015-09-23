<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
  <t:base type="jquery,tools,easyui,DatePicker"></t:base>
<title>新建工作</title>
<style type="text/css">
.formTitle{
	text-align: left;
	margin-top:10px;
	margin-bottom:10px;
	margin-left:25px;
	padding-left:25px;
	background: url('../images/jt.gif') no-repeat;
	font-size:14px;
	font-weight: bold;
}
.requdiv{
	height: 32px;
	line-height:32px;
	background:#fbf1a4 url('../images/hi.png') 5px center no-repeat;
	overflow: hidden;
	text-align: left;
}
.requdiv label{
	padding-left: 30px;
	font-size:14px;
	color:black;
	font-family:微软雅黑;
}
p{
	font-size:12px;
	color:black;
}
a{
  text-decoration: underline;
  color: blue;
}
a:hover{
  text-decoration: underline;
  color: blue;
}
</style>
<script type="text/javascript">
function showResource(processDefinitionId,resourceType){
	var box = new Sys.msgbox('流程图查看','/bams/processResource.do?type=image&pid='+processDefinitionId,750,500);
	box.show();
}

function transactFlow(url){
	openMDITab("/bams/erp/"+url);
}

function getDetail(title,url,width,height){
	  $.dialog({
          content : 'url:'+url,
          lock : true,
          title :title,
          opacity : 0.3,
          width : width,
          height : height,
          ok: function(){
		    	iframe = this.iframe.contentWindow;
				saveObj();
				return false;
		    },
          cache : false,
          cancelVal : '关闭',
          cancel : true
      });
 }
 
 function reloadTable(){
 }
</script>
</head>
<body style="overflow: hidden;">
	<div class="requdiv">
	<label>
	共有 ${fn:length(list)}个流程，请选择流程开始办理。
	</label>
	</div>
	<c:forEach items="${listTypes}" var="typeVal" varStatus="stuts">
	<div class="formTitle">${typeVal.typename }</div>
	<div>
	<c:forEach items="${list}" var="poVal" varStatus="stuts">
	<c:if test="${ poVal.processType==typeVal.typecode}">
		<div style="padding:10px 30px;float:left;">
				<img title="" src="${webRoot }/images/evl_fkjc.png" border="0"/>
				<p style="text-align:center;">${poVal.processName }</p>
				<p style="text-align:center;">
					<label>
					<a href="javascript:void(0);" title="点击开始办理" onclick="getDetail('新建${poVal.processName }','${ poVal.beginUrl}','1000px','600px');">
						新建工作
					</a>
					</label>&nbsp;
					<label>
					<a href="javascript:void(0);" title="点击查看流程图" onclick="getDetail('流程图查看','activitiController.do?resourceRead&processDefinitionId=${poVal.processDefinitionId }&resourceType=image&isIframe','1000px','600px');">
						流程图
					</a>
					</label>
				</p>
			</div>
		</c:if>	
	</c:forEach>
	<div style="clear:both"></div>
	</div>
	</c:forEach>
	</body>
</html>