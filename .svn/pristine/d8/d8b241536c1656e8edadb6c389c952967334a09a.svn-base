<#import "/manage/tpl/pageBase.ftl" as page> 
<#import "/manage/tpl/pager.ftl" as paging> 
<#import "/manage/tpl/renderDateSpan.ftl" as dataspan> 
<#import "/manage/tpl/loading.ftl" as load> 
<@page.pageBase currentMenu="订单管理">
<style>
	._account {
		min-width: 200px;
	}
	._accountaddress {
		min-width: 300px;
	}
    .mystyle{
        background-color:#1c94c4 !important;
    }
</style>
<div style="text-align: center;">
	<button class="btn btn-success" id="btnPass" name="btnPass">
		<i class="icon-arrow-up icon-white"></i> 审核
	</button>
	<button class="btn btn-success" id="btnSend" name="btnSend">
		<i class="icon-arrow-up icon-white"></i> 发货
	</button>
	<button class="btn btn-success" id="btnSign" name="btnSign">
		<i class="icon-arrow-up icon-white"></i> 签收
	</button>
	<button class="btn btn-success" id="btnFile" name="btnFile">
		<i class="icon-arrow-up icon-white"></i> 归档
	</button>
	<button class="btn btn-success" id="btnAddPay" name="btnAddPay" data-toggle="modal" 
  		 data-target="#orderPayModel">
		<i class="icon-arrow-up icon-white"></i> 添加支付记录
	</button>
	<button class="btn btn-success" id="btnOrder" name="btnOrder" data-toggle="modal" 
  		 data-target="#orderModel">
		<i class="icon-arrow-up icon-white"></i> 修改订单总金额
	</button>
	<button class="btn btn-success" id="btnCancel" name="btnCancel">
		<i class="icon-ok icon-white"></i> 取消订单
	</button>
</div>
<div id="tabs">
	<ul>
		<li><a href="#tabs-1">订单信息</a></li>
		<li><a href="#tabs-2">订单明细</a></li>
		<li><a href="#tabs-3">订单日志</a></li>
	</ul>
	<div id="tabs-1">
		<div>
			<div class="alert alert-info mystyle" style="margin-bottom:-18px">订单信息</div>
			<table id="orderId"></table>
			<input id="hidOrderId" type="hidden"/> 
		</div>
		<br/>
		<div>
			<div class="alert alert-info mystyle" style="margin-bottom:-18px">订单支付记录</div>
			<table id="orderPayId"></table>
		</div>
	</div>
	<div id="tabs-2">
		<table id="orderDetailId"></table>
	</div>
	<div id="tabs-3">
		<table id="orderLogId"></table>
	</div>
</div>
<!-- 模态框（Modal） -->
<div class="modal fade" id="orderPayModel" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
            <h4 class="modal-title" id="myModalLabel">
   				添加支付记录
            </h4>
         </div>
         <div class="modal-body">
 			<table style="border: 0;width:100%;">
				<tr style="height: 40px;">
				    <td style="width:20%"></td>
					<td style="width: 20%">支付方式:</td>
					<td>
						<select name="paymethod" id="paymethod">
							<option value="zfb">支付宝</option>
						</select>
					</td>
					<td style="width:20%"></td>
				</tr>
				<tr style="height: 40px;">
				    <td style="width:20%"></td>
					<td style="width: 20%">支付金额:</td>
					<td>
						<input name="payamount" id="payamount" style="width: 100%">
					</td>
					<td style="width:20%"></td>
				</tr>
				<tr style="height: 40px;">
					<td style="width:20%"></td>
					<td style="width: 20%">备注:</td>
					<td>
						<div class="controls"><input name="remark" id="txtremark" style="width: 100%"
						 value="后台添加"></div>
					</td>
					<td style="width:20%"></td>
				</tr>
			</table>
         </div>
         <div class="modal-footer">
            <button type="button" class="btn btn-primary" id="btnOrderPay" name="btnOrderPay">确定</button>
            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
         </div>
      </div><!-- /.modal-content -->
</div><!-- /.modal -->
</div>
<!-- 模态框（Modal） -->
<div class="modal fade" id="orderModel" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
            <h4 class="modal-title" id="myModalLabel">
   				修改订单总金额
            </h4>
         </div>
         <div class="modal-body">
 			<table style="border: 0;width:100%;">
				<tr style="height: 40px;">
				    <td style="width:20%"></td>
					<td style="width: 20%">支付金额:</td>
					<td>
						<input name="amount" id="amount" style="width: 100%">
					</td>
					<td style="width:20%"></td>
				</tr>
				<tr style="height: 40px;">
					<td style="width:20%"></td>
					<td style="width: 20%">备注:</td>
					<td>
						<div class="controls"><input name="updatePayMoneryRemark" id="updatePayMoneryRemark" placeholder="修改订单金额备注"
						style="width: 100%"></div>
					</td>
					<td style="width:20%"></td>
				</tr>
			</table>
         </div>
         <div class="modal-footer">
            <button type="button" class="btn btn-primary" id="btnOrderMoney" name="btnOrderMoney">确定</button>
            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
         </div>
      </div><!-- /.modal-content -->
