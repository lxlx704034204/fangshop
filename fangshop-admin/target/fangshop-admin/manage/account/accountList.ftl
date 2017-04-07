<#import "/manage/tpl/pageBase.ftl" as page> <#import
"/manage/tpl/pager.ftl" as paging> <@page.pageBase currentMenu="会员管理">
<@paging.pagerJS></@paging.pagerJS>
<@paging.pagerCSS></@paging.pagerCSS>

<style type="text/css">
tr {
	padding: 5px 0;
	height: 45px;
}

.td-border {
	border: 1px solid #C0C0C0;
	text-align: center;
	padding: 10px;
}

.td-lable {
	text-align: right;
	width: 30%;
	border: 1px solid"
}

.td-text {
	width: 70%;
	padding-left: 20px;
	border: 1px solid"
}
</style>
<script type="text/javascript"
	src="${basepath}/resource/My97DatePicker/WdatePicker.js">
	
</script>
<script type="text/javascript">
	$(function() {
		ResetSearch(0);
		search();
	})

	//数据查询
	function search() {
		var currentPage = parseInt($("#txtCurrentPage").val());
		var pageSize = parseInt($("#txtPageSize").val());
		var totalCount = parseInt($("#TotalCount").text());
		var offset = (currentPage - 1) * pageSize;
		var account = $("#account").val();
		var nickname = $("#nickname").val();
		var rank = $("#rank").val();
		var freeze = $("#freeze").val();
		var starttime = $("#d4311").val();
		var endtime = $("#d4312").val();
		var data = "";
		//data = data + "pageSize=" + pageSize;
		//data = data + "offset=" + offset;
		data = data + "account=" + account;
		data = data + "&nickname=" + nickname;
		data = data + "&freeze=" + freeze;
		data = data + "&rank=" + rank
		data = data + "&starttime=" + starttime;
		data = data + "&endtime=" + endtime;
		$.ajax({
			url : '${basepath}/manage/account/loadRankList',
			type : 'POST',
			dataType : 'json',
			data : data,
			success : function(data) {
				var resData = data.list;
				setTableData(resData);
				ResetSearch(data.total);
			}
		});
	}

	//查看
	function look(stringRow) {
		var jsonRow = eval("(" + stringRow.replace(/\*/g, "\"") + ")");
		var params = "accounttype=" + jsonRow.accounttype + "&nickname="
				+ jsonRow.nickname + "&account=" + jsonRow.account + "&city="
				+ jsonRow.city + "&address=" + jsonRow.address + "&amount="
				+ jsonRow.amount + "&tel=" + jsonRow.tel + "&email="
				+ jsonRow.email + "&freeze=" + jsonRow.freeze
				+ "&freezeenddate="
				+ new Date(jsonRow.freezeenddate).format('yyyy-MM-dd')
				+ "&freezestartdate="
				+ new Date(jsonRow.freezestartdate).format('yyyy-MM-dd')
				+ "&lastlogintime="
				+ new Date(jsonRow.lastlogintime).format('yyyy-MM-dd')
				+ "&lastloginip=" + jsonRow.lastloginip + "&lastloginarea="
				+ jsonRow.lastloginarea + "&regeistdate="
				+ new Date(jsonRow.regeistdate).format('yyyy-MM-dd')
				+ "&score=" + jsonRow.score + "&rank=" + jsonRow.rank;
		window.location.href = "${basepath}/manage/account/lookAccount?"
				+ params;
		//$.ajax({
		//url : '${basepath}/manage/account/lookAccount',
		//type : "POST",
		//dataType : "json",
		//data : jsonRow,
		//success : function(data) {

		//}
		//});

	}

	//冻结
	function freeze(id, account, nickname, freeze, freezestartdate,
			freezeenddate) {
		var params="id="+id+"&account="+account+"&nickname="+nickname+"&freeze="
		+freeze+"&freezestartdate="+(freezestartdate=='null'?'':freezestartdate)
		+"&freezeenddate="+(freezeenddate=='null'?'':freezeenddate);
		window.location.href = "${basepath}/manage/account/freezeAccount?"
			+ params;
	}

	//删除
	function deleted() {

	}

	function setTableData(resData) {
		$("#table-accountList")
				.bootstrapTable('destroy')
				.bootstrapTable(
						{
							data : resData,
							striped : true,
							showColumns : true,
							search : true,
							columns : [
									{
										checkbox : true,
										filed : 'id',
										align : 'center'

									},
									{
										field : 'accounttype',
										title : '登陆方式',
										align : 'center',
										formatter : function(value, row, index) {
											if (value == "sinawb") {
												return '<img src="${basepath}/resource/images/mini_sinaWeibo.png" />';
											} else if (value == "qq") {
												return '<img src="${basepath}/resource/images/mini_qqLogin.png" />';
											} else if (value == "alipay") {
												return '<span class="badge badge-warning">alipay</span>';
											} else {
												return '<span class="badge badge-warning">JSHOP</span>';
											}
										}
									},
									{
										field : 'account',
										title : '账号',
										align : 'center'
									},
									{
										field : 'nickname',
										title : '昵称',
										align : 'center'
									},
									{
										field : 'rank',
										title : '会员等级',
										align : 'center',
										formatter : function(value, row, index) {
											if (value == "R1") {
												return "普通会员";
											} else if (value == "R2") {
												return "铜牌会员";
											} else if (value == "R3") {
												return "银牌会员";
											} else if (value == R4) {
												return "金牌会员";
											} else if (value == R5) {
												return "钻石会员";
											}

										}
									},
									{
										field : 'email',
										title : '邮箱',
										align : 'center'
									},
									{
										field : 'regeistdate',
										title : '注册日期',
										align : 'center',
										formatter : function(value, row, index) {
											var date = new Date(value)
													.format("yyyy-MM-dd hh:mm:ss");
											return date;
										}
									},
									{
										field : 'lastlogintime',
										title : '最后登陆时间',
										align : 'center',
										formatter : function(value, row, index) {
											var date = new Date(value)
													.format("yyyy-MM-dd hh:mm:ss");
											return date;
										}
									},
									{
										field : 'lastloginip',
										title : '最后登陆IP',
										align : 'center'
									},
									{
										field : 'freeze',
										title : '是否冻结',
										align : 'center',
										formatter : function(value, row, index) {
											if (value == "y") {
												return '<img src="${basepath}/resource/images/login.gif" />';
											} else if (value == "n") {
												return '';
											} else {
												return '异常';
											}
										}
									},
									{
										field : '',
										title : '操作',
										align : 'center',
										formatter : function(value, row, index) {
											var stringRow = JSON.stringify(row)
													.replace(/\"/g, "*");

											return '<a href="#" onclick="look(\''
													+ stringRow
													+ '\')">查看</a>'
													+ ' | '
													+ '<a href="#" onclick="freeze(\''
													+ row.id
													+ '\',\''
													+ row.account
													+ '\',\''
													+ row.nickname
													+ '\',\''
													+ row.freeze
													+ '\',\''
													+new Date(row.freezestartdate).format('yyyy-MM-dd')
													//+ row.freezestartdate
													+ '\',\''
													+new Date(row.freezeenddate).format('yyyy-MM-dd')
													//+ row.freezeenddate
													+ '\')">冻结</a>'
											/* 
											+ ' | '
											+ '<a href="#" onclick="edit(\''
											+stringRow
											+ '\')">编辑</a>'+ ' | '
											+ ' | '
											+ '<a a href="#" onclick="deleted(\''
											+ row.id + '\')">删除</a>'; */

										}
									} ]
						})
	}
</script>
<!-- <form action="${basepath}/manage/account/search" method="post" theme="simple"> -->

<div class="table-responsive">
	<table style="">
		<tr>
			<td class="td-border">账号</td>
			<td class="td-border"><input name="account"
				class="search-query input-small" id="account" /></td>
			<td class="td-border">昵称</td>
			<td class="td-border"><input name="nickname" id="nickname"
				class="input-medium" /></td>
			<td class="td-border">会员等级</td>
			<td class="td-border"><#assign map =
				{'':'','R1':'普通会员','R2':'铜牌会员','R3':'银牌会员','R4':'金牌会员','R5':'钻石会员'}>
				<select id="rank" name="rank" class="input-medium"> <#list
					map?keys as key>
					<option value="${key}">${map[key]}</option> </#list>
			</select>
			</td>
			<td class="td-border">状态</td>
			<td class="td-border"><#assign map =
				{'':'','y':'已冻结','n':'未冻结'}> <select id="freeze" name="freeze"
				class="input-medium"> <#list map?keys as key>
					<option value="${key}">${map[key]}</option> </#list>
			</select>
			</td>
			<td class="td-border">注册日期</td>
			<td class="td-border"><input id="d4311"
				class="Wdate search-query input-medium" type="text" name="starttime"
				onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'d4312\')||\'2020-10-01\'}'})" />
				~ <input id="d4312" class="Wdate search-query input-medium"
				type="text" name="endtime"
				onFocus="WdatePicker({minDate:'#F{$dp.$D(\'d4311\')}',maxDate:'2020-10-01'})" />
			</td>

		</tr>
		<tr>
			<td colspan="10" style="text-align: left">
				<button id="btn-search" class="btn btn-success" onclick="search()">查询</button>
				<!--  <button id="btn-add" class="btn btn-success">新建</button>-->
			</td>
		</tr>
	</table>
</div>
<!-- </form> -->
<div>
	<table id="table-accountList">
	</table>
	<@paging.paging></@paging.paging>
</div>
</@page.pageBase>
