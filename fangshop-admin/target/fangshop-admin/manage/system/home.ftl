<#import "/manage/tpl/pageBase.ftl" as page> 
<@page.pageBase currentMenu="首页">
<style>
    .font-focus{
        font-weight: 700;font-size: 16px;color: #f50 !important;text-decoration: underline;
    }
    .mystyle{
        background-color:#1c94c4 !important;
    }
</style>
<div id="tabs">
	<ul>
		<li><a href="#tabs-1">关键数据</a></li>
		<li><a href="#tabs-2">基本设置</a></li>
	</ul>
	<div id="tabs-1">
		<div>
			<div class="alert alert-info mystyle" style="margin-bottom:4px">订单统计:</div>
			<table class="table table-bordered">
			   <tr>
			      <td>未付款订单数：<a class="font-focus" href="${basepath}/manage/order/selectList?init=y&paystatus=n">${ordersReport.nopayCount!}</a></td>
			      <td>已付款，但未审核订单数：<a class="font-focus" style="color: #f50;" href="${basepath}/manage/order/selectList?init=y&paystatus=y&status=init">${ordersReport.payNoAuditCount!}</a></td>
			   </tr>
			   <tr>
			      <td>已取消订单数：<a class="font-focus" href="${basepath}/manage/order/selectList?init=y&status=cancel">${ordersReport.payCancelCount!}</a></td>
			      <td>等待发货订单数：<a class="font-focus" style="color: #f50;" href="${basepath}/manage/order/selectList?init=y&paystatus=y&status=pass">${ordersReport.passCount!}</a></td>
			   </tr>
			</table>
		</div>
		<br/>
		<div>
			<div class="alert alert-info mystyle" style="margin-bottom:4px">退款订单统计:</div>
			<table class="table table-bordered">
			   <tr>
			      <td>【卖家需立即处理】退款协议等待卖家确认中：<a class="font-focus" href="${basepath}/manage/order/selectList?init=y&refundstatus=WAIT_SELLER_AGREE">${ordersReport.sellerAgreeCount!}</a></td>
			      <td>【卖家需立即处理】等待卖家收货：<a class="font-focus" style="color: #f50;" href="${basepath}/manage/order/selectList?init=y&refundstatus=WAIT_SELLER_CONFIRM_GOODS">${ordersReport.sellerConfirmGoodsCount!}</a></td>
			   </tr>
			   <tr>
			      <td>【等待买家处理完】卖家不同意协议，等待买家修改：<a class="font-focus" href="${basepath}/manage/order/selectList?init=y&refundstatus=SELLER_REFUSE_BUYER">${ordersReport.sellerRefuseCount!}</a></td>
			      <td>【等待买家处理完】退款协议达成，等待买家退货：<a class="font-focus" style="color: #f50;" href="${basepath}/manage/order/selectList?init=y&refundstatus=WAIT_BUYER_RETURN_GOODS">${ordersReport.buyerRefuseCount!}</a></td>
			   </tr>
			</table>
		</div>
		<br/>
		<div>
			<div class="alert alert-info mystyle" style="margin-bottom:4px">其他统计:</div>
			<table class="table table-bordered">
			   <tr>
			      <td>缺货商品数：<a class="font-focus" href="">${ordersReport.lowStocksCount!}</a></td>
			      <td>未回复评论数：：<a class="font-focus" style="color: #f50;" href="">${ordersReport.noreplyCount!}</a></td>
			   </tr>
			</table>
		</div>
	</div>
	<div id="tabs-2">
		<table class="table table-condensed">
			<tr>
				<td style="text-align: right;">系统版本:</td>
				<td style="text-align: left;">${systemSetting.version!}</td>
			</tr>
			<tr>
				<td style="text-align: right;">系统代号:</td>
				<td style="text-align: left;">${systemSetting.systemcode!}</td>
			</tr>
			<tr>
				<td style="text-align: right;">名称:</td>
				<td style="text-align: left;">${systemSetting.name! }</td>
			</tr>
			<tr>
				<td style="text-align: right;">简介:</td>
				<td style="text-align: left;">${systemSetting.www! }</td>
			</tr>
			<tr>
				<td style="text-align: right;">logo:</td>
				<td style="text-align: left;">${systemSetting.log! }</td>
			</tr>
			<tr>
				<td style="text-align: right;">网站标题:</td>
				<td style="text-align: left;">${systemSetting.title! }</td>
			</tr>
			<tr>
				<td style="text-align: right;">网站描述:</td>
				<td style="text-align: left;">
					${systemSetting.description!}</td>
			</tr>
			<tr>
				<td style="text-align: right;">关键词:</td>
				<td style="text-align: left;">${systemSetting.keywords!}
				</td>
			</tr>
			<tr>
				<td style="text-align: right;">shortcuticon:</td>
				<td style="text-align: left;">
					${systemSetting.shortcuticon!}</td>
			</tr>
			<tr>
				<td style="text-align: right;">联系地址:</td>
				<td style="text-align: left;">${systemSetting.address! }
				</td>
			</tr>
			<tr>
				<td style="text-align: right;">联系电话:</td>
				<td style="text-align: left;">${systemSetting.tel! }</td>
			</tr>
			<tr>
				<td style="text-align: right;">邮箱:</td>
				<td style="text-align: left;">${systemSetting.email! }</td>
			</tr>
			<tr>
				<td style="text-align: right;">备案号:</td>
				<td style="text-align: left;">${systemSetting.icp }</td>
			</tr>
			<tr>
				<td style="text-align: right;">是否开放网站:</td>
				<td style="text-align: left;"><input type="checkbox"
					disabled="disabled" checked="${systemSetting.isopen! }"
					value="${systemSetting.isopen! }" /></td>
			</tr>
			<tr>
				<td style="text-align: right;">关闭信息:</td>
				<td style="text-align: left;">${systemSetting.closemsg! }
				</td>
			</tr>
		</table>
	</div>
</div>
<script type="text/javascript">
$(function(){
	$("#tabs").tabs();
});
</script>
</@page.pageBase>