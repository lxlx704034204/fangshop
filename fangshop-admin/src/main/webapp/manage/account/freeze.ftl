<#import "/manage/tpl/pageBase.ftl" as page> <@page.pageBase
currentMenu="会员管理">

<style>
.td-name {
	text-align: right;
}

.td-value {
	text-align: left;
}
</style>
<script type="text/javascript"
	src="${basepath}/resource/My97DatePicker/WdatePicker.js">
	
</script>

<form action="${basepath}/manage/account/freezeCommit">
	<table class="table table-bordered"
		style="width: 50%; margin: auto auto">
		<tr>
			<td colspan="2"
				style="background-color: #dff0d8; text-align: center;"><strong>冻结会员登陆账号</strong>
			</td>
		</tr>
		<tr style="display: none">
			<td>id</td>
			<td><input id="id" name="id" value="${account.id }" /></td>
		</tr>
		<tr>
			<td class="td-name">昵称</td>
			<td class="td-value">${account.nickname }</td>
		</tr>
		<tr>
			<td class="td-name">账号</td>
			<td class="td-value">${account.account }</td>
		</tr>
		<tr>
			<td class="td-name">是否冻结</td>
			<td class="td-value"><#assign map = {'y':'是','n':'否'}> <select
				id="freeze" name="freeze" class="input-medium"> <#list
					map?keys as key>
					<option value="${key}"<#if account.freeze?? &&
						account.freeze==key>selected="selected" </#if>>${map[key]}</option>
					</#list>
			</select>
			</td>
		</tr>
		<tr>
			<td class="td-name">冻结起止日期</td>
			<td class="td-value"><input id="d4311"
				value="${account.freezestartdate?date }"
				class="Wdate search-query input-small" type="text"
				name="freezestartdate"
				onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'d4312\')||\'2020-10-01\'}'})" />
				~ <input id="d4312" value="${account.freezeenddate?date }"
				class="Wdate search-query input-small" type="text"
				name="freezeenddate"
				onFocus="WdatePicker({minDate:'#F{$dp.$D(\'d4311\')}',maxDate:'2020-10-01'})" />
				(注：不填写时间范围将永久冻结此账号！)</td>
		</tr>
		<tr>
			<td colspan="2" style="text-align: center;">
				<button id="" cssClass="btn btn-primary">提交</button>
			</td>
		</tr>
	</table>
</form>

</@page.pageBase>

























