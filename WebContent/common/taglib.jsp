<%@taglib prefix="s" uri="/struts-tags"%>

<%
	// 上下文路径
	String path = request.getContextPath();
	// 工程绝对路径
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	// 工程发布绝对路径
	String proPath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path;
	String savePath = basePath + "jsp/pic/";
%>
<!-- 引入bootstrap-3.3.4-dist -->
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<link href="<%=basePath%>resource/bootstrap-3.3.4/dist/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="<%=basePath %>resource/plugin/zTree/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="<%=basePath%>resource/jquery/jquery-1.11.1.js"></script>
<script type="text/javascript" src="<%=basePath %>resource/plugin/zTree/jquery.ztree.all-3.5.min.js"></script>
<script type="text/javascript" src="<%=basePath %>resource/plugin/zTree/jquery.ztree.core-3.5.min.js"></script>
<script type="text/javascript" src="<%=basePath %>resource/plugin/zTree/jquery.ztree.excheck-3.5.min.js"></script>
<script type="text/javascript" src="<%=basePath %>resource/plugin/zTree/jquery.ztree.exedit-3.5.js"></script>
<script type="text/javascript" src="<%=basePath%>resource/bootstrap-3.3.4/dist/js/bootstrap.js"></script>
<script type="text/javascript" src="<%=basePath%>resource/bootstrap-3.3.4/js/collapse.js"></script>
<script type="text/javascript" src="<%=basePath %>resource/plugin/My97DatePicker/WdatePicker.js"></script>
