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
				<strong style="color: white;">编辑公告</strong>
			</td>
		</tr>
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
				<button class="btn btn-success" id="btnEdit" name="btnEdit">编辑</button> 
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
        <#if (news.title)??>
	       $('#titleid').val("${news.title}");
	    </#if>
		<#if (news.status)??>
	       $('#statusid').val('${news.status}');
	    </#if>
		<#if (news.content)??>
	        ue.addListener("ready", function () {
		        // editor准备好之后才可以使用
		        ue.setContent("<p>${news.content}</p>");
	        });
	    </#if>
		
		$("#btnEdit").click(function(){
			update();
		})
	});
	function update(){
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
		data = data + "&id=" + encodeURI('${news.id}');
		data = data + "&type=" + encodeURI("notice");
		data = data + "&title=" + encodeURI(title);
		data = data + "&content=" + encodeURI(content);
		data = data + "&status=" + encodeURI($("#statusid").val());
		
		//查询
		$.ajax({
			async : true,
			type : "POST",
			url : "${basepath}/manage/news/update",
			cache : false,
			timeout : 60 * 60 * 1000,
			dataType : "json",
			data : data,
			success : function(data) {
				if (data.message == "success") {
					window.location.href = "${basepath}/manage/news/selectList?type=notice";
				}
				else{
					alert(data.message);
				}
			}
		});
	}
</script>
</@page.pageBase>
