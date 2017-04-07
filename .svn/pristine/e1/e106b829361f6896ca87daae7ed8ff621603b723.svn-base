<#import "/manage/tpl/pageBase.ftl" as page>
<@page.pageBase currentMenu="配送方式">
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
            <th colspan=2 style="text-align:center;background-color:#DFF1D9;">新增</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td class="td-lable">编码：</td>
            <td class="td-text">
                <div class="input-group">
                    <input type="text" id="code" name="code" class="form-control"  aria-describedby="basic-addon1">
                </div>
            </td>
        </tr>
        <tr>
            <td class="td-lable">名称：</td>
            <td class="td-text">
                <div class="input-group">
                    <input type="text" id="name" name="name" class="form-control"  aria-describedby="basic-addon1">
                </div>
            </td>
        </tr>
        <tr>
            <td class="td-lable">费用：</td>
            <td class="td-text">
                <div class="input-group">
                    <input type="text"  id="fee" name="fee" class="form-control"  aria-describedby="basic-addon1">
                </div>
            </td>
        </tr>
        <tr>
            <td class="td-lable">顺序：</td>
            <td class="td-text">
                <div class="input-group">
                    <input type="text"  id="order" name="order" class="form-control"  aria-describedby="basic-addon1">
                </div>
            </td>
        </tr>
        <tr>
            <td colspan=2 style="text-align:center;">
                <button type="button" id="btnSave"  class="btn btn-success">保存</button>
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
        var code = $("#code").val();
        if(!code)
        {
            alert("编码不能为空！");
            return;
        }
        var name = $("#name").val();
        if(!name)
        {
            alert("名称不能为空！");
            return;
        }
        var fee = $("#fee").val();
        if(!fee){
            alert("费用不能为空");
            return;
        }
        var order = $('#order').val();
        if(!order){
            alert("顺序不能为空");
            return;
        }

        var data = "Random=" + encodeURI('${.now}');
        data = data + "&code=" + encodeURI(code);
        data = data + "&name=" + encodeURI(name);
        data = data + "&fee=" + encodeURI(fee);
        data = data + "&order1=" + encodeURI(order);
        $.ajax({
            async : true,
            type : "POST",
            url : "${basepath}/manage/express/insert",
            cache : false,
            timeout : 60 * 60 * 1000,
            dataType : "json",
            data : data,
            success : function(data) {
                if (data.message == "success") {
                    window.location.href = "${basepath}/manage/express/selectList";
                }
                else{
                    alert(data.message);
                }
            }
        });
    }
</script>
</@page.pageBase>