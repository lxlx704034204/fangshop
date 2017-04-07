<#import "/manage/tpl/htmlBase.ftl" as html>
<@html.htmlBase title="登录" staticJsFiles=["manage/system/login.js"]>
<div style="margin-left:auto;margin-right:auto;width:20%;height:300px;margin-top:300px;">
	   <form action="${basepath}/manage/user/login" method="post">
	   		<br/>
	   		<div class="form-group">
                <#if errorMsg??>
                    <div class="alert alert-danger alert-dismissable" style="padding:6px;">
                       <button type="button" class="close" data-dismiss="alert"
                             aria-hidden="true" style="right:0px;">&times;</button>
                        ${errorMsg}
                    </div>
                </#if>
            </div>
	   		<div class="input-group" style="width:100%">
	  			<span class="input-group-addon" id="basic-addon1" style="width:30%;text-align:center;">用户名：</span>
	  			<input type="text" name="username" id="username" class="form-control" placeholder="username">
			</div>
			<br/>
			<div class="input-group" style="width:100%">
	  			<span class="input-group-addon" id="basic-addon1" style="width:30%;text-align:center;">密   码：</span>
	  			<input type="password" name="password" id="password" class="form-control" placeholder="password">
			</div>
			<br/>
			<div style="width:100%;text-align:right;">
				<input type="submit"  class="btn btn-default" value="登  录"/>
			</div>
   		</form>
</div>
</@html.htmlBase>