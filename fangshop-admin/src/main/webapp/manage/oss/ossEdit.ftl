<#import "/manage/tpl/pageBase.ftl" as page> 
<@page.pageBase currentMenu="存储插件管理">
<div>
	<table class="table table-bordered" style="width: 100%; margin: auto;">
		<tr style="background-color: #1c94c4">
			<td colspan="2" style="background-color: #1c94c4; text-align: left;">
				<strong style="color: white;">修改插件</strong>
			</td>
		</tr>
		<tr>
			<td style="text-align: right;">存储插件</td>
			<td style="text-align: left;">
			    <select name="code" id="code">
                   	<option value="aliyun" selected="selected">阿里云存储</option>
                </select>
			</td>
		</tr>
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
			<td style="text-align: right;">存储信息</td>
			<td style="text-align: left;">
			  <input type="text" name="ossJsonInfo" size="50" maxlength="50" id="ossJsonInfo" class="form-control" style="width:50%"/>
			</td>
		</tr>
		<tr>
			<td colspan="2" style="text-align: center;">
				<button class="btn btn-success" id="btnSave" name="btnSave">保存</button> 
			</td>
		</tr>
	</table>
</div>
<script type="text/javascript">
	$(function(){
		<#if (oss.code)??>
	       $('#code').val('${oss.code}');
	    </#if>
		<#if (oss.status)??>
	       $('#status').val('${oss.status}');
	    </#if>
		<#if (oss.ossjsoninfo)??>
	       $('#ossJsonInfo').val('${oss.ossjsoninfo}');
	    </#if>
		$("#btnSave").click(function(){
			update();
		})
	});
	function update(){
		var reg = /^[a-zA-Z0-9]{5,10}/;
		if(!reg.test($("#ossJsonInfo").val())){
			$("#ossJsonInfo").focus();
			alert("存储信息的长度至少为5~10位数");
			
			return;
		}
		
		var data = "Random=" + encodeURI('${.now}');
		data = data + "&id=" + encodeURI(${oss.id});
		data = data + "&name=" + encodeURI($("#code").find("option:selected").text());
		data = data + "&code=" + encodeURI($("#code").val());
		data = data + "&status=" + encodeURI($("#status").val());
		data = data + "&ossjsoninfo=" + encodeURI($("#ossJsonInfo").val());
		
		//查询
		$.ajax({
			async : true,
			type : "POST",
			url : "${basepath}/manage/oss/update",
			cache : false,
			timeout : 60 * 60 * 1000,
			dataType : "json",
			data : data,
			success : function(data) {
				if (data.message == "success") {
					window.location.href = "${basepath}/manage/oss/selectList";
				}
				else{
					alert(data.message);
				}
			}
		});
	}
</script>
</@page.pageBase>
