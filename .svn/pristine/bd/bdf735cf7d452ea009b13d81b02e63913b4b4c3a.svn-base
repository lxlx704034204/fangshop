<#import "/manage/tpl/pageBase.ftl" as page> 
<@page.pageBase currentMenu="支付管理">
<div>
	<table class="table table-bordered" style="width: 100%; margin: auto;">
		<tr style="background-color: #1c94c4">
			<td colspan="2" style="background-color: #1c94c4; text-align: left;">
				<strong style="color: white;">新增支付方式</strong>
			</td>
		</tr>
		<tr>
			<td style="text-align: right;">支付方式</td>
			<td style="text-align: left;">
			    <select name="code" id="code">
                   	<option value="alipay" selected="selected">支付宝</option>
                   	<option value="cft">财付通</option>
                   	<option value="yinlian">银联支付</option>
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
			<td style="text-align: right;">卖家账号</td>
			<td style="text-align: left;">
			   <input type="text" name="seller" id="seller" size="20" maxlength="20" style="width:20%" class="form-control"/>
			</td>
		</tr>
		<tr>
			<td style="text-align: right;">合作身份者ID</td>
			<td style="text-align: left;">
				<input type="text" name="partner" size="20" maxlength="20" id="partner" class="form-control" style="width:20%"/>
			</td> 
		</tr>
		<tr>
			<td style="text-align: right;">商户的私钥</td>
			<td style="text-align: left;">
				<input type="text" name="key" size="15" maxlength="15" id="key" class="form-control" style="width:20%"/>
			</td> 
		</tr>
		<tr>
			<td style="text-align: right;">顺序</td>
			<td style="text-align: left;">
			  <input type="text" name="order1" size="20" maxlength="20" id="order1" class="form-control" style="width:20%"/>
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
		$("#btnSave").click(function(){
			save();
		})
	});
	function save(){
		var reg = /^[a-zA-Z0-9]{5,10}/;
		if(!reg.test($("#seller").val())){
			$("#seller").focus();
			alert("卖家账号的长度至少为5~10位数");
			
			return;
		}
		reg = /^[a-zA-Z0-9]{10,20}/;
		if(!reg.test($("#partner").val())){
			$("#partner").focus();
			alert("合作身份者ID的长度至少为10~20位数");
			return;
		}
		reg = /^[a-zA-Z0-9]{10,15}/;
		if(!reg.test($("#key").val())){
			$("#key").focus();
			alert("商户的私钥的长度至少为10~15位数");
			return;
		}
		reg = /^[1-9]\d*$/;
		if(!reg.test($("#order1").val())){
			$("#order1").focus();
			alert("顺序必须为正整数");
			return;
		}
		
		var data = "Random=" + encodeURI('${.now}');
		data = data + "&name=" + encodeURI($("#code").find("option:selected").text());
		data = data + "&code=" + encodeURI($("#code").val());
		data = data + "&seller=" + encodeURI($("#seller").val());
		data = data + "&order1=" + encodeURI($("#order1").val());
		data = data + "&status=" + encodeURI($("#status").val());
		data = data + "&partner=" + encodeURI($("#partner").val());
		data = data + "&key1=" + encodeURI($("#key").val());
		
		//查询
		$.ajax({
			async : true,
			type : "POST",
			url : "${basepath}/manage/pay/insert",
			cache : false,
			timeout : 60 * 60 * 1000,
			dataType : "json",
			data : data,
			success : function(data) {
				if (data.message == "success") {
					window.location.href = "${basepath}/manage/pay/selectList";
				}
				else{
					alert(data.message);
				}
			}
		});
	}
</script>
</@page.pageBase>
