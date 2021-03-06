<#import "/manage/tpl/pageBase.ftl" as page>
<#import "/manage/tpl/pager.ftl" as paging>
<#import "/manage/tpl/loading.ftl" as load>
<@page.pageBase currentMenu="角色管理">
<@paging.pagerJS></@paging.pagerJS>
<@load.loading></@load.loading>
<div id="div-toolbar">
    <button type="button" id="btn-search" data-loading-text="Loading..."
            class="btn btn-success" autocomplete="off" style="margin-right:10px;" onclick="search()">
        查询
    </button>
    <#if add??>
        <button type="button" id="btnAdd" data-loading-text="Loading..."
                class="btn btn-success" autocomplete="off">
            添加
        </button>
    </#if>
</div>
<hr/>
<div id="div-table" style="">
    <table id="table-roleList"></table>
    <@paging.paging ></@paging.paging>
</div>
<script type="text/javascript">
    $(function(){
        $("#btnAdd").on('click',function(){
            window.location.href="${basepath}/manage/role/toAdd";
        });
        search();
    })
    function edit(id){
        var params="?id="+id;
        window.location.href="${basepath}/manage/role/toEdit"+params;
    }

    function del(id){
        if(window.confirm("确定要删除吗？")){
            var data = "Random=" + encodeURI('${.now}');
            data = data + "&id=" + encodeURI(id);
            //查询
            $.ajax({
                async : true,
                type : "POST",
                url : "${basepath}/manage/role/delete",
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

    function search(){
        var data = "Random=" + encodeURI('${.now}');
        data = data + "&offset=" + encodeURI((parseInt($("#txtCurrentPage").val()) - 1) * parseInt($("#txtPageSize").val()));
        data = data + "&pageSize=" + encodeURI($("#txtPageSize").val());
        $.ajax({
            async : true,
            type : "POST",
            url : "${basepath}/manage/role/search",
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

    function setTableData(resData) {
        $('#table-roleList').bootstrapTable('destroy').bootstrapTable({
            data:resData,
            striped: true,
            search: true,
            showColumns: true,
            columns: [
                {
                    checkbox:true,
                    filed:'id',
                    align:'center'
                }, {
                    field: 'rolename',
                    title: '角色名称',
                    align: 'center'
                }, {
                    field: 'roledesc',
                    title: '角色描述',
                    align: 'center'
                }, {
                    field: 'status',
                    title: '状态',
                    align: 'center',
                    formatter:function(value,row,index){
                        if(value=="y"){
                            return '<img src="${basepath}/resource/images/action_check.gif" />';
                        }else{
                            return '<img src="${basepath}/resource/images/action_delete.gif" />';
                        }
                    }
                }
                <#if edit??>
                    ,{
                        field:'',
                        title:'操作',
                        align:'center',
                        formatter:function(value,row,index){
                            return '<a href="#" onclick="edit(\''+row.id +'\')">编辑</a> | '
                                    + "<a onclick=del(" + row.id + ")>删除</a>";
                        }
                    }
                </#if>
                ]
        });
    }
</script>
</@page.pageBase>