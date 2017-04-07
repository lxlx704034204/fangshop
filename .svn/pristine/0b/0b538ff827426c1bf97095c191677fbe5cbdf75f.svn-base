<#import "/manage/tpl/pageBase.ftl" as page> 
<#import "/manage/tpl/renderDateSpan.ftl" as dataspan>
<@page.pageBase currentMenu="广告管理">
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
				<strong style="color: white;">编辑广告</strong>
			</td>
		</tr>
		<tr>
			<td style="text-align: right;">类型</td>
			<td style="text-align: left;">
			    <select name="code" id="code">
                   	<option value="index_top" selected="selected">index_top</option>
                   	<option value="index_right_top">index_right_top</option>
                   	<option value="index_right_bottom">index_right_bottom</option>
                   	<option value="newslist_right_top">newslist_right_top</option>
                   	<option value="newslist_right_bottom">newslist_right_bottom</option>
                   	<option value="flashlist_right_top">flashlist_right_top</option>
                   	<option value="flashlist_right_bottom">flashlist_right_bottom</option>
                </select>
			</td>
		</tr>
		<tr>
			<td style="text-align: right;width:10%">标题</td>
			<td style="text-align: left;">
			  <input type="text" name="title" size="50" maxlength="200" id="title" class="form-control" style="width:50%"/>
			</td>
		<tr/>
		<tr>
			<td style="text-align: right;width:10%">备注</td>
			<td style="text-align: left;"> 
			  <input type="text" name="remark" size="50" maxlength="200" id="remark" class="form-control" style="width:50%"/>
			</td>
		<tr/>
		<tr>
			<td style="text-align: right;">状态</td>
			<td style="text-align: left;">
			    <select name="status" id="status">
                   	<option value="y" selected="selected">启用</option>
                   	<option value="n">禁用</option>
                </select>
			</td>
		</tr>
		<tr>
			<td style="text-align: right;">是否优先使用图集</td>
			<td style="text-align: left;">
			    <select name="useImagesRadom" id="useImagesRadom">
                   	<option value="y" selected="selected">是</option>
                   	<option value="n">否</option>
                </select>
			</td>
		</tr>
		<tr>
			<td style="text-align: right;">日期时间范围</td>
			<td style="text-align: left;">
			    <@dataspan.renderDataSpan></@dataspan.renderDataSpan>
			</td>
		</tr>
	    <tr>
			<td style="text-align: right;width:5%">内容</td>
			<td style="text-align: left;">
			  <script id="editor" type="text/plain" style="width:100%;"></script>
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
	var ue = null;
	$(function(){
	    var ue = UE.getEditor('editor');  
	    <#if (advert.code)??>
	       $('#code').val("${advert.code}");
	    </#if>
	    <#if (advert.title)??>
	       $('#title').val("${advert.title}");
	    </#if>
        <#if (advert.remark)??>
	       $('#remark').val("${advert.remark}");
	    </#if>
		<#if (advert.status)??>
	       $('#status').val('${advert.status}');
	    </#if> 
	    <#if (advert.useImagesRadom)??>
	       $('#useImagesRadom').val('${advert.useImagesRadom}');
	    </#if>
		<#if (advert.startdate)??>
	       $('#dtBegin').val('${advert.startdate?string("yyyy-MM-dd")}');
	    </#if>
	    <#if (advert.enddate)??>
	       $('#dtEnd').val('${advert.enddate?string("yyyy-MM-dd")}');
	    </#if>
		<#if (advert.html)??>
	        ue.addListener("ready", function () {
		        // editor准备好之后才可以使用
		        ue.setContent("<p>${advert.html}</p>");
	        });
	    </#if>
		$("#btnSave").click(function(){
			save();
		})
	});
	function save(){
		var title = $("#title").val();
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
		data = data + "&id=" + encodeURI('${advert.id}');
		data = data + "&code=" + encodeURI($("#code").val());
		data = data + "&title=" + encodeURI(title);
		data = data + "&remark=" + encodeURI($("#remark").val());
		data = data + "&status=" + encodeURI($("#status").val());
		data = data + "&useimagesrandom=" + encodeURI($("#useImagesRadom").val());
		data = data + "&startdate=" + encodeURI($("#dtBegin").val());
		data = data + "&enddate=" + encodeURI($("#dtEnd").val());
		data = data + "&html=" + encodeURI(content);
		
		//查询
		$.ajax({
			async : true,
			type : "POST",
			url : "${basepath}/manage/advert/update",
			cache : false,
			timeout : 60 * 60 * 1000,
			dataType : "json",
			data : data,
			success : function(data) {
				if (data.message == "success") {
					window.location.href = "${basepath}/manage/advert/selectList";
				}
				else{
					alert(data.message);
				}
			}
		});
	}
</script>
</@page.pageBase>
