<#import "/manage/tpl/pageBase.ftl" as page> 
<@page.pageBase currentMenu="公告管理">
<script type="text/javascript" src="${basepath}/UEdit/ueditor.config.js"></script> 
<script type="text/javascript" src="${basepath}/UEdit/ueditor.all.js"></script> 
<script src="${basepath}/UEdit/lang/zh-cn/zh-cn.js" type="text/javascript"></script>
<link href="${basepath}/UEdit/themes/default/css/ueditor.css" rel="stylesheet" type="text/css" /> 
<div>
	<table class="table table-bordered" style="width: 100%; margin: auto;">
		<tr style="background-color: #1c94c4">
			<td colspan="2" style="background-color: #1c94c4; text-align: left;">
				<strong style="color: white;">新增文章</strong>
			</td>
		</tr>
		<tr>
			<td style="text-align: right;">类别</td>
			<td style="text-align: left;">
			    <select name="catalogid" id="catalogid">
			       <#list catalogs as catalog>
			         <option value="${catalog.id}">${catalog.name}</option>
                   </#list>
                </select>
			</td>
		</tr>
		<tr>
			<td style="text-align: right;width:5%">文章code</td>
			<td style="text-align: left;">
			  <input type="text" name="articlecode" size="50" maxlength="200" id="articlecode" class="form-control" style="width:50%"/>
			  <lable>（例如：[新手帮助]的编码为xsbz,或者输入别的字符,但必须唯一,最好不要使用中文）</lable>
			</td>
		<tr>
		<tr>
			<td style="text-align: right;width:5%">顺序</td>
			<td style="text-align: left;">
			  <input type="text" name="orderid" size="50" maxlength="200" id="orderid" class="form-control" style="width:50%"/>
			</td>
		<tr>
		<tr>
			<td style="text-align: right;width:5%">标题</td>
			<td style="text-align: left;">
			  <input type="text" name="titleid" size="50" maxlength="200" id="titleid" class="form-control" style="width:50%"/>
			</td>
		<tr>
			<td style="text-align: right;">是否显示</td>
			<td style="text-align: left;">
			    <select name="statusid" id="statusid">
                   	<option value="y" selected="selected">是</option>
                   	<option value="n">否</option>
                </select>
			</td>
		</tr>
		<tr>
		    <td style="text-align: right;">内容</td>
		    <td style="text-align: left;">
		    	<script id="editor" type="text/plain" style="width:100%;"></script>
		    </td>
		</tr>
		<tr>
			<td colspan="2" style="text-align: center;">
				<button class="btn btn-success" id="btnSave" name="btnSave">保存</button> 
			</td>
		</tr>
	</table>
</div>
<script type="text/plain" id="editor">
    //从数据库中取出文章内容打印到此处
</script>
<script type="text/javascript">
    var ue = null;
	$(function(){
        var ue = UE.getEditor('editor');  
		$("#btnSave").click(function(){
			save();
		})
	});
	function save(){
		var order1 = $("#orderid").val();
		if(!order1)
		{
			alert("顺序不能为空！");
		}
		var code = $("#articlecode").val();
		if(!code)
		{
			alert("文章code不能为空！")
		}
		var title = $("#titleid").val();
		if(!title)
		{
			alert("标题内容不能为空！");
			return;
		}
		var content = UE.getEditor('editor').getContentTxt();
		if(!content)
	    {
		    alert("内容不能为空！");	
		    return;
		}
	
		var data = "Random=" + encodeURI('${.now}');
		data = data + "&type=" + encodeURI("help");
		data = data + "&title=" + encodeURI(title);
		data = data + "&content=" + encodeURI(content);
		data = data + "&status=" + encodeURI($("#statusid").val());
		data = data + "&catalogid=" + encodeURI($("#catalogid").val());
		data = data + "&order1=" + encodeURI(order1);
		data = data + "&code=" + encodeURI(code);
		
		//查询
		$.ajax({
			async : true,
			type : "POST",
			url : "${basepath}/manage/news/insert",
			cache : false,
			timeout : 60 * 60 * 1000,
			dataType : "json",
			data : data,
			success : function(data) {
				if (data.message == "success") {
					window.location.href = "${basepath}/manage/news/selectList?type=help";
				}
				else{
					alert(data.message);
				}
			}
		});
	}
</script>
</@page.pageBase>
