<#import "/manage/tpl/pageBase.ftl" as page>
<@page.pageBase currentMenu="修改密码">
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
<div>
    <table style="width:30%;margin-left:auto;margin-right:auto;border:1px solid #EBEBEB;">
        <thead>
        <tr>
            <th colspan=2 style="text-align:center;background-color:#DFF1D9;">修改密码</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td class="td-lable">旧密码</td>
            <td class="td-text">
                <div class="input-group">
                    <input id="input-pwd" type="password" id="oldpassword" name="oldpassword" class="form-control"  aria-describedby="basic-addon1">
                </div>
            </td>
        </tr>
        <tr>
            <td class="td-lable">密码</td>
            <td class="td-text">
                <div class="input-group">
                    <input id="input-pwd" type="password" name="input-pwd"" class="form-control"  aria-describedby="basic-addon1">
                </div>
            </td>
        </tr>
        <tr>
            <td class="td-lable">确认密码</td>
            <td class="td-text">
                <div class="input-group">
                    <input id="confirmPwd" type="password" name="confirmPwd" class="form-control"  aria-describedby="basic-addon1">
                    <span id="tip-cfmPwd" style="color:red;display:none;">两次密码输入不一致</span>
                </div>
            </td>
        </tr>

        <tr>
            <td colspan=2 style="text-align:center;">
                <button type="button" id="btnSave"  class="btn btn-success">确认修改</button>
            </td>
        </tr>
        </tbody>
    </table>
</div>
<script type="text/javascript">
    $(function(){
        $("#btnSave").click(function(){
            save();
        })
    });
    function save(){
        var arr =[];
        $("input[type=password]").each(function () {
            arr.push($(this).val());
        });
        if(arr[0]==null || arr[0]==""){
            alert("旧密码不能为空");
        }
        var reg = /^[a-zA-Z0-9]{6,100}/;
        if(!reg.test(arr[1])){
            $("#password").focus();
            alert("密码长度至少为6位数");
            return;
        }
        var data = "Random=" + encodeURI('${.now}');
        data = data + "&password=" + encodeURI(arr[1]);

        $.ajax({
            async : true,
            type : "POST",
            url : "${basepath}/manage/user/changePwd",
            cache : false,
            timeout : 60 * 60 * 1000,
            dataType : "json",
            data : data,
            success : function(data) {
                if (data.message == "success") {
                    alert("密码修改成功");
                }
                else{
                    alert(data.message);
                }
            }
        });
    }
    $(function(){
        $("#confirmPwd").on('blur',function(){
            var arr = new Array();
            $("input[type=password]").each(function () {
                arr.push($(this).val());
            });

            var pwd = arr[1];
            var cfmPwd = arr[2];
            if(pwd!=cfmPwd){
                $("#tip-cfmPwd").show();
            }else{
                $("#tip-cfmPwd").hide();
            }
        });
    });
</script>
</@page.pageBase>