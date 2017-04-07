<#import "/manage/tpl/pageBase.ftl" as page> 
<#import "/manage/tpl/pager.ftl" as paging>
<#import "/manage/tpl/renderDateSpan.ftl" as dataspan>
<#import "/manage/tpl/loading.ftl" as load>
<@page.pageBase currentMenu="订单管理">
<style type="text/css">
    .adminTitles{width: 6%;}
    .adminTable{
    width:100%;
}
.adminContent
{
    height:40px;
}
.adminTitle{
    text-align: left;
    vertical-align: middle;
    white-space: nowrap;
}
.adminData{
    padding-right: 30px;
    width:15%;
}
</style>
<@load.loading></@load.loading>
<div class="panel panel-default">
	<div class="panel-heading">
		<h4 class="panel-title">
			<a data-toggle="collapse" data-parent="#accordion"
				href="#collapseOne"> 筛选 </a>
		</h4>
	</div>
	<div id="collapseOne" class="panel-collapse collapse in">
		<div class="panel-body">
			<table class="adminTable">
				<tr class="adminContent">
					<td class="adminTitle adminTitles">订单号：</td>
					<td class="adminData"><input type="text" name="id"
						class="form-control" id="orderId" /></td>
					<td class="adminTitle adminTitles">订单状态：					
					</td>
					<td class="adminData">
					   <select name="status" id="status" class="form-control">
					        <option value="" >全部</option>
							<option value="init" >未审核</option>
							<option value="pass" >已审核</option>
							<option value="send" >已发货</option>
							<option value="sign" >已签收</option>
							<option value="cancel" >已取消</option>
							<option value="file" >已归档</option>
						</select>
					</td>
					<td class="adminTitle adminTitles">用户账号：</td>
					<td class="adminData"><input type="text" name="account"
						id="account" class="form-control" /></td>
					<td class="adminTitle">支付状态：</td>
					<td class="adminData">
						<select name="paystatus" id="paystatus" class="form-control">
						    <option value="" >全部</option>
							<option value="y" >全部支付</option>
							<option value="n" >未支付</option>
						</select>
					</td>
					<td class="adminTitle">退款状态：</td>
					<td class="adminData" style="padding-right: 0px">
						<select name="refundstatus" id="refundstatus" class="form-control">
							<option value="" >全部</option>
							<option value="SELLER_REFUSE_BUYER">卖家不同意协议，等待买家修改</option>
							<option value="WAIT_SELLER_AGREE" >等待卖家同意退款</option>
							<option value="WAIT_BUYER_RETURN_GOODS" >卖家同意退款，等待买家退货</option>
							<option value="WAIT_SELLER_CONFIRM_GOODS" >买家已退货，等待卖家收到退货</option>
							<option value="REFUND_SUCCESS" >卖家收到退货，退款成功，交易关闭</option>
						</select>
					</td>
				</tr>
				<tr class="adminContent">
					<td class="adminTitle">时间范围：</td>
					<td class="adminData" colspan="2">
						<@dataspan.renderDataSpan></@dataspan.renderDataSpan>
					</td>
				</tr>
				<tr>
					<td colspan="10" style="text-align: right">
						<button type="button" id="btn-search" class="btn btn-success" onclick="search();">查询</button>
						<button type="button" id="btn-search" class="btn btn-success" onclick="exportExcel();">导出</button>
					</td>
				</tr>
			</table>
		</div>
	</div>
</div>
<div id="div-table">
 	<table id="table-orderList"></table>
 	<@paging.paging ></@paging.paging>
</div>
<div class="alert alert-info"
	style="text-align: left; font-size: 14px; margin: 2px 0px;">
	图标含义：<BR> 
	<img alt="未审核、未支付" src="${basepath}/resource/images/orders_add.gif">：未审核、未支付
	<img alt="已归档" src="${basepath}/resource/images/orders_complete.gif">：已归档
	<img alt="已取消" src="${basepath}/resource/images/orders_cancel.gif">：已取消
