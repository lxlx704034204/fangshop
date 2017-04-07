<#import "/manage/tpl/pageBase.ftl" as page> 
<#import "/manage/tpl/pager.ftl" as paging>
<#import "/manage/tpl/renderDateSpan.ftl" as dataspan>
<#import "/manage/tpl/loading.ftl" as load>
<@page.pageBase currentMenu="内容管理">
<style type="text/css">
    .adminTitles{width: 2%;}
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
    padding-right: 10px;
    width:15%;
}
</style>
<@load.loading></@load.loading>
<div class="panel panel-default">
	<div class="panel-heading">
		<h4 class="panel-title">
			<a data-toggle="collapse" data-parent="#accordion"
				href="#collapseOne">筛选</a>
		</h4>
	</div>
	<div id="collapseOne" class="panel-collapse collapse in">
		<div class="panel-body">
			<table class="adminTable">
				<tr class="adminContent">
					<td class="adminTitle adminTitles">标题：</td>
					<td class="adminData"><input type="text" name="titleid"
						class="form-control" id="titleid" /></td>
					<td class="adminTitle adminTitles">显示状态：					
					</td>
					<td class="adminData">
					   <select name="status" id="status" class="form-control">
					        <option value="" >全部</option>
							<option value="y" >是</option>
							<option value="n" >否</option>
						</select>
					</td>
					<td></td>
				</tr>
				<tr>
					<td colspan="10" style="text-align: right">
						<button type="button" id="btnSearch" class="btn btn-success">查询</button>
						<button type="button" id="btnAdd" class="btn btn-success">添加</button>
					</td>
				</tr>
			</table>
		</div>
	</div>
</div>
<div id="div-table">
 	<table id="tableList"></table>
 	<table id="newsList"></table>
 	<@paging.paging ></@paging.paging>
</div>
<div class="alert alert-info"
	style="text-align: left; font-size: 14px; margin: 2px 0px;">
	图标含义：<BR> 
	<img alt="已归档" src="${basepath}/resource/images/orders_complete.gif">：显示到门户上
	<img alt="已取消" src="${basepath}/resource/images/orders_cancel.gif">：不显示在门户上
</div>
<script type="text/javascript">
	$(function() {
		if('${news.type}'=='notice'){
			$('#tableList').show();
			$('#newsList').hide();
		} else if('${news.type}'=='help'){
			$('#tableList').hide();
			$('#newsList').show();	
		}
		
		$("#btnAdd").click(function() {
			add();
		});
		search();
	});
	function add() {
		window.location = "${basepath}/manage/news/create?type=${news.type}";
	};
	function search() {
		var data = "Random=" + encodeURI('${.now}');
		data = data + "&type=" + encodeURI('${news.type}');
		data = data + "&title=" + encodeURI($("#titleid").val());
		data = data + "&status=" + encodeURI($("#status").val());
		data = data + "&offset=" + encodeURI((parseInt($("#txtCurrentPage").val()) - 1) * parseInt($("#txtPageSize").val()));
		data = data + "&pageSize=" + encodeURI($("#txtPageSize").val());
		//查询
		$.ajax({
			async : true,
			type : "POST",
			url : "${basepath}/manage/news/search",
			cache : false,
			timeout : 60 * 60 * 1000,
			dataType : "json",
			data : data,
			success : function(data) {
				if (data != null && data.message == "success") {
					ResetSearch(data.rows.total);
					if('${news.type}'=='notice'){
						SetTableData(data.rows.list);
					} else if('${news.type}'=='help'){
						SetNewsTableData(data.rows.list);
					}
				}
			}
		});
	}
	function SetTableData(rows) {
		$('#tableList')
				.bootstrapTable('destroy')
				.bootstrapTable(
						{
							data : rows,
							height : 500,
							striped : true,
							search : true,
							pageSize : $('#txtPageSize').val(),
							showColumns : true,
							showToggle : true,
							minimumCountColumns : 4,
							columns : [
									{
										field : 'id',
										title : 'id',
										align : 'center'
									},
									{
										field : 'title',
										title : '标题',
										align : 'center'
									},
									{
										field : 'updatetime',
										title : '操作时间',
										align : 'center',
										formatter:function(value,row,index){
					                		return new Date(value).format("yyyy-MM-dd hh:mm:ss");
					                	}
									},
									{
										field : 'status',
										title : '显示状态',
										align : 'center',
										formatter : function(value, row, index) {
											var state = "";
											switch (value) {
											case 'y':
												state = '<img alt="" src="${basepath}/resource/images/action_check.gif">';
												;
												break;
											case 'n':
												state = '<img alt="" src="${basepath}/resource/images/action_delete.gif">';
												;
												break;
											}
											return state;
										}
									},
									{
										field : '',
										title : '操作',
										align : 'center',
										formatter : function(value, row, index) {
											var operate = "<a href='edit?id=" + row.id + "'>编辑</a>|"
													+ "<a onclick=del(" + row.id + ")>删除</a>";
											return operate;
										}
									} ]
			});
	}
	function SetNewsTableData(rows) {
		$('#newsList')
				.bootstrapTable('destroy')
				.bootstrapTable(
						{
							data : rows,
							height : 500,
							striped : true,
							search : true,
							pageSize : $('#txtPageSize').val(),
							showColumns : true,
							showToggle : true,
							minimumCountColumns : 4,
							columns : [
									{
										field : 'id',
										title : 'id',
										align : 'center'
									},
									{
										field : 'title',
										title : '标题',
										align : 'center'
									},
									{
										field : 'code',
										title : 'code',
										align : 'center'
									},
									{
										field : 'order1',
										title : '显示顺序',
										align : 'center'
									},
									{
										field : 'updatetime',
										title : '操作时间',
										align : 'center',
										formatter:function(value,row,index){
					                		return new Date(value).format("yyyy-MM-dd hh:mm:ss");
					                	}
									},
									{
										field : 'status',
										title : '显示状态',
										align : 'center',
										formatter : function(value, row, index) {
											var state = "";
											switch (value) {
											case 'y':
												state = '<img alt="" src="${basepath}/resource/images/action_check.gif">';
												;
												break;
											case 'n':
												state = '<img alt="" src="${basepath}/resource/images/action_delete.gif">';
												;
												break;
											}
											return state;
										}
									},
									{
										field : '',
										title : '操作',
										align : 'center',
										formatter : function(value, row, index) {
											var operate = "<a href='edit?id=" + row.id + "'>编辑</a>|"
													+ "<a onclick=del(" + row.id + ")>删除</a>";
											return operate;
										}
									} ]
			});
	}
	function del(id){
		if(window.confirm("确定要删除吗？")){
			var data = "Random=" + encodeURI('${.now}');
			data = data + "&id=" + encodeURI(id);
			//查询
			$.ajax({
				async : true,
				type : "POST",
				url : "${basepath}/manage/news/delete",
				cache : false,
				timeout : 60 * 60 * 1000,
				dataType : "json",
				data : data,
				success : function(data) {
					if (data != null && data.message == "success") {
						search();
					}
				}
			});
		}
	}
</script>
<@paging.pagerJS></@paging.pagerJS>
</@page.pageBase>