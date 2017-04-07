<#import "/manage/tpl/pageBase.ftl" as page> <@page.pageBase
currentMenu="等级管理">
<style type="text/css">
tr {
	padding: 5px 0;
	height: 45px;
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

.input-group {
	width: 80%;
}
</style>

<form action="${basepath}/manage/accountRank/save" method="POST">
	<table style="margin: auto auto; border: 1px solid #EBEBEB">
		<thead>
			<tr>
				<th colspan="2"
					style="text-align: center; background-color: #DFF1D9;">会员等级编辑</th>
			</tr>
		</thead>
		<tbody>
			<tr style="display:none">
				<td ><#if accountRank.id??><input name="id"
					value="${accountRank.id}"> </#if>
				</td>
			</tr>
			<tr>
				<td class="td-lable">code</td>
				<td class="td-text"><#if accountRank.code??> <input name="code"
					value="${accountRank.code}" /><#else> <input name="code" />
					</#if>
				</td>
			</tr>
			<tr>
				<td class="td-lable">等级名称</td>
				<td class="td-text"><#if accountRank.name??> <input name="name"
					value="${accountRank.name}" /><#else> <input name="name" />
					</#if>
				</td>

			</tr>
			<tr>
				<td class="td-lable">最小积分</td>
				<td class="td-text"><#if accountRank.minscore??> <input
					name="minscore" value="${accountRank.minscore }" /><#else> <input
					name="minscore" /> </#if>
				</td>
			</tr>
			<tr>
				<td class="td-lable">最大积分</td>
				<td class="td-text"><#if accountRank.maxscore??> <input
					name="maxscore" value="${accountRank.maxscore }" /> <#else> <input
					name="maxscore" /> </#if>
				</td>
			</tr>
			<tr>
				<td class="td-lable">备注</td>
				<td class="td-text"><#if accountRank.remark??> <input
					name="remark" value="${accountRank.maxscore }" /> <#else> <input
					name="remark" /> </#if>
				</td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: center;">
					<button type="submit" id="btn-add" class="btn btn-success">保存</button>
				</td>
			</tr>
		</tbody>
	</table>
</form>
</@page.pageBase>