</div><!-- /.modal -->
</div>
<script type="text/javascript">
	$(function() {
		$("#tabs").tabs();
		search();
		//初始化绑定事件
		bindEvent();
	})
	function bindEvent(){
		$("#btnPass").click(function(){
			if(confirm("确定要审核通过吗?")){
				setOrderState("pass");
			}
		});
		$("#btnSend").click(function(){
			if(confirm("确定要发货吗?")){
				setOrderState("send");
			}
		});
		$("#btnSign").click(function(){
			if(confirm("确定要签收吗?")){
				setOrderState("sign");
			}
		});
		$("#btnFile").click(function(){
			if(confirm("确定要归档吗?")){
				setOrderState("file");
			}
		});
		$("#btnCancel").click(function(){
			if(confirm("确定要取消订单吗?")){
				setOrderState("cancel");
			}
		});
		$("#btnOrderPay").click(function(){
			insertToOrderPay();
		});
		$("#btnOrderMoney").click(function(){
			updateOrderMoney();
		});
	}
	function setOrderState(state){
		var data = "Random=" + encodeURI('${.now}');
		data = data + "&id=" + encodeURI($("#hidOrderId").val());
		data = data + "&status=" + encodeURI(state);
		//查询
		$.ajax({
			async : true,
			type : "POST",
			url : "${basepath}/manage/order/updateOrderStatusById",
			cache : false,
			timeout : 60 * 60 * 1000,
			dataType : "json",
			data : data,
			success : function(data) {
				if (data.message == "success") {
					search();
				}
			}
		});
	}
	function search() {
		var data = "Random=" + encodeURI('${.now}');
		data = data + "&id=" + encodeURI('${id}');
		//查询
		$.ajax({
			async : true,
			type : "POST",
			url : "${basepath}/manage/order/searchById",
			cache : false,
			timeout : 60 * 60 * 1000,
			dataType : "json",
			data : data,
			success : function(data) {
				if (data != null && data.message == "success") {
					var array = [];
					array.push(data.rows);
					$("#hidOrderId").val(data.rows.id);
					//订单信息
					setOrder(array);
					//订单支付记录
					setOrderPay(data.rows.orderPays);
					//订单明细
					setOrderDetail(data.rows.orderDetails);
					//订单日志
					setOrderLog(data.rows.orderLogs);
				}
			}
		});
	}

	function setOrder(data) {
		$('#orderId').bootstrapTable('destroy').bootstrapTable({
			data : data,
			height : 300,
			search : false,
			showToggle : false,
			columns : [
					{
						field : 'id',
						title : '订单编号',
						align : 'center'
					},
					{
						field : 'quantity',
						title : '数量',
						align : 'center'
					},
					{
						field : 'createdate',
						title : '创建日期',
						align : 'center',
						formatter : function(value, row, index) {
							var date = new Date(value)
									.format("yyyy-MM-dd hh:mm:ss");
							return date;
						}
					},
					{
						field : 'status',
						title : '订单状态',
						align : 'center',
						formatter : function(value, row, index) {
							var state = "";
							switch (value) {
							case 'init':
								state = "<span style='color:red'>未审核</span>";
								$("#btnSend").attr("disabled","disabled");
								$("#btnSign").attr("disabled","disabled");
								$("#btnFile").attr("disabled","disabled");
								break;
							case 'pass':
								state = "<span style='color:red'>已审核</span>";
								$("#btnPass").attr("disabled","disabled");
								$("#btnSend").removeAttr("disabled");
								$("#btnSign").attr("disabled","disabled");
								$("#btnFile").attr("disabled","disabled");
								$("#btnAddPay").attr("disabled","disabled");
								$("#btnOrder").attr("disabled","disabled");
								$("#btnCancel").removeAttr("disabled");
								break;
							case 'send':
								state = "<span style='color:red'>已发货</span>";
								$("#btnPass").attr("disabled","disabled");
								$("#btnSend").attr("disabled","disabled");
								$("#btnSign").removeAttr("disabled");
								$("#btnFile").attr("disabled","disabled");
								$("#btnAddPay").attr("disabled","disabled");
								$("#btnOrder").attr("disabled","disabled");
								$("#btnCancel").attr("disabled","disabled");
								break;
							case 'sign':
								state = "<span style='color:red'>已签收</span>";
								$("#btnPass").attr("disabled","disabled");
								$("#btnSend").attr("disabled","disabled");
								$("#btnSign").attr("disabled","disabled");
								$("#btnFile").removeAttr("disabled");
								$("#btnAddPay").attr("disabled","disabled");
								$("#btnOrder").attr("disabled","disabled");
								$("#btnCancel").attr("disabled","disabled");
								break;
							case 'cancel':
								state = "<span style='color:red'>已取消</span>";
								$("#btnPass").attr("disabled","disabled");
								$("#btnSend").attr("disabled","disabled");
								$("#btnSign").attr("disabled","disabled");
								$("#btnFile").attr("disabled","disabled");
								$("#btnAddPay").attr("disabled","disabled");
								$("#btnOrder").attr("disabled","disabled");
								$("#btnCancel").attr("disabled","disabled");
								break;
							case 'file':
								state = "<span style='color:red'>已归档</span>";
								$("#btnPass").attr("disabled","disabled");
								$("#btnSend").attr("disabled","disabled");
								$("#btnSign").attr("disabled","disabled");
								$("#btnFile").attr("disabled","disabled");
								$("#btnAddPay").attr("disabled","disabled");
								$("#btnOrder").attr("disabled","disabled");
								$("#btnCancel").attr("disabled","disabled");
								break;
							}
							return state;
						}
					},
					{
						field : 'paystatus',
						title : '支付状态',
						align : 'center',
						formatter : function(value, row, index) {
							var state = "";
							switch (value) {
							case 'y':
								state = "<span style='color:red'>全部支付</span>";
								break;
							case 'n':
								state = "<span style='color:red'>未支付</span>";
								break;
							}
							return state;
						}
					},
					{
						field : 'amount',
						title : '订单总金额',
						align : 'center',
						formatter : function(value, row, index) {
							if (row.updateamount == "y") {
								value = "<span style='color:red'>"
										+ value + "【修】</span>";
							} else {
								value = "<span style='color:red'>"
										+ value + "</span>";
							}
							return value;
						}
					},
					{
						field : 'ptotal',
						title : '商品总金额',
						align : 'center'
					},
					{
						field : 'fee',
						title : '总配送费',
						align : 'center'
					},
					{
						class : '_account',
						field : '',
						title : '收货人信息',
						align : 'left',
						formatter : function(value, row, index) {
							value = "姓名：" + row.orderShip.shipname + "<br/>"
									+ "性别：" + (row.orderShip.sex==1?"男":"女") + "<br/>" 
									+ "手机：" + row.orderShip.phone + "<br/>" 
									+ "座机：" + row.orderShip.tel;
							return value;
						}
					},
					{
						class : '_accountaddress',
						field : '',
						title : '收货人地址',
						align : 'left',
						formatter : function(value, row, index) {
							value = "省份：" + row.orderShip.province + "<br/>"
									+ "城市：" + row.orderShip.city + "<br/>"
									+ "区域：" + (row.orderShip.area == null ? "" : row.orderShip.area) + "<br/>"
									+ "详细地址：" + (row.orderShip.shipaddress == null ? "" : row.orderShip.shipaddress)+ "<br/>"
									+ "邮编：" + row.orderShip.zip + "<br/>"
									+ "备注：" + ((row.orderShip.remark == null) ? "" : row.orderShip.remark) + "<br/>"; 
							if(row.status == 'init'){
								value = value + '<a class="btn btn-primary" href="${basepath}/manage/order/updateOrderShip?id=' + row.id + '">修改收货人配送信息</a>';
							}		
							return value;
						}
					},
					{
						class : '_account',
						field : '',
						title : '物流信息',
						align : 'left',
						formatter : function(value, row, index) {
							value = "配送方式：" + row.expressname + "<br/>" 
									+ "快递公司：" + (row.expresscompanyname==null?"":row.expresscompanyname) + "<br/>" 
									+ "快递运单号：" + (row.expressno==null?"":row.expressno) + "<br/>"
							if(row.status == 'init' || row.status=='pass'){
								value = value + '<a class="btn btn-primary" href="${basepath}/manage/order/getLogistics?id=' + row.id + '">修改物流信息</a>';
							}
									
							return value;
						}
					} ]
		});
	};
	function setOrderPay(data) {
		var num = 1;
		$('#orderPayId').bootstrapTable('destroy').bootstrapTable({
			data : data,
			height : 200,
			search : false,
			showToggle : false,
			columns : [ {
				field : '',
				title : '序号',
				align : 'center',
				formatter : function(value, row, index) {
					return num++;
				}
			}, {
				field : 'id',
				title : '商户订单号',
				align : 'center'
			}, {
				field : 'paymethod',
				title : '支付方式',
				align : 'center',
				formatter : function(value, row, index) {
					var state = "";
					switch (value) {
					case 'alipayescow':
					case 'zfb':
						state = "支付宝担保交易";
						break;
					default:
						state = "其他";
						break;
					}
					return state;
				}
			}, {
				field : 'payamount',
				title : '支付金额',
				align : 'center'
			}, {
				field : 'createtime',
				title : '支付时间',
				align : 'center'
			}, {
				field : 'paystatus',
				title : '支付状态',
				align : 'center',
				formatter : function(value, row, index) {
					var state = "";
					switch (value) {
					case 'y':
						state = "<span style='color:red'>支付成功</span>";
						break;
					case 'n':
						state = "<span style='color:red'>支付失败</span>";
						break;
					}
					return state;
				}
			}, {
				field : 'tradeno',
				title : '支付宝交易号',
				align : 'center'
			}, {
				field : 'remark',
				title : '备注',
				align : 'center'
			} ]
		});
	}
	function setOrderDetail(data) {
		var num = 1;
		$('#orderDetailId').bootstrapTable('destroy').bootstrapTable({
			data : data,
			search : false,
			showToggle : false,
			columns : [ {
				field : '',
				title : '序号',
				align : 'center',
				formatter : function(value, row, index) {
					return num++;
				}
			}, {
				field : 'productid',
				title : '商品编号',
				align : 'center'
			}, {
				field : 'productname',
				title : '商品名称',
				align : 'center'
			}, {
				field : 'specinfo',
				title : '购买的商品规格',
				align : 'center'
			}, {
				field : 'number',
				title : '数量',
				align : 'center'
			}, {
				field : 'price',
				title : '单价(￥)',
				align : 'center'
			}, {
				field : 'total0',
				title : '小计(￥)',
				align : 'center'
			} ]
		});
	};
	function setOrderLog(data) {
		var num = 1;
		$('#orderLogId').bootstrapTable('destroy').bootstrapTable({
			data : data,
			search : false,
			showToggle : false,
			columns : [ {
				field : '',
				title : '序号',
				align : 'center',
				formatter : function(value, row, index) {
					return num++;
				}
			}, {
				field : 'account',
				title : '操作人',
				align : 'center'
			}, {
				field : 'accounttype',
				title : '操作人类型',
				align : 'center',
				formatter : function(value, row, index) {
					var state = "";
					switch (value) {
						case 'w':
							state = "会员";
							break;
						case 'm':
							state = "后台管理人员";
							break;
						case 'p':
							state = "第三方支付系统异步通知";
							break;
					}
					return state;
				}
			}, {
				field : 'createdate',
				title : '时间',
				align : 'center',
				formatter : function(value, row, index) {
					var date = new Date(value).format("yyyy-MM-dd hh:mm:ss");
					return date;
				}
			}, {
				field : 'content',
				title : '日志',
				align : 'left'
			} ]
		});
	};
	//修改订单总金额
	function updateOrderMoney(){
		var value = /^\d+(\.\d+)?$/;
		if(!value.test($("#amount").val())){
			alert("请输入数字！");
			return;
		}
		$('#orderModel').modal('hide');
		var data = "Random=" + encodeURI('${.now}');
		data = data + "&id=" + encodeURI($("#hidOrderId").val());
		data = data + "&amount=" + encodeURI($("#amount").val());
		data = data + "&updateamount=y";
		data = data + "&remark=" + encodeURI($("#updatePayMoneryRemark").val());
		//查询
		$.ajax({
			async : true,
			type : "POST",
			url : "${basepath}/manage/order/updateOrderAmount",
			cache : false,
			timeout : 60 * 60 * 1000,
			dataType : "json",
			data : data,
			success : function(data) {
				if (data.message == "success") {
					search();
				}
				else{
					alert(data.message);
				}
			}
		});
	}
	//添加支付记录
	function insertToOrderPay(){
		var value = /^\d+(\.\d+)?$/;
		if(!value.test($("#payamount").val())){
			alert("请输入数字！");
			return;
		}
		$('#orderPayModel').modal('hide');
		var data = "Random=" + encodeURI('${.now}');
		data = data + "&orderid=" + encodeURI($("#hidOrderId").val());
		data = data + "&paymethod=" + encodeURI($("#paymethod").val());
		data = data + "&payamount=" + encodeURI($("#payamount").val());
		data = data + "&remark=" + encodeURI($("#txtremark").val());
		//查询
		$.ajax({
			async : true,
			type : "POST",
			url : "${basepath}/manage/order/insertOrderPay",
			cache : false,
			timeout : 60 * 60 * 1000,
			dataType : "json",
			data : data,
			success : function(data) {
				if (data.message == "success") {
					search();
				}else{
					alert(data.message);
				}
			}
		});
	}
</script>
</@page.pageBase>
