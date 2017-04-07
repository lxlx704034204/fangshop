<#import "/manage/tpl/pageBase.ftl" as page>
<@page.pageBase currentMenu="区域管理">
<div id="div-toolbar">
    <div>
        操作：
    </div>
    <div>
        <table>
            <tr>
                <td style="width: 60px;text-align: right;">
                    名称：
                </td>
                <td>
                    <input type="text"  id="name" size="30" class="form-control"  aria-describedby="basic-addon1"/>
                </td>
                <td style="width: 50px;text-align: right;">
                    编码:
                </td>
                <td>
                    <input type="text"  id="code" size="20" style="width: 200px" class="form-control"  aria-describedby="basic-addon1"/>
                </td>
                <td style="width: 60px;text-align: right;">
                    父编码：
                </td>
                <td>
                    <input type="text"  id="pcode" size="20" style="width: 200px" class="form-control"  aria-describedby="basic-addon1"/>
                </td>
                <td style="width: 60px;text-align: right;">
                    层级：
                </td>
                <td>
                    <input type="text"  id="layer" size="20" style="width: 150px" class="form-control"  aria-describedby="basic-addon1"/>
                </td>
                <td style="width: 150px;text-align: right;">
                    <button type="button" id="btnAdd"  class="btn btn-success">添加或修改</button>
                </td>
            </tr>
        </table>
    </div>
    <div style="margin-top: 20px;">
        [<a id="treeBtn" href="#" title="展开/折叠全部资源" onclick="return false;">展开/折叠</a>]
    </div>
    <div>
        <ul id="treeid" class="ztree"></ul>
    </div>
</div>
<script type="text/javascript">
    $(function(){
        search();
        $("#treeBtn").bind("click",{type:"expandOrCollapse"},onTreeClick);
        $("#btnAdd").bind("click", add);
    });
    var expandAllFlg = true;
    var checkAllTrueOrFalseFlg = true;
    var setting = {
        view: {
            fontCss: getFontCss
        },edit:{
            enable: true,
            showRenameBtn: false
        },data: {
            simpleData: {
                enable: true,
                idKey: "code",
                pIdKey: "pcode",
                rootPId: "0"
            },key: {
                name: "name"
            }
        },callback: {
            onClick: onClick,
            onRemove: zTreeOnRemove,
            beforeRemove: zTreeBeforeRemove,
        }
    };
    function onClick(e,treeId, treeNode) {
        var zTree = $.fn.zTree.getZTreeObj("treeid");
        $('#name').val(treeNode.name);
        $('#code').val(treeNode.code);
        $('#pcode').val(treeNode.pcode);
        $('#layer').val(treeNode.layer);
        zTree.expandNode(treeNode);
    }
    function getFontCss(treeId, treeNode) {
        return (!!treeNode.highlight) ? {color:"#A60000", "font-weight":"bold"} : {color:"#333", "font-weight":"normal"};
    }
    function zTreeBeforeRemove(treeId, treeNode) {
        if (treeNode.children != undefined) {
            alert("该菜单下包含子菜单，不能直接删除");
            return false;
        }
    }
    function zTreeOnRemove(event, treeId, treeNode) {
        var data = "Random=" + encodeURI('${.now}');
        data = data + "&id=" + treeNode.id;
        $.post('${basepath}/manage/area/delete', data);
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
    function add() {
        var name = $('#name').val();
        if(!name){
            alert("名称不能为空！");
            return;
        }
        var code=$('#code').val();
        if(!code){
            alert("编码不能为空！");
            return;
        }
        var pcode = $('#pcode').val();
        if(!pcode){
            alert("父编码不能为空！");
            return;
        }
        var layer = $('#layer').val();
        if(!layer){
            alert("层级不能为空！");
            return;
        }

        var data = "Random=" + encodeURI('${.now}');
        data = data + "&name=" + encodeURI(name);
        data = data + "&code=" + encodeURI(code);
        data = data + "&pcode=" + encodeURI(pcode);
        data = data + "&layer=" + encodeURI(layer);

        $.ajax({
            async : true,
            type : "POST",
            url : "${basepath}/manage/area/insert",
            cache : false,
            timeout : 60 * 60 * 1000,
            dataType : "json",
            data : data,
            success : function(data) {
                if (data.message == "success") {
                    search();
                }
                else{
                    alert(data.message);
                }
            }
        });
    }
    function search() {
        var data = "Random=" + encodeURI('${.now}');
        $.ajax({
            url: "${basepath}/manage/area/search",
            cache: false,
            type: "POST",
            data: data,
            dataType: "json",
            async: true,
            success: function (data) {
                $.fn.zTree.init($("#treeid"), setting, data.rows);
            }
        });
    }
</script>
</@page.pageBase>