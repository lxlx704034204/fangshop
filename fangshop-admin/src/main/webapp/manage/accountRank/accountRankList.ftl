<#import "/manage/tpl/pageBase.ftl" as page> <#import
"/manage/tpl/pager.ftl" as paging> <@page.pageBase currentMenu="等级管理">
<style type="text/css">
input[type=text] {
	border: 1px;
	border-style: solid;
	border-color: #CCCCCC;
	padding: 3px 5px 3px 5px;
	background-color: #FFFFFF;
}
</style>
<@paging.pagerJS></@paging.pagerJS>
<script type="text/javascript">
	$(function() {
		ResetSearch(0);
		search();
		//add();
	})

	function search() {
		var currentPage = parseInt($("#txtCurrentPage").val());
		var pageSize = parseInt($("#txtPageSize").val());
		var totalCount = parseInt($("#TotalCount").text());
		var offset = (currentPage - 1) * pageSize;
		//var status = $("#sel-status").val();
		$.ajax({
			url : '${basepath}/manage/accountRank/loadAccountRanktList',
			type : "POST",
			dataType : "json",
			data : {
				pageSize : pageSize,
				offset : offset
			},
			success : function(data) {
				for (var i = 0; i < data.list.length; i++) {
					data.list[i].scoreScope = data.list[i].minscore + "~"
							+ data.list[i].maxscore;
				}
				var resData = data.list;
				setTableData(resData);
				ResetSearch(data.total)
			}
		});
	}

	function add() {
		window.location.href = "${basepath}/manage/accountRank/addAccountRank";
	}

	function edit(id, code, name, minscore, maxscore, remark) {
		var params="id="+id+"&code="+code+"&name="+name+"&minscore="+minscore
				+"&maxscore="+maxscore+"&remark="+remark;
		window.location.href="${basepath}/manage/accountRank/addAccountRank?"+params;
	}

	function deleted(id) {
		window.location.href="${basepath}/manage/accountRank/delete?id="+id;
	}

	function setTableData(resData) {
		$('#table-accountList').bootstrapTable('destroy').bootstrapTable(
				{
					data : resData,
					striped : true,
					search : true,
					showColumns : true,
					columns : [
							{
								checkbox : true,
								filed : 'id',
								align : 'center'
							},
							{
								field : 'code',
								title : 'code',
								align : 'center'
							},
							{
								field : 'name',
								title : '等级名称',
								align : 'center'
							},
							{
								field : 'scoreScope',
								title : '积分范围',
								align : 'center'
							},
							{
								field : '',
								title : '操作',
								align : 'center',
								formatter : function(value, row, index) {
									return '<a href="#" onclick="edit(\''
											+ row.id + '\',\'' + row.code
											+ '\',\'' + row.name + '\',\''
											+ row.minscore + '\',\''
											+ row.maxscore + '\',\''
											+ row.remark + '\')">编辑</a>'
											+ ' | '
											+ '<a href="#" onclick="deleted(\''
											+ row.id + '\')">删除</a>'
								}
							}

					]
				})
	}
</script>
<div id="div-toolbar">
	<button type="button" id="btn-add" data-loading-text="Loading..."
		class="btn btn-success" autocomplete="off" onclick="add()">添加</button>
</div>
<hr />
<@paging.pagerJS></@paging.pagerJS>
<div id="div-table" style="">
	<table id="table-accountList"></table>
	<@paging.paging ></@paging.paging>
	<div></@page.pageBase>