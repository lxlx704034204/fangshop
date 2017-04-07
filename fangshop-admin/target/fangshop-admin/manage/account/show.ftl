<#import "/manage/tpl/pageBase.ftl" as page> <@page.pageBase
currentMenu="会员管理">
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
<form action="">
	<div id="tabs">
		<ul>
			<li><a href="#tabs-1">基本信息</a></li>
		</ul>
		<div id="tabs-1">
		<div class="alert alert-info" style="margin-bottom:2px;text-align:left;">
			<strong>会员信息：</strong>
		</div>
			<table class="table table-bordered">
				<tr>
					<td class="td-lable">会员类型</td>
					<td class="td-text"><#if account.accounttype?? &&
						account.accounttype=="qq"> <span class="badge badge-warning">qq</span>
						<img alt="" src="${basepath}/resource/images/mini_qqLogin.png" />
						<#elseif account.accounttype?? && account.accounttype=="sinawb"> <span
						class="badge badge-warning">sinawb</span> <img alt=""
						src="${basepath}/resource/images/mini_sinaWeibo.png" /> <#elseif
						account.accounttype?? && account.accounttype=="alipay"> <span
						class="badge badge-warning">alipay</span> <img alt=""
						src="${basepath}/resource/images/alipay_fastlogin.jpg" /> <#else>
						<span class="badge badge-warning">JSHOP</span> </#if>
					</td>
				</tr>
				<tr>
					<td class="td-lable">昵称</td>
					<td class="td-text"><input id="nickname" name="nickname"
						value="${account.nickname }" /></td>
				</tr>
				<tr>
					<td class="td-lable">账号</td>
					<td class="td-text"><input id="account" name="account"
						value="${account.account }" /></td>
				</tr>
				<tr>
					<td class="td-lable">城市</td>
					<td class="td-text"><input id="city" name="city"
						value="${account.city }" /></td>
				</tr>
				<tr>
					<td class="td-lable">联系地址</td>
					<td class="td-text"><input id="address" name="address"
						value="${account.address }" /></td>
				</tr>
				<tr>
					<td class="td-lable">消费额</td>
					<td class="td-text"><input id="amount" name="amount"
						value="${account.amount }" /></td>
				</tr>
				<tr>
					<td class="td-lable">电话</td>
					<td class="td-text"><input id="tel" name="tel"
						value="${account.tel}" /></td>
				</tr>
				<tr>
					<td class="td-lable">Email地址</td>
					<td class="td-text"><input id="email" name="email"
						value="${account.email }" /> <#if account.emailIsActive?? &&
						account.emailIsActive=="y"><span class="badge badge-success">已激活</span>
						<#else><span class="badge badge-success">未激活</span> </#if></td>
				</tr>
				<tr>
					<td class="td-lable">是否冻结</td>
					<td class="td-text"><#if account.freeze?? &&
						account.freeze=="y"><span class="badge badge-important">已冻结(
							<#if
							!account.freezestartdate??&&!account.freezeenddate??>永久<#else>${account.freezestartdate?string('yyyy-MM-dd')}~${account.freezeenddate?string('yyyy-MM-dd') }</#if>)</span>
						<#else><span class="badge badge-success">未冻结</span></#if>
					</td>
				</tr>
				<tr>
					<td class="td-lable">最后登陆时间</td>
					<td class="td-text"><input id="lastlogintime"
						name="lastlogintime"
						value="${account.lastlogintime?string('yyyy-MM-dd')}" /></td>

				</tr>
				<tr>
					<td class="td-lable">最后登陆IP</td>
					<td class="td-text"><input id="lastloginip" name="lastloginip"
						value="${account.lastloginip}" /></td>
				</tr>
				<tr>
					<td class="td-lable">最后登陆位置</td>
					<td class="td-text"><input id="lastloginarea"
						name="lastloginarea" value="${account.lastloginarea }" /></td>
				</tr>
				<tr>
					<td class="td-lable">注册日期</td>
					<td class="td-text"><input id="regeistdate" name="regeistdate"
						value="${account.regeistdate?string('yyyy-MM-dd') }" /></td>
				</tr>
				<tr>
					<td class="td-lable">积分</td>
					<td class="td-text"><input id="score" name="score"
						value="${account.score }" /></td>
				</tr>
				<tr>
					<td class="td-lable">等级</td>
					<td class="td-text"><#if account.rank=="R1"><input id="rank"
						name="rank" value="普通会员" /> <#elseif account.rank=="R2"><input
						id="rank" name="rank" value="铜牌会员" /> <#elseif
						account.rank=="R3"><input id="rank" name="rank" value="银牌会员" />
						<#elseif account.rank=="R4"><input id="rank" name="rank"
						value="金牌会员" /> <#elseif account.rank=="R5"><input id="rank"
						name="rank" value="钻石会员" /></#if>
					</td>
				</tr>
			</table>
		</div>
	</div>
</form>
</@page.pageBase>

























