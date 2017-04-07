<#import "/manage/tpl/pageBase.ftl" as page> 
<@page.pageBase currentMenu="订单管理">
<style>
    .mystyle{
        background-color:#1c94c4 !important;
    }
</style>
<div>
	<div class="alert alert-info mystyle" style="margin-bottom: 2px; text-align: left;">修改订单配送地址信息</div>
	<table class="table table-bordered">
		<tr>
			<td width="100px">收货人姓名</td>
			<td>
				<input name="shipname" type="text" class="form-control"
				value="${orderShip.shipname}" id="shipname"
				data-rule="收货人姓名:required;length[2~8];name;" placeholder="请输入收货人姓名" />
			</td>
		</tr>
		<tr>
			<td>地址区域</td>
			<td>
				<select onchange="changeProvince()" name="provinceSelect" id="provinceSelect" class="form-control"  style="width: auto; display: inline-block;">
				    <#if !(orderShip.provincecode)??> 
				      <option value="">--选择省份--</option> 
				    </#if>
					<#list areas as item>
					   <#if item.layer==0>
					       <option value="${item.code}" 
					   		   <#if (orderShip.provincecode)?? && item.code==orderShip.provincecode>
					   		      selected='selected'
					   		   </#if>>
					   		   ${item.name}
					       </option>
					   </#if>
					</#list>
				</select> 
				<select onchange="changeCity()" id="citySelect" name="citySelect"  class="form-control"  style="width: auto; display: inline-block;">
					<#if !(orderShip.citycode)??>
					   <option value="">--选择城市--</option>
					</#if>
					<#list areas as item>
					   <#if item.layer==1>
					       <option value="${item.code}"  
					   		   <#if (orderShip.citycode)?? && item.code==orderShip.citycode>
					   		      selected='selected'
					   		   </#if>>
					   		   ${item.name}
					       </option>
					   </#if>
					</#list>
				</select> 
				<select id="areaSelect" name="areaSelect"  class="form-control" style="width: auto; display: inline-block;">
					<#if !(orderShip.areacode)??>
					   <option value="">--选择区域--</option>
					</#if>
					<#list areas as item>
					   <#if item.layer==2>
					       <option value="${item.code}"    
					   		   <#if (orderShip.areacode)?? && item.code==orderShip.areacode>
					   		      selected='selected'
					   		   </#if>>
					   		   ${item.name}
					       </option>
					   </#if>
					</#list>
				</select>
			</td>
		</tr>
		<tr>
			<td>详细地址</td>
			<td><textarea class="form-control" name="address"
					type="text" id="address"
					data-rule="地址:required;length[0~70];address;"
					placeholder="请输入收货人地址">${orderShip.shipaddress}</textarea>
			</td>
		</tr>
		<tr>
			<td>邮编</td>
			<td><input name="zip" type="text" class="form-control"
				value="${orderShip.zip}" id="zip"
				data-rule="邮编:required;length[0~70];zip;" placeholder="请输入收货人邮编" />
			</td>
		</tr>
		<tr>
			<td>手机</td>
			<td><input name="phone" type="text" class="form-control"
				value="${orderShip.phone}" id="phone"
				data-rule="手机:required;length[0~70];mobile;" placeholder="请输入收货人手机" />
			</td>
		</tr>
		<tr>
			<td>电话号码</td>
			<td><input name="tel" type="text" class="form-control"
				value="${orderShip.tel}" id="tel"
				data-rule="电话号码:required;length[0~70];phone;"
				placeholder="请输入收货人座机号码" /></td>
		</tr>
		<tr>
			<td colspan="2" style="text-align: center;">
				<button id="btnSave" class="btn btn-success" value="保存">
					<span class="glyphicon glyphicon-ok"></span>确认修改
				</button> 
				<input type="button" value="返回" class="btn btn-success"
				onclick="javascript:history.go(-1);" />
			</td>
		</tr>
	</table>
</div>
<script type="text/javascript">
    $(function(){
    	$("#btnSave").click(function(){
    		save();
    	});
    });
	//选择省份 
	function changeProvince(){
		$("#citySelect").empty().show().append("<option value=''>--选择城市--</option>");
		$("#areaSelect").empty().hide().append("<option value=''>--选择区域--</option>");
		
		var data = "Random=" + encodeURI('${.now}');
		data = data + "&code=" + encodeURI($("#provinceSelect").val());
		//查询
		$.ajax({
			async : true,
			type : "POST",
			url : "${basepath}/manage/order/selectArea",
			cache : false,
			timeout : 60 * 60 * 1000,
			dataType : "json",
			data : data,
			success : function(data) {
				if (data.message == "success") {
					$.each(data.rows,function(index,value){
						$("#citySelect").append("<option value='"+value.code+"'>"+ value.name + "</option>");
					});
				}
			}
		});
	};
	//选择城市
	function changeCity(){
		$("#areaSelect").empty().show().append("<option value=''>--选择区域--</option>");
		
		var data = "Random=" + encodeURI('${.now}');
		data = data + "&code=" + encodeURI($("#citySelect").val());
		//查询
		$.ajax({
			async : true,
			type : "POST",
			url : "${basepath}/manage/order/selectArea",
			cache : false,
			timeout : 60 * 60 * 1000,
			dataType : "json",
			data : data,
			success : function(data) {
				if (data.message == "success") {
					$.each(data.rows,function(index,value){
						$("#areaSelect").append("<option value='"+value.code+"'>"+ value.name + "</option>");
					});
				}
			}
		});
	};
	//保存
	function save(){
		var data = "Random=" + encodeURI('${.now}');
		data = data + "&id=" + encodeURI(${orderShip.id});
		data = data + "&orderid=" + encodeURI(${orderShip.orderid});
		data = data + "&shipname=" + encodeURI($("#shipname").val());
		data = data + "&shipaddress=" + encodeURI($("#address").val());
		data = data + "&provincecode=" + encodeURI($("#provinceSelect").val());
		data = data + "&province=" + encodeURI($("#provinceSelect").find("option:selected").text());
		data = data + "&citycode=" + encodeURI($("#citySelect").val());
		data = data + "&city=" + encodeURI($("#citySelect").find("option:selected").text());
		data = data + "&areacode=" + encodeURI($("#areaSelect").val());
		data = data + "&area=" + encodeURI($("#areaSelect").find("option:selected").text());
		data = data + "&phone=" + encodeURI($("#phone").val());
		data = data + "&tel=" + encodeURI($("#tel").val());
		data = data + "&zip=" + encodeURI($("#zip").val());
		data = data + "&sex=" + encodeURI(${orderShip.sex});
		data = data + "&remark=" + encodeURI('${orderShip.remark!""}');

		$.ajax({
			async : true,
			type : "POST",
			url : "${basepath}/manage/order/updateOrderShip",
			cache : false,
			timeout : 60 * 60 * 1000,
			dataType : "json",
			data : data,
			success : function(data) {
				if (data.message == "success") {
					window.location.href = "${basepath}/manage/order/toEdit?id=" + data.rows;
				}
				else
				{
					alert(data.message);
				}
			}
		});
	};
</script>
</@page.pageBase>