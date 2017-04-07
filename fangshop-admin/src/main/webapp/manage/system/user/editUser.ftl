<#import "/manage/tpl/pageBase.ftl" as page> 
<@page.pageBase currentMenu="用户管理">
<style type="text/css">
	tr {
		padding:5px 0;
		height:45px;
	}
	.td-lable {
		text-align:right;
		width:30%;
		border-right:0;
		border-top:0;
		border-bottom:0;
	}
	.td-text {
		width:70%;
		padding-left:20px;
		border-left:0;
		border-top:0;
		border-bottom:0;
	}
	.input-group{
		width:80%;
	}
</style>
<table style="width:30%;margin-left:auto;margin-right:auto;border:1px solid #EBEBEB;">
    <thead>
    <tr>
        <th colspan=2 style="text-align:center;background-color:#DFF1D9;">账号编辑</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td class="td-lable">账号</td>
        <td class="td-text">
            <div class="input-group">
                <#if user.username??>
                    <input type="text" id="username" name="username" value="${user.username}" class="form-control"  aria-describedby="basic-addon1">
                <#else>
                    <input type="text" id="username" name="username" class="form-control"  aria-describedby="basic-addon1">
                </#if>
            </div>
        </td>
    </tr>
    <tr>
        <td class="td-lable">昵称</td>
        <td class="td-text">
            <div class="input-group">
                <input type="text" id="nickname" name="nickname" value="${user.nickname}" class="form-control"  aria-describedby="basic-addon1">
            </div>
        </td>
    </tr>
    <tr>
        <td class="td-lable">邮箱</td>
        <td class="td-text">
            <div class="input-group">
                <#if user.email??>
                    <input type="text" value="${user.email}" id="email" name="email" class="form-control"  aria-describedby="basic-addon1">
                <#else>
                    <input type="text" id="email" name="email" class="form-control"  aria-describedby="basic-addon1">
                </#if>
            </div>
        </td>
    </tr>
    <tr>
        <td class="td-lable">密码</td>
        <td class="td-text">
            <div class="input-group">
                <input id="input-pwd" type="password" placeholder="密码为空表示不修改密码" id="password" name="password" class="form-control"  aria-describedby="basic-addon1">
            </div>
        </td>
    </tr>
    <tr>
        <td class="td-lable">确认密码</td>
        <td class="td-text">
            <div class="input-group">
                <input id="confirmPwd" type="password" class="form-control"  aria-describedby="basic-addon1">
                <span id="tip-cfmPwd" style="color:red;display:none;">两次密码输入不一致</span>
            </div>
        </td>
    </tr>
    <tr>
        <td class="td-lable">选择角色</td>
        <td class="td-text">
            <select id="role" name="role" >
				<#list roles as role>
					<#if user.rid?? && role.id?string == user.rid?string>
                        <option value="${role.id}" selected="checked">${role.rolename}</option>
					<#else>
                        <option value="${role.id}">${role.rolename}</option>
					</#if>
				</#list>
            </select>
        </td>
    </tr>
    <tr>
        <td class="td-lable">状态</td>
        <td class="td-text">
            <select id="status" name="status">
                <option value="y" <#if !(user.status??) || user.status=="y"> selected="checked"</#if>>启用</option>
                <option value="n" <#if user.status?? && user.status="n"> selected="checked"</#if>>禁用</option>
            </select>
        </td>
    </tr>
    <tr>
        <td colspan=2 style="text-align:center;">
            <button type="submit" id="btnSave"  class="btn btn-success">保存</button>
        </td>
    </tr>
    </tbody>
</table>
<script type="text/javascript">
    $(function(){
        $("#btnSave").click(function(){
            save();
        })
    });
    function save(){
        var username = $("#username").val();
        if(!username)
        {
            alert("用户名不能为空！");
            return;
        }
        var nickname = $("#nickname").val();
        if(!nickname)
        {
            alert("昵称不能为空！");
            return;
        }
        var email = $("#email").val();
        var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
        if(!reg.test(email))
        {
            alert("邮箱不正确！");
            return;
        }
        var val = $(":password").val();
        var reg = /^[a-zA-Z0-9]{6,100}/;
        if(val && !reg.test(val)){
            $("#password").focus();
            alert("密码长度至少为6位数");
            return;
        }

        var data = "Random=" + encodeURI('${.now}');
        data = data + "&id=" + encodeURI(${user.id});
        data = data + "&username=" + encodeURI(username);
        data = data + "&nickname=" + encodeURI(nickname);
        data = data + "&email=" + encodeURI(email);
        data = data + "&password=" + encodeURI($(":password").val());
        data = data + "&rid=" + encodeURI($("#role").val());
        data = data + "&status=" + encodeURI($("#status").val());

        $.ajax({
            async : true,
            type : "POST",
            url : "${basepath}/manage/user/update",
            cache : false,
            timeout : 60 * 60 * 1000,
            dataType : "json",
            data : data,
            success : function(data) {
                if (data.message == "success") {
                    window.location.href = "${basepath}/manage/user/selectList";
                }
                else{
                    alert(data.message);
                }
            }
        });
    }
    $(function(){
        $("#confirmPwd").on('blur',function(){
            var pwd = $("#input-pwd").val().trim();
            var cfmPwd = $("#confirmPwd").val().trim();
            if(pwd!=cfmPwd){
                $("#tip-cfmPwd").show();
            }else{
                $("#tip-cfmPwd").hide();
            }
        });
    });
</script>
</@page.pageBase>