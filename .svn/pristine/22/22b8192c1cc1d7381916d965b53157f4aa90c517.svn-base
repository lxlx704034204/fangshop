<#import "/manage/tpl/pageBase.ftl" as page>
<#import "/manage/tpl/pager.ftl" as paging>
<#import "/manage/tpl/loading.ftl" as load>
<@page.pageBase currentMenu="日志管理">
    <@paging.pagerJS></@paging.pagerJS>
    <@load.loading></@load.loading>
<style type="text/css">
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
        padding-right: 30px;
        width:200px;
    }
</style>
<div class="panel panel-default">
    <div class="panel-heading">
        <h4 class="panel-title">
            <a data-toggle="collapse" data-parent="#accordion"
               href="#collapseOne"> 筛选 </a>
        </h4>
    </div>
    <div id="collapseOne" class="panel-collapse collapse in">
        <div class="panel-body">
            <table>
                <tr class="adminContent">
                    <td class="adminTitle">是否异常登录：
                    </td>
                    <td class="adminData">
                        <select name="diffarealogin" id="diffarealogin" class="form-control">
                            <option value="" >全部</option>
                            <option value="y" >是</option>
                            <option value="n" >否</option>
                        </select>
                    </td>
                    <td class="adminTitle">账号：</td>
                    <td class="adminData">
                        <input type="text" name="account" id="account" class="form-control" />
                    </td>
                    <td colspan="10" style="text-align: right">
                        <button type="button" id="btnSearch" class="btn btn-success" onclick="search();">查询</button>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</div>
<div id="div-table" style="">
    <table id="tableList"></table>
    <@paging.paging ></@paging.paging>
</div>
<script type="text/javascript">
    $(function(){
        $("#btnSearch").on('click',function(){
            search();
        });
        search();
    })
    function search(){
        var data = "Random=" + encodeURI('${.now}');
        data = data + "&diffarealogin=" + encodeURI($('#diffarealogin').val());
        data = data + "&account=" + encodeURI($('#account').val());
        data = data + "&offset=" + encodeURI((parseInt($("#txtCurrentPage").val()) - 1) * parseInt($("#txtPageSize").val()));
        data = data + "&pageSize=" + encodeURI($("#txtPageSize").val());
        $.ajax({
            async : true,
            type : "POST",
            url : "${basepath}/manage/systemlog/search",
            cache : false,
            timeout : 60 * 60 * 1000,
            dataType : "json",
            data:data,
            success:function(data){
                ResetSearch(data.rows.total);
                setTableData(data.rows.list);
            }
        });
    }

    function setTableData(data) {
        $('#tableList').bootstrapTable('destroy').bootstrapTable({
            data:data,
            striped: true,
            search: true,
            showColumns: true,
            columns: [{
                field: 'title',
                title: '标题',
                align: 'center'
            }, {
                field: 'account',
                title: '账号',
                align: 'center'
            }, {
                field: 'logintime',
                title: '登录时间',
                align: 'center',
                formatter:function(value,row,index){
                    return new Date(value).format("yyyy-MM-dd hh:mm:ss");
                }
            }, {
                field: 'loginip',
                title: '登录IP',
                align: 'center'
            }, {
                field: 'loginArea',
                title: '登录位置',
                align: 'center'
            }, {
                field: 'diffarealogin',
                title: '是否异地登录',
                align: 'center',
                formatter:function(value,row,index){
                    if(value=="y"){
                        return '是';
                    }else{
                        return '否';
                    }
                }
            }]
        });
    }
</script>
</@page.pageBase>