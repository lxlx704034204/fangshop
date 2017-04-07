<#import "/manage/tpl/pageBase.ftl" as page> 
<#import "/manage/tpl/pager.ftl" as paging>
<#import "/manage/tpl/renderDateSpan.ftl" as dataspan>
<#import "/manage/tpl/loading.ftl" as load>
<@page.pageBase currentMenu="评论插件管理">
<style type="text/css">

</style>
<@load.loading></@load.loading>
<div class="panel panel-default">
	<div class="panel-heading">
		<h4 class="panel-title">
			<a data-toggle="collapse" data-parent="#accordion"
				href="#collapseOne"> 操作 </a>
		</h4>
	</div>
	<div id="collapseOne" class="panel-collapse collapse in">
		<div class="panel-body">
			<button type="button" id="btnSearch" class="btn btn-success">查询</button>
		</div>
	</div>
</div>
<div id="div-table">
 	<table id="table-commentTypeList"></table>
 	<@paging.paging ></@paging.paging>
</div>
<script type="text/javascript">
	$(function() {
	
		search();
	});
	function search() {
		var data = "Random=" + encodeURI('${.now}');
		data = data + "&offset=" + encodeURI((parseInt($("#txtCurrentPage").val()) - 1) * parseInt($("#txtPageSize").val()));
		data = data + "&pageSize=" + encodeURI($("#txtPageSize").val());
		//查询
		$.ajax({
			async : true,
			type : "POST",
			url : "${basepath}/manage/commentType/search",
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
		$('#table-commentTypeList').bootstrapTable('destroy').bootstrapTable(
						{
							data : rows,
							height : 650,
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
										align : 'center'
									},
									{
										field : 'code',
										title : '代码',
										align : 'center'
									},
									{
										field : 'status',
										title : '状态',
										align : 'center',
										formatter : function(value, row, index) {
											var state = "";
											switch (value) {
											case 'y':
												state = '<img alt="启用" src="${basepath}/resource/images/action_check.gif">';
												;
												break;
											case 'n':
												state = '<img alt="禁用" src="${basepath}/resource/images/action_delete.gif">';
												;
												break;
											}
											return state;
										}
									}]
			});
	}
</script>
<@paging.pagerJS></@paging.pagerJS>
</@page.pageBase>