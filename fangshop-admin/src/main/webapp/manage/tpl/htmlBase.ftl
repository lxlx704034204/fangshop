<#macro htmlBase title="" jsFiles=[] cssFiles=[] staticJsFiles=[] staticCssFiles=[] checkLogin=true>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-Type" content="text/html; charset=UTF-8">
<title>${title}</title>
<script type="text/javascript">
	var basepath = "${basepath}";
	var staticpath = "${staticpath}";
</script>
<style type="text/css">
	.slpager {
    border: 1px;
    border-style: solid;
    border-color: #D4D0C8;
    padding-top: 3px;
    padding-bottom: 3px;
    padding-left: 10px;
    background-color: #EAE8E4;
}
</style>
<#--JQuery-->
<script type="text/javascript" src="${staticpath}/js/jquery-2.2.3.min.js"?version="${version}"></script>

<#--JQuery UI-->
<link rel="stylesheet" href="${staticpath}/jquery-ui-1.11.2/jquery-ui.css"?version="${version}">
<script src="${staticpath}/jquery-ui-1.11.2/jquery-ui.js"?version="${version}"></script>

<#--validator-->
<link rel="stylesheet" href="${staticpath}/validator-0.7.0/jquery.validator.css"?version="${version}" />
<script type="text/javascript" src="${staticpath}/validator-0.7.0/jquery.validator.js?version="${version}"></script>
<script type="text/javascript" src="${staticpath}/validator-0.7.0/local/zh_CN.js?version="${version}"></script>
<#--My97DatePicker-->
<#--<script type="text/javascript" src="${staticpath}/My97DatePicker/WdatePicker.js"?version="${version}"></script>-->

<#--bootstrap-->
<link rel="stylesheet" href="${staticpath}/bootstrap-3.3.5/css/bootstrap.min.css"?version="${version}"  type="text/css">
<script type="text/javascript" src="${staticpath}/bootstrap-3.3.5/js/bootstrap.min.js"?version="${version}"></script>
<#--bootstrap    table-->
<link rel="stylesheet" href="${staticpath}/bootstrap-table/bootstrap-table.min.css" ?version="${version}"/>
<script charset="utf-8" src="${staticpath}/bootstrap-table/bootstrap-table.js"?version="${version}"></script>
<link rel="stylesheet" href="${staticpath}/bootstrap-table/bootstrap-table-doublehead.css"?version="${version}" />
<script charset="utf-8" src="${staticpath}/bootstrap-table/bootstrap-table-doublehead.js"?version="${version}"></script>
<script charset="utf-8" src="${staticpath}/bootstrap-table/bootstrap-table-zh-CN.js"?version="${version}"></script>
<#--ztree-->
<link rel="stylesheet" href="${staticpath}/zTree_v3/css/zTreeStyle/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="${staticpath}/zTree_v3/js/jquery.ztree.all.min.js"></script>
<script type="text/javascript" src="${staticpath}/zTree_v3/js/jquery.ztree.core.min.js"></script>
<script type="text/javascript" src="${staticpath}/zTree_v3/js/jquery.ztree.excheck.min.js"></script>
<script type="text/javascript" src="${staticpath}/zTree_v3/js/jquery.ztree.exedit.min.js"></script>
<#--sb admin -->
<link rel="stylesheet" href="${staticpath}/sb-admin/css/sb-admin-2.css"?version="${version}" />
<script src="${staticpath}/sb-admin/js/sb-admin-2.js"?version="${version}" ></script>
<link href="${staticpath}/font-awesome/css/font-awesome.min.css"?version="${version}" rel="stylesheet" type="text/css">
<#--metisMenu -->
<link href="${staticpath}/metisMenu/metisMenu.min.css"?version="${version}" rel="stylesheet">
<script src="${staticpath}/metisMenu/metisMenu.min.js"?version="${version}"></script>
<#--添加  css 文件-->
<#list cssFiles as cssFile>
	<link rel="stylesheet" href="${staticpath}/${cssFile}"?version="${version}" />
</#list>
<#list staticCssFiles as staticCssFile>
	<link rel="stylesheet" href="${basepath}/${staticCssFile}"?version="${version}"/>
</#list>
<link ref="stylesheet" href="${staticpath}/css/base.css"?version="${version}"/>
<#--添加  js 文件-->
<#list jsFiles as jsFile>
	<script charset="utf-8" src="${staticpath}/${jsFile}"?version="${version}"></script>
</#list>
<#list staticJsFiles as staticJsFile>
	<script charset="utf-8" src="${basepath}/${staticJsFile}"?version="${version}"></script>
</#list>
<script charset="utf-8" src="${staticpath}/js/calendar2.js"?version="${version}"></script>
<script src="${staticpath}/js/common.js"?version="${version}"></script>
<script src="${staticpath}/highcharts/highcharts.js"?version="${version}"></script>
</head>
<body>
	<#nested>
</body>
</html>
</#macro>