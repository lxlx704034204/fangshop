<#import "/manage/tpl/pageBase.ftl" as page> 
<#import "/manage/tpl/pager.ftl" as paging>
<#import "/manage/tpl/renderDateSpan.ftl" as dataspan>
<#import "/manage/tpl/loading.ftl" as load>
<@page.pageBase currentMenu="友情链接">
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
					<td class="adminTitle adminTitles">名称：</td>
					<td class="adminData"><input type="text" name="name"
						class="form-control" id="name" /></td>
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
 	<@paging.paging ></@paging.paging>
</div>
<script type="text/javascript">
	$(function() {
		
		$("#btnAdd").click(function() {
			add();
		});
		search();
	});
	function add() {
		window.location = "${basepath}/manage/navigation/create";
	};
	function search() {
		var data = "Random=" + encodeURI('${.now}');
		data = data + "&name=" + encodeURI($("#name").val());
		data = data + "&offset=" + encodeURI((parseInt($("#txtCurrentPage").val()) - 1) * parseInt($("#txtPageSize").val()));
		data = data + "&pageSize=" + encodeURI($("#txtPageSize").val());
		//查询
		$.ajax({
			async : true,
			type : "POST",
			url : "${basepath}/manage/navigation/search",
			cache : false,
			timeout : 60 * 60 * 1000,
			dataType : "json",
			data : data,
			success : function(data) {
				if (data != null && data.message == "success") {
					ResetSearch(data.rows.total);
					SetTableData(data.rows.list);
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
										field : 'name',
										title : '名称',
										align : 'center',
										formatter : function(value, row, index) {
											var link = "<a href='http://" + row.http + "' target='_blank'>" + row.name + "</a>"
											return link;
										}
									},
									{
										field : 'http',
										title : '链接',
										align : 'center'
									},
									{
										field : 'target',
										title : '打开方式',
										align : 'center'
									},
									{
										field : 'position',
										title : '位置',
										align : 'center'
									},
									{
										field : 'order1',
										title : '顺序',
										align : 'center'
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
				url : "${basepath}/manage/navigation/delete",
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