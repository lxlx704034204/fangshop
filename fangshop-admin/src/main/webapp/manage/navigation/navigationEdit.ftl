<#import "/manage/tpl/pageBase.ftl" as page> 
<@page.pageBase currentMenu="友情链接">
<div>
	<table class="table table-bordered" style="width: 100%; margin: auto;">
		<tr style="background-color: #1c94c4">
			<td colspan="2" style="background-color: #1c94c4; text-align: left;">
				<strong style="color: white;">编辑导航菜单</strong>
			</td>
		</tr>
		<tr>
			<td style="text-align: right;width:10%">名称</td>
			<td style="text-align: left;">
			  <input type="text" name="name" size="50" maxlength="200" id="name" class="form-control" style="width:50%"/>
			</td>
		<tr>
			<td style="text-align: right;">打开方式</td>
			<td style="text-align: left;">
			    <label id="target" name="target">_blank</label>
			</td>
		</tr>
		<tr>
			<td style="text-align: right;">位置</td>
			<td style="text-align: left;">
			    <label id="position" name="position">bottom</label>
			</td>
		</tr>
		<tr>
			<td style="text-align: right;width:5%">顺序</td>
			<td style="text-align: left;">
			  <input type="text" name="orderid" size="50" maxlength="200" id="orderid" class="form-control" style="width:50%"/>
			</td>
		<tr>
	    <tr>
			<td style="text-align: right;width:5%">地址</td>
			<td style="text-align: left;">
			  <input type="text" name="address" size="50" maxlength="200" id="address" class="form-control" style="width:50%"/>
			  <label>(输入的地址不带http://)</label>
			</td>
		<tr>
		<tr>
			<td colspan="2" style="text-align: center;">
				<button class="btn btn-success" id="btnSave" name="btnSave">修改</button> 
				<button class="btn btn-success" id="btnCancel" name="btnCancel">取消</button>
			</td>
		</tr>
	</table>
</div>
<script type="text/javascript">
	$(function(){
	    <#if (navigation.name)??>
	       $('#name').val('${navigation.name}');
	    </#if>
	    <#if (navigation.order1)??>
	       $('#orderid').val('${navigation.order1}');
	    </#if>
	    <#if (navigation.http)??>
	       $('#address').val('${navigation.http}');
	    </#if>
		$("#btnSave").click(function(){
			save();
		})
		$("#btnCancel").click(function(){
			window.location.href = "${basepath}/manage/navigation/selectList";
		})
	});
	function validatehttp(){
		var flag = false;
		var data = "Random=" + encodeURI('${.now}');
		data = data + "&address=" + encodeURI($("#address").val());
		//查询
		$.ajax({
			async : false,
			type : "POST",
			url : "${basepath}/manage/navigation/isExistAddress",
			cache : false,
			timeout : 60 * 60 * 1000,
			dataType : "json",
			data : data,
			success : function(data) {
				if (data.message == "success") {
					flag=true;
				}
			}
		});
		return flag;
	};
	function save(){
		var name = $("#name").val();
		if(!name)
		{
			alert("标题内容不能为空！");
			return;
		}
		var reg = /^[a-zA-Z0-9]{1,10}/;
		if(!reg.test($("#orderid").val())){
			$("#orderid").focus();
			alert("顺序必须是1~10位的整数！");
			return;
		}
		var address = $("#address").val();
		if(!address)
		{
			alert("地址不能为空！");
			return;
		}
		
		var flag = validatehttp();
		if(flag)
		{
			alert("地址重复！");
			return;
		}
	
		var data = "Random=" + encodeURI('${.now}');
		data = data + "&id=" + encodeURI('${navigation.id}');
		data = data + "&name=" + encodeURI(name);
		data = data + "&target=" + encodeURI($('#target').text());
		data = data + "&position=" + encodeURI($('#position').text());
		data = data + "&order1=" + encodeURI($("#orderid").val());
		data = data + "&http=" + encodeURI(address);
		
		//查询
		$.ajax({
			async : true,
			type : "POST",
			url : "${basepath}/manage/navigation/update",
			cache : false,
			timeout : 60 * 60 * 1000,
			dataType : "json",
			data : data,
			success : function(data) {
				if (data.message == "success") {
					window.location.href = "${basepath}/manage/navigation/selectList";
				}
				else{
					alert(data.message);
				}
			}
		});
	}
</script>
</@page.pageBase>
