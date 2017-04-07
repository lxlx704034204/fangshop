<#import "/manage/tpl/pageBase.ftl" as page> 
<@page.pageBase currentMenu="门户滚动图片">
<script charset="utf-8" src="${staticpath}/bootstrap-fileinput-4.3.2/bootstrap-fileinput.js"?version="${version}"></script>
<script charset="utf-8" src="${staticpath}/bootstrap-fileinput-4.3.2/fileinput_locale_zh.js"?version="${version}"></script>
<link rel="stylesheet" href="${staticpath}/bootstrap-fileinput-4.3.2/fileinput.min.css"?version="${version}"/>
<script type="text/javascript" src="${basepath}/UEdit/ueditor.config.js"></script> 
<script type="text/javascript" src="${basepath}/UEdit/ueditor.all.js"></script> 
<script src="${basepath}/UEdit/lang/zh-cn/zh-cn.js" type="text/javascript"></script>
<link href="${basepath}/UEdit/themes/default/css/ueditor.css" rel="stylesheet" type="text/css" /> 
<style>
.file-input{width:600px}
</style>
<div>
	<table class="table table-bordered" style="width: 100%; margin: auto;">
		<tr style="background-color: #1c94c4">
			<td colspan="2" style="background-color: #1c94c4; text-align: left;">
				<strong style="color: white;">新增门户图片</strong>
			</td>
		</tr>
		<tr>
			<td style="text-align: right;width:10%">标题</td>
			<td style="text-align: left;">
			  <input type="text" name="title" size="50" maxlength="200" id="title" class="form-control" style="width:50%"/>
			</td>
		<tr>
			<td style="text-align: right;">图片地址</td>
			<td style="text-align: left;">
				<input id="input-file" name="inputFile" maxlength="200" type="file" class="file" style="width:50%">
			</td>
		</tr>
		<tr>
			<td style="text-align: right;">广告链接</td>
			<td style="text-align: left;">
			    <input type="text" name="link" size="50" maxlength="200" id="link" class="form-control" style="width:50%"/>
			</td>
		</tr>
		<tr>
			<td style="text-align: right;width:5%">顺序</td>
			<td style="text-align: left;">
			  <input type="text" name="orderid" size="50" maxlength="200" id="orderid" class="form-control" style="width:50%"/>
			</td>
		<tr>
	    <tr>
			<td style="text-align: right;width:5%">描述</td>
			<td style="text-align: left;">
			  <input type="text" name="description" size="50" maxlength="200" id="description" class="form-control" style="width:50%"/>
			</td>
		<tr>
		<tr>
			<td colspan="2" style="text-align: center;">
				<button class="btn btn-success" id="btnSave" name="btnSave">保存</button> 
			</td>
		</tr>
	</table>
</div>
<script type="text/javascript">
	$(function(){
		$("#input-file").fileinput({ 
			language:'zh',
			showPreview:false,
			showUpload: false,
			allowedFileExtensions:['jpg', 'png','gif'],
			uploadUrl:'${basepath}/manage/indexImg/uploadImg'
		});
		$("#btnSave").click(function(){
			save();
		})
	});
	function getFileName(o){
	    var pos=o.lastIndexOf("\\");
	    return o.substring(pos+1);  
	}
	function save(){
		var title = $("#title").val();
		if(!title)
		{
			alert("标题内容不能为空！");
			return;
		}
		var link = $("#link").val();
		if(!link)
		{
			alert("广告链接不能为空！");
			return;
		}
		var reg = /^[a-zA-Z0-9]{1,10}/;
		if(!reg.test($("#orderid").val())){
			$("#orderid").focus();
			alert("顺序必须是1~10位的整数！");
			return;
		}
		var desc1 = $("#description").val();
		if(!desc1)
		{
			alert("描述不能为空！");
			return;
		}
	
		var data = "Random=" + encodeURI('${.now}');
		data = data + "&title=" + encodeURI(title);
		data = data + "&link=" + encodeURI(link);
		data = data + "&order1=" + encodeURI($("#orderid").val());
		data = data + "&desc1=" + encodeURI(desc1);
		
		//查询
		$.ajax({
			async : true,
			type : "POST",
			url : "${basepath}/manage/indexImg/insert",
			cache : false,
			timeout : 60 * 60 * 1000,
			dataType : "json",
			data : data,
			success : function(data) {
				if (data.message == "success") {
					$('#input-file').fileinput('upload');
					window.location.href = "${basepath}/manage/indexImg/selectList";
				}
				else{
					alert(data.message);
				}
			}
		});
	}
</script>
</@page.pageBase>