</div>
<script type="text/javascript">
$(function(){
    <#if (order.status)??>
       $('#status').val('${order.status}');
    </#if>
	<#if (order.paystatus)??>
	   $('#paystatus').val('${order.paystatus}');
	</#if>
	<#if (order.refundstatus)??>
	   $('#refundstatus').val('${order.refundstatus}');
	</#if>
	search();
});
function getCondition(isExport){
	var data = "Random=" + encodeURI('${.now}');
	data = data + "&id=" + encodeURI($('#orderId').val());
	data = data + "&status=" + encodeURI($('#status').val());
	data = data + "&account=" + encodeURI($('#account').val());
	data = data + "&paystatus=" + encodeURI($('#paystatus').val());
	data = data + "&refundstatus=" + encodeURI($('#refundstatus').val());
	data = data + "&startDate=" + encodeURI($("#dtBegin").val());
	data = data + "&endDate=" + encodeURI($("#dtEnd").val());
	if(!isExport){
		data = data + "&offset=" + encodeURI((parseInt($("#txtCurrentPage").val())-1)*parseInt($("#txtPageSize").val()));
	    data = data + "&pageSize=" + encodeURI($("#txtPageSize").val());
	}
    return data;
}
function exportExcel(){
	var data = getCondition(true);
	//查询
    $.ajax({
        async: true,
        type: "POST",
        url: "${basepath}/manage/order/exportExcel",
        cache: false,
        timeout: 60 * 60 * 1000,
        dataType: "json",
        data: data,
        success: function (data) {
            if (data != null && data.message == "success") {
               
            }
        }
    });
	//window.location = "http://" + window.location.host + '/fangshop/manage/order/exportExcel?' + data;
}
function search(){
		var data = getCondition(false);
	    //查询
        $.ajax({
            async: true,
            type: "POST",
            url: "${basepath}/manage/order/search",
            cache: false,
            timeout: 60 * 60 * 1000,
            dataType: "json",
            data: data,
            success: function (data) {
                if (data != null && data.message == "success") {
                    ResetSearch(data.rows.total);
                    SetTableData(data.rows.list);
                }
            }
        });
	}
   function SetTableData(rows) {
        $('#table-orderList').bootstrapTable('destroy').bootstrapTable({
            data: rows,
            height: 500,
            striped: true,
            search: true,
            pageSize: $('#txtPageSize').val(),
            showColumns: true,
            showToggle: true,
            minimumCountColumns: 4,
            columns: [{
                field: 'id',
                title: '订单号',
                align: 'center'
            }, {
                field: 'amount',
                title: '订单总金额',
                align: 'center',
                formatter:function(value,row,index){
                	if(row.updateamount=="y"){
                		value = value + "<span style='color:red'>【修】</span>";
                	}
                	return value;
                }
            }, {
                field: 'ptotal',
                title: '商品总金额',
                align: 'center'
            }, {
                field: 'fee',
                title: '配送费',
                align: 'center'
            },{
                field: 'quantity',
                title: '数量',
                align: 'center'
            }, {
                field: 'account',
                title: '会员',
                align: 'center'
            }, {
                field: 'createdate',
                title: '创建日期',
                align: 'center',
                formatter:function(value,row,index){
                	var date = new Date(value).format("yyyy-MM-dd hh:mm:ss");
                	return date;
                }
            }, {
                field: 'status',
                title: '订单状态',
                align: 'center',
                formatter:function(value,row,index){
                	var state = "";
                	switch(value)
                	{
	                	case 'init':
	                		state = '未审核<img alt="未审核" src="${basepath}/resource/images/action_add.gif">';;
	                		break;
	                	case 'pass':
	                		state = '已审核';
	                		break;
	                	case 'send':
	                		state = '已发货';
	                		break;
	                	case 'sign':
	                		state = '已签收';
	                		break;
	                	case 'cancel':
	                		state = '已取消<img alt="已取消" src="${basepath}/resource/images/action_delete.gif">';
	                		break;
	                	case 'file':
	                		state = '已归档<img alt="已归档" src="${basepath}/resource/images/action_check.gif">';
	                		break;
                	}
                	return state;
                }
            }, {
                field: 'paystatus',
                title: '支付状态',
                align: 'center',
                formatter:function(value,row,index){
                	var state = "";
                	switch(value)
                	{
	                	case 'y':
	                		state = '全部支付<img alt="全部支付" src="${basepath}/resource/images/action_check.gif">';
	                		break;
	                	case 'n':
	                		state = '未支付<img alt="未支付" src="${basepath}/resource/images/action_add.gif">';
	                		break;
                	}
                	return state;
                }
            }, {
                field: '',
                title: '操作',
                align: 'center',
                formatter:function(value,row,index){
                	var operate = "<a href='toEdit?id=" + row.id + "'>编辑</a>|<a>打印</a>"
                	return operate;
                }
            }]
        });
    }
</script>
<@paging.pagerJS></@paging.pagerJS>
</@page.pageBase>