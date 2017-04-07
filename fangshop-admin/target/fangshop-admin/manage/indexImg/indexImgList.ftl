<#import "/manage/tpl/pageBase.ftl" as page> 
<#import "/manage/tpl/pager.ftl" as paging>
<#import "/manage/tpl/renderDateSpan.ftl" as dataspan>
<#import "/manage/tpl/loading.ftl" as load>
<@page.pageBase currentMenu="门户滚动图片">
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
		window.location = "${basepath}/manage/indexImg/create";
	};
	function search() {
		var data = "Random=" + encodeURI('${.now}');
		data = data + "&title=" + encodeURI($("#name").val());
		data = data + "&offset=" + encodeURI((parseInt($("#txtCurrentPage").val()) - 1) * parseInt($("#txtPageSize").val()));
		data = data + "&pageSize=" + encodeURI($("#txtPageSize").val());
		//查询
		$.ajax({
			async : true,
			type : "POST",
			url : "${basepath}/manage/indexImg/search",
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
										field : 'title',
										title : '标题',
										align : 'center'
									},
									{
										field : 'picture',
										title : '图片',
										align : 'center',
										formatter : function(value, row, index) {
											var link = "<a href='http://localhost/cdn/" + row.picture + "' target='_blank'>"
											    	+ "<img style='max-width: 100px;max-height: 100px;' alt='无图片' src='http://localhost/cdn" + row.picture + "'></a>"
											    	+ "<br>"
											    	+ "<div>图片链接：</div>"
											    	+ "<a target='_blank' href='" + row.link + "'>" + row.link + "</a>";
											return link;
										}
									},
									{
										field : 'order1',
										title : '排序',
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
				url : "${basepath}/manage/indexImg/delete",
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