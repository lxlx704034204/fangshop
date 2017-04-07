<#import "/manage/tpl/pageBase.ftl" as page>
<#import "/manage/tpl/pager.ftl" as paging>
<#import "/manage/tpl/loading.ftl" as load>
<@page.pageBase currentMenu="用户管理">
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
<@load.loading></@load.loading>
<div id="div-toolbar">
<span>状态:</span>
<div class="btn-group" style="margin-right:100px;">
  <select id="sel-status">
  	<option value="" selected="checked">全部</option>
  	<option value="y">启用</option>
  	<option value="n">禁用</option>
  </select>
</div>
<button type="button" id="btn-search" data-loading-text="Loading..." 
class="btn btn-success" autocomplete="off" style="margin-right:10px;" onclick="search()">
  查询
</button>
<button type="button" id="btn-add" data-loading-text="Loading..." 
class="btn btn-success" autocomplete="off">
 添加
</button>
</div>
<hr/>
 <div id="div-table" style="">
 	<table id="table-userList"></table>
 	<@paging.paging ></@paging.paging>
 <div>
     <script type="text/javascript">
         $(function(){
             $("#btn-add").on('click',function(){
                 window.location.href="${basepath}/manage/user/toAdd";
             });
             search();
         })
         function edit(id,username,email,rid,status,password){
             email=email=="null" ? "" : email;
             var params="?id="+id+"&usermame="+username
                     +"&email="+email+"&rid="+rid
                     +"&status="+status+"&password="+password;
             window.location.href="${basepath}/manage/user/toEdit"+params;
         }

         function del(id){
             if(window.confirm("确定要删除吗？")){
                 var data = "Random=" + encodeURI('${.now}');
                 data = data + "&id=" + encodeURI(id);
                 //查询
                 $.ajax({
                     async : true,
                     type : "POST",
                     url : "${basepath}/manage/user/delete",
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
             data = data + "&status=" + encodeURI($("#sel-status").val());
             $.ajax({
                 async : true,
                 type : "POST",
                 url : "${basepath}/manage/user/search",
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
             $('#table-userList').bootstrapTable('destroy').bootstrapTable({
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
                         field: 'username',
                         title: '账号',
                         align: 'center'
                     }, {
                         field: 'nickname',
                         title: '昵称',
                         align: 'center'
                     },  {
                         field: 'email',
                         title: '邮箱',
                         align: 'center'
                     }, {
                         field:'createtime',
                         title:'创建时间',
                         align:'center',
                         formatter:function(value,row,index){
                             return new Date(value).format("yyyy-MM-dd hh:mm:ss");
                         }
                     },{
                         field: 'rolename',
                         title: '角色',
                         align: 'center',
                         formatter:function(value,row,index){
                             return row.role.rolename;
                         }
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
                     },{
                         field:'',
                         title:'操作',
                         align:'center',
                         formatter:function(value,row,index){
                             return '<a href="#" onclick="edit(\''+row.id+'\',\''+row.username+
                                     '\',\''+ row.email+'\',\''+ row.rid+'\',\''+row.status+'\',\''+row.password +'\')">编辑</a> | '
                                     + "<a onclick=del(" + row.id + ")>删除</a>";
                         }
                     }]
             });
         }

     </script>

</@page.pageBase>