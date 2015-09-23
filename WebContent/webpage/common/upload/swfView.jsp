<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html >
<html>
<head>
<title>附件查看</title>
<script type="text/javascript" src="plug-in/Flexpaper/flexpaper_flash.js"></script>
<style type="text/css">
  html,body,form{
   height: 100%;
   padding: 0px;
   margin: 0px;
  }
</style>
</head>
<body id="viewerPlaceHolder" style="overflow: hidden;">
</body>
<script type="text/javascript">
	var fp = new FlexPaperViewer('plug-in/Flexpaper/FlexPaperViewer',
	'viewerPlaceHolder', {
		config : {
			SwfFile : '${swfpath}',
			EncodeURI:true,
			Scale : 0.6,
			ZoomTransition : 'easeOut',
			ZoomTime : 0.5,
			ZoomInterval : 0.2,
			FitPageOnLoad : true,
			FitWidthOnLoad : true,
			FullScreenAsMaxWindow : false,
			ProgressiveLoading : true,
			MinZoomSize : 0.2,
			MaxZoomSize : 5,
			SearchMatchAll : false,
			InitViewMode : 'SinglePage',
			ViewModeToolsVisible : true,
			ZoomToolsVisible : true,
			NavToolsVisible : true,
			CursorToolsVisible : true,
			SearchToolsVisible : true,
			localeChain : 'zh_CN'
		}
	});
</script>
</html>



















