<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="personInfoList" title="人员信息表" actionUrl="personInfoController.do?employeeListData" 
  idField="id" fit="true" queryMode="group">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="姓名" field="realName" ></t:dgCol>
   <t:dgCol title="性别" field="sex" dictionary="sex"></t:dgCol>
   <t:dgCol title="部门" field="currentDepart.departname" query="true"></t:dgCol>
   <t:dgCol title="岗位" field="gangwei" ></t:dgCol>
   <t:dgCol title="身份证号" field="idCard" ></t:dgCol>
   <t:dgCol title="出生日期" field="birthday" formatter="yyyy-MM-dd"></t:dgCol>
   <t:dgCol title="籍贯" field="nativePlace" ></t:dgCol>
   <t:dgCol title="民族" field="nation" ></t:dgCol>
   <t:dgCol title="学历" field="education" ></t:dgCol>
   <t:dgCol title="毕业学校" field="shcool" ></t:dgCol>
   <t:dgCol title="专业" field="major" ></t:dgCol>
   <t:dgCol title="家庭住址" field="homeAddr" ></t:dgCol>
   <t:dgCol title="家庭电话" field="homePhone" ></t:dgCol>
   <t:dgCol title="紧急联系人" field="contact" ></t:dgCol>
   <t:dgCol title="人员状态" field="personState" dictionary="persontype"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="personInfoController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="personInfoController.do?addorupdate" funname="addOneTab"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="personInfoController.do?addorupdate" funname="updateOneTab"></t:dgToolBar>
   <t:dgToolBar title="查看" width="100%" icon="icon-search" url="personInfoController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>