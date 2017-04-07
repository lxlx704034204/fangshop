<#import "/manage/tpl/pageBase.ftl" as page> 
<#import "/manage/tpl/pager.ftl" as paging>
<#import "/manage/tpl/renderDateSpan.ftl" as dataspan>
<#import "/manage/tpl/loading.ftl" as load>
<@page.pageBase currentMenu="订单管理">
<style>
    .mystyle{
        background-color:#1c94c4 !important;
    }
</style>
<div>
	<div class="alert alert-info mystyle" style="margin-bottom: 2px;text-align: left;">
        <strong>确认发货</strong>
    </div>
    <table class="table table-bordered">
        <tr>
            <th nowrap="nowrap" width="150px">物流方式</th>
            <td nowrap="nowrap">
                <select name="WIDtransport_type" id="WIDtransport_type" onchange="changeFunc(this)">
                    <option value="EXPRESS">快递</option>
                    <option value="POST">平邮</option>
                </select>
            </td>
        </tr>
        <tr id="companyTR">
            <th nowrap="nowrap">物流公司名称</th>
            <th nowrap="nowrap">
                <select name="expressCompanyName" id="expressCompanyName">
                   	<option value="shunfeng">顺风快递</option>
                   	<option value="ems">EMS</option>
                   	<option value="shentong">申通E物流</option>
                   	<option value="yuantong">圆通速递</option>
                   	<option value="zhongtong">中通速递</option>
                   	<option value="zhaijisong">宅急送</option>
                   	<option value="yunda">韵达快运</option>
                   	<option value="tiantian">天天快递</option>
                   	<option value="lianbangkuaidi">联邦快递</option>
                   	<option value="huitongkuaidi">汇通快运</option>
                </select>
            </th>
        </tr>
        <tr>
            <th nowrap="nowrap">运单号</th>
            <th nowrap="nowrap">
                <input name="expressNo" id="expressNo" class="form-control" data-rule="运单号:required;WIDinvoice_no;length[1~20];" maxlength="20" size="20"/>
            </th>
        </tr>
        <tr>
            <th nowrap="nowrap" colspan="2" style="text-align: center;">
                <input type="button" class="btn btn-success" value="确认发货" onclick="sendProduct();"/>
                <input type="button" class="btn btn-success" value="返回" onclick="javascript:history.go(-1);"/>
            </th>
        </tr>
    </table>
    <div class="alert alert-info"
		style="text-align: left; font-size: 14px; margin: 2px 0px;">
		快递：发货10天后，若对方没有确认收货，交易结束，金额自动进入您的账户。
		      <BR>平邮：发货30天后，若对方没有确认收货，交易结束，金额自动进入您的账户。    
	</div>
</div>
<script type="text/javascript">
	function changeFunc(obj) {
		var selectVal = $(obj).val();
		$("#companyTR").show();
		if ("EXPRESS" == selectVal || "no" == selectVal) {
			if ("no" == selectVal) {
				$("#companyTR").hide();
			} else {
				$("#expressCompanyName").show();
			}
		} else if ("POST" == selectVal) {
			$("#expressCompanyName").hide();
		}
	}
	function sendProduct() {
		if ($("#expressNo").val() == '') {
			alert("运单号不能为空！");
			$("#expressNo").focus();
			return false;
		}
		var data = "Random=" + encodeURI('${.now}');
		data = data + "&id=" + encodeURI('${id}');
		data = data + "&expresscode=" + encodeURI($('#WIDtransport_type').val());
		data = data + "&expressname=" + encodeURI($('#WIDtransport_type').find("option:selected").text());
		data = data + "&expressno=" + encodeURI($('#expressNo').val());
		if($('#WIDtransport_type').val()=='EXPRESS'){
			data = data + "&expresscompanyname=" + encodeURI($("#expressCompanyName").val());
		}
		$.ajax({
			async : true,
			type : "POST",
			url : "${basepath}/manage/order/sendOrder",
			cache : false,
			timeout : 60 * 60 * 1000,
			dataType : "json",
			data : data,
			success : function(data) {
				if (data != null && data.message == "success") {
					window.location.href = "${basepath}/manage/order/toEdit?id=${id}";
				}
				else{
					alert(data.message);
				}
			}
		});
	}
</script>
</@page.pageBase>