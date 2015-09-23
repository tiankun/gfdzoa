<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>人员信息表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <style type="text/css">
   .tt-inner {
		display: inline-block;
		line-height: 12px;
	}
</style>
<script type="text/javascript">
	$(function() {
		$("#tabMenus").tabs({
			tabPosition : 'left',
		   	border : false,
		 	onSelect:function(title,index){
			 var tab = $('#tabMenus').tabs('getSelected');
			 var url=$(tab).attr("url")+"&personId="+'${personId}';
			 var height=$(window).height();
			 if(url && $(tab).children().length==0){
				
		 		if(index==0){
		 			$('#tabMenus').tabs('update', {
					 	tab: tab,
					 	options: {
					 		href:url
					 	}
					 });
		 		}else if(index==7){
		 			 $('#tabMenus').tabs('update', {
						 	tab: tab,
						 	options: {
		 				 		content: '<iframe scrolling="auto" src="' +url+ '" frameborder="0" style="border:0;width:100%;height:'+height+'px;"></iframe>',
						 	}
						 });
		 		}else{
				 $('#tabMenus').tabs('update', {
				 	tab: tab,
				 	options: {
 				 		content: '<iframe src="' +url+ '" frameborder="0" style="border:0;width:100%;height:'+height+'px;"></iframe>',
				 	}
				 });
		 		}
			 }
		 }
		});
	});
	</script>	
 </head>
 <body style="overflow-y: hidden" scroll="no">
		<div id="tabMenus"
			data-options="tabWidth:150,tabHeight:110">
			<div id="panel1" cache="true" url="personInfoController.do?personBaseInfo"
				title="&nbsp;&nbsp;&nbsp;&nbsp;<span class='tt-inner'>
					&nbsp;&nbsp;基本信息</span>">
			</div>
			<div id="panel2" cache="false" url="educationController.do?educationList"
				title="&nbsp;&nbsp;&nbsp;&nbsp;<span class='tt-inner'>
						&nbsp;&nbsp;学历信息</span>">
			</div>
			<div id="panel3" cache="false" url="workExpController.do?workExpList"
				title="&nbsp;&nbsp;&nbsp;&nbsp;<span class='tt-inner'>
						&nbsp;&nbsp;工作履历</span>">
			</div>
			<div id="panel4" cache="false" url="certificateController.do?certificateList"
				title="&nbsp;&nbsp;&nbsp;&nbsp;<span class='tt-inner'>
					&nbsp;&nbsp;证书信息</span>">
			</div>
			<div id="panel5" cache="false" url="personContractController.do?personContractList"
				title="&nbsp;&nbsp;&nbsp;&nbsp;<span class='tt-inner'>
					&nbsp;&nbsp;合同信息</span>">
			</div>
			<div id="panel6" cache="false" url="rewardController.do?rewardList"
				title="&nbsp;&nbsp;&nbsp;&nbsp;<span class='tt-inner'>
					&nbsp;&nbsp;奖惩信息</span>">
			</div>
			<div id="panel7" cache="false" url="familyController.do?familyList"
				title="&nbsp;&nbsp;&nbsp;&nbsp;<span class='tt-inner'>
					&nbsp;&nbsp;家庭信息</span>">
			</div>
			<div id="panel8" cache="false" url="evaluationController.do?evaluationList"
				title="&nbsp;&nbsp;&nbsp;&nbsp;<span class='tt-inner'>
					&nbsp;&nbsp;转正考评</span>">
			</div>
		</div>
 </body>