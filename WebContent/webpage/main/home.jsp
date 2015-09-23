<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div style="margin-top: 1px;">
<table style="width:100%;height:100%">
<tr>
<td width="50%">
<div style="height:300px">
 <iframe scrolling="yes" frameborder="0"  src="dailyWorkController.do?myWorkTask&isIframe" style="width:100%;height:100%;"></iframe>
</div>
</td>
<td width="50%">
<div style="height:300px">
 <iframe scrolling="yes" frameborder="0"  src="noticeController.do?myNoticeList&isIframe" style="width:100%;height:100%;"></iframe>
</div>
</td>
</tr>
<tr>
<td>
<div style="height:300px">
 <iframe scrolling="yes" frameborder="0"  src="activitiController.do?claimedTask&isIframe" style="width:100%;height:100%;"></iframe>
</div>
</td>

<td>
<div style="height:300px">
 <iframe scrolling="yes" frameborder="0"  src="dailyWorkController.do?myWorkTask&isIframe" style="width:100%;height:100%;"></iframe>
</div>
</td></tr>

</table>

</div>