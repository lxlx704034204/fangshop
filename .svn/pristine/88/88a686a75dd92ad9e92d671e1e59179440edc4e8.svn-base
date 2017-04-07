<#import "/manage/tpl/pageBase.ftl" as page>
<@page.pageBase currentMenu="角色管理">
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
            <th colspan=2 style="text-align:center;background-color:#DFF1D9;">编辑角色</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td class="td-lable">角色名称</td>
            <td class="td-text">
                <div class="input-group">
                    <#if role.rolename??>
                        <input type="text" id="rolename" name="rolename" value="${role.rolename}" class="form-control"  aria-describedby="basic-addon1">
                    <#else>
                        <input type="text" id="rolename" name="rolename" class="form-control"  aria-describedby="basic-addon1">
                    </#if>
                </div>
            </td>
        </tr>
        <tr>
            <td class="td-lable">角色描述</td>
            <td class="td-text">
                <div class="input-group">
                    <#if role.roledesc??>
                        <input type="text" id="roledesc" name="roledesc" value="${role.roledesc}" class="form-control"  aria-describedby="basic-addon1">
                    <#else>
                        <input type="text" id="roledesc" name="roledesc" class="form-control"  aria-describedby="basic-addon1">
                    </#if>
                </div>
            </td>
        </tr>
        <tr>
            <td class="td-lable">状态</td>
            <td class="td-text">
                <select id="status" name="status">
                    <#assign str={'y':'启用','n':'禁用'}>
                    <#list str?keys as item>
                        <option value="${item}" <#if role.status?? && role.status==item>selected="selected"</#if>>${str[item]}</option>
                    </#list>
                </select>
            </td>
        </tr>
        <tr>
            <td class="td-lable">角色权限</td>
            <td class="td-text">
                <div class="input-group">
                    [<a id="treeBtn" href="#" title="展开/折叠全部资源" onclick="return false;">展开/折叠</a>]
                    [<a id="checkBtn" href="#" title="全选/全不选" onclick="return false;">全选/全不选</a>]
                </div>
                <ul id="treeid" class="ztree"></ul>
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
        getMenuList();
        $("#treeBtn").bind("click",{type:"expandOrCollapse"},onTreeClick);
        $("#checkBtn").bind("click",{type:"checkAllTrueOrFalse"},onTreeClick);
        $("#btnSave").click(function(){
            save();
        })
    });
    var expandAllFlg = true;
    var checkAllTrueOrFalseFlg = true;
    var setting = {
        check: {
            enable: true,
            dblClickExpand: false
        },data: {
            simpleData: {
                enable: true,
                idKey: "id",
                pIdKey: "pid",
                rootPId: "0"
            },
            key: {
                name: "name"
            }
        },view: {
            fontCss: getFontCss
        },callback: {
            onClick: onClick
        }
    };
    function onClick(e,treeId, treeNode) {
        var zTree = $.fn.zTree.getZTreeObj("treeid");
        zTree.expandNode(treeNode);
    }
    function getFontCss(treeId, treeNode) {
        return (!!treeNode.highlight) ? {color:"#A60000", "font-weight":"bold"} : {color:"#333", "font-weight":"normal"};
    }
    function onTreeClick(e){
        var zTree = $.fn.zTree.getZTreeObj("treeid"),
                type = e.data.type,
                nodes = zTree.getSelectedNodes();
        if (type == "expandAll") {
            zTree.expandAll(true);
        } else if (type == "collapseAll") {
            zTree.expandAll(false);
        } else if (type == "expandOrCollapse") {
            zTree.expandAll(expandAllFlg);
            expandAllFlg = !expandAllFlg;
        } else if (type == "checkAllTrueOrFalse") {
            zTree.checkAllNodes(checkAllTrueOrFalseFlg);
            checkAllTrueOrFalseFlg = !checkAllTrueOrFalseFlg;
        } else {
            if (type.indexOf("All")<0 && nodes.length == 0) {
                alert("请先选择一个父节点");
            }
        }
    }
    function getMenuList() {
        var data = "Random=" + encodeURI('${.now}');
        data = data + "&rid=" + encodeURI(${role.id});
        $.ajax({
            url: "${basepath}/manage/menu/getAllMenus",
            cache: false,
            type: "POST",
            data: data,
            dataType: "json",
            async: true,
            success: function (data) {
                $.fn.zTree.init($("#treeid"), setting, data.rows);
                $("#rolename").focus();
            }
        });
    }
    function save(){
        var rolename = $("#rolename").val();
        if(!rolename)
        {
            alert("角色名称不能为空！");
            return;
        }
        var ids = "";
        var obj = $.fn.zTree.getZTreeObj("treeid");
        var nodes = obj.getCheckedNodes(true);
        for(var i =0; i < nodes.length; i++){
            ids += nodes[i].id+",";
        }

        var data = "Random=" + encodeURI('${.now}');
        data = data + "&id=" + encodeURI(${role.id});
        data = data + "&rolename=" + encodeURI(rolename);
        data = data + "&roledesc=" + encodeURI($("#roledesc").val());
        data = data + "&status=" + encodeURI($("#status").val());
        data = data + "&ids=" + encodeURI(ids);

        $.ajax({
            async : true,
            type : "POST",
            url : "${basepath}/manage/role/update",
            cache : false,
            timeout : 60 * 60 * 1000,
            dataType : "json",
            data : data,
            success : function(data) {
                if (data.message == "success") {
                    window.location.href = "${basepath}/manage/role/selectList";
                }
                else{
                    alert(data.message);
                }
            }
        });
    }
</script>
</@page.pageBase>