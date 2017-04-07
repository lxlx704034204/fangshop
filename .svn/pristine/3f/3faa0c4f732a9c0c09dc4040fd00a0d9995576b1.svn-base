<#import "/manage/tpl/pageBase.ftl" as page> 
<#import "/manage/tpl/pager.ftl" as paging>
<#import "/manage/tpl/renderDateSpan.ftl" as dataspan>
<#import "/manage/tpl/loading.ftl" as load>
<@page.pageBase currentMenu="广告管理">
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
    padding-right: 200px;
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
					<td class="adminTitle adminTitles">广告标题：</td>
					<td class="adminData"><input type="text" name="title"
						class="form-control" id="title" /></td>
					<td class="adminTitle adminTitles">类型：</td>
					<td class="adminData">
					   <select name="code" id="code" class="form-control">
					        <option value="" >全部</option>
							<option value="index_top" >index_top</option>
							<option value="index_right_top" >index_right_top</option>
							<option value="index_right_bottom" >index_right_bottom</option>
							<option value="newslist_right_top" >newslist_right_top</option>
							<option value="advert_login_page" >advert_login_page</option>
							<option value="advert_register_page" >advert_register_page</option>
						</select>
					</td>
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
		window.location = "${basepath}/manage/advert/create";
	};
	function search() {
		var data = "Random=" + encodeURI('${.now}');
		data = data + "&title=" + encodeURI($("#title").val());
		data = data + "&code=" + encodeURI($("#code").val());
		data = data + "&offset=" + encodeURI((parseInt($("#txtCurrentPage").val()) - 1) * parseInt($("#txtPageSize").val()));
		data = data + "&pageSize=" + encodeURI($("#txtPageSize").val());
		//查询
		$.ajax({
			async : true,
			type : "POST",
			url : "${basepath}/manage/advert/search",
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
										title : '广告标题',
										align : 'center'
									},
									{
										field : 'code',
										title : 'code',
										align : 'center'
									},
									{
										field : 'picture',
										title : '有效日期范围',
										align : 'center',
										formatter : function(value, row, index) {
										    var start = "";
										    var end = "";
										    if(row.startdate != null && row.startdate!='')
										    {
										      start = new Date(row.startdate).format("yyyy-MM-dd hh:mm:ss");
										    }
										    if(row.enddate != null && row.enddate!='')
										    {
										      end = new Date(row.enddate).format("yyyy-MM-dd hh:mm:ss");
										    }
											var date = start + "~" + end;
											return date;
										}
									},
									{
										field : 'status',
										title : '状态',
										align : 'center',
										formatter:function(value,row,index){
					                    	if(value=="y"){
					                    		return '<img src="${basepath}/resource/images/action_check.gif" />';
					                    	}else{
					                    		return '<img src="${basepath}/resource/images/action_delete.gif" />';
					                    	}
					                    }
									},
									{
										field : 'useimagesrandom',
										title : '图集优先',
										align : 'center',
										formatter:function(value,row,index){
					                    	if(value=="y"){
					                    		return '<img src="${basepath}/resource/images/action_check.gif" />';
					                    	}else{
					                    		return '<img src="${basepath}/resource/images/action_delete.gif" />';
					                    	}
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
				url : "${basepath}/manage/advert/delete",
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