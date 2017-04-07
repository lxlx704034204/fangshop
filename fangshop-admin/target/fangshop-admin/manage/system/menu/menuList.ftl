<#import "/manage/tpl/pageBase.ftl" as page>
<@page.pageBase currentMenu="资源管理">
<div id="div-toolbar">
    <div>
        操作：
    </div>
    <div>
        <table>
            <tr>
                <td>
                    功能类型：
                </td>
                <td>
                    <select id="selectid" class="form-control"  aria-describedby="basic-addon1">
                        <option value="1" selected="selected">顶级父节点</option>
                        <option value="2">父节点</option>
                        <option value="3">子节点</option>
                    </select>
                </td>
                <td style="width: 60px;text-align: right;">
                    名称：
                </td>
                <td>
                    <input type="text"  id="name" size="30" class="form-control"  aria-describedby="basic-addon1"/>
                </td>
                <td style="width: 50px;text-align: right;">
                    url:
                </td>
                <td>
                    <input type="text"  id="url" size="80" style="width: 360px" class="form-control"  aria-describedby="basic-addon1"/>
                </td>
                <td style="width: 60px;text-align: right;">
                    类型：
                </td>
                <td>
                    <select id="operateid">
                        <option value="module" selected="selected">模块</option>
                        <option value="page">页面</option>
                        <option value="button">功能</option>
                    </select>
                </td>
                <td style="width: 80px;text-align: right;">
                    <button type="button" id="btnAdd"  class="btn btn-success">添加</button>
                </td>
                <td style="width: 120px;text-align: right;">
                    <button type="button" id="btnSort"  class="btn btn-success">保存排序结果</button>
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

    <div id="divSortContent"></div>
</div>
<script type="text/javascript">
    $(function(){
        getMenuList();
        $("#treeBtn").bind("click",{type:"expandOrCollapse"},onTreeClick);
        $("#btnAdd").bind("click", {isParent:true}, add);
        $("#btnSort").bind("click",sort);
    });
    var expandAllFlg = true;
    var checkAllTrueOrFalseFlg = true;
    var setting = {
        view: {
            fontCss: getFontCss
        },edit:{
            drag: {
                autoExpandTrigger: true,
                prev: true,
                inner: true,
                next: true
            },
            enable: true
        },data: {
            simpleData: {
                enable: true,
                idKey: "id",
                pIdKey: "pid",
                rootPId: "0"
            },key: {
                name: "name"
            }
        },callback: {
            onClick: onClick,
            onRename:zTreeOnRename,
            beforeRename:zTreeBeforeRename,
            onRemove: zTreeOnRemove,
            beforeRemove: zTreeBeforeRemove,
            beforeDrag: beforeDrag,
            beforeDrop:beforeDrop,
            onDrop: onDrop
        }
    };
    function onClick(e,treeId, treeNode) {
        var zTree = $.fn.zTree.getZTreeObj("treeid");
        zTree.expandNode(treeNode);
    }
    function getFontCss(treeId, treeNode) {
        return (!!treeNode.highlight) ? {color:"#A60000", "font-weight":"bold"} : {color:"#333", "font-weight":"normal"};
    }
    function zTreeBeforeRename(treeId, treeNode, newName, isCancel) {
        if (newName.length == 0) {
            alert("节点名称不能为空");
            return false;
        }
        return true;
    }
    function zTreeOnRename(event, treeId, treeNode) {
        var data = "Random=" + encodeURI('${.now}');
        data = data + "&name=" + encodeURI(treeNode.name);
        data = data + "&id=" + treeNode.id;
        $.post('${basepath}/manage/menu/update', data);
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
        $.post('${basepath}/manage/menu/delete', data);
    }
    function beforeDrag(treeId, treeNodes) {
        return true;
    }
    function beforeDrop(treeId, treeNodes, targetNode, moveType, isCopy) {
        return true;
    }
    function onDrop(event, treeId, treeNodes, targetNode, moveType, isCopy) {
        <#--//拖拽成功时，修改被拖拽节点的pid-->
        <#--if(treeNodes && targetNode){-->
            <#--$.post('${basepath}/manage/menu/update?id='+treeNodes[0].id+"&pid="+targetNode.id)-->
        <#--}-->
        return true;
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
    function add(e) {
        var zTree = $.fn.zTree.getZTreeObj("treeid"),
                isParent = e.data.isParent,
                nodes = zTree.getSelectedNodes(),
                treeNode = nodes[0];
        var data = "Random=" + encodeURI('${.now}');
        data = data + "&name=" + encodeURI($('#name').val());
        data = data + "&url=" + encodeURI($('#url').val());
        data = data + "&type=" + encodeURI($('#operateid').val());

        switch ($('#selectid').val()) {
            case "1":
                data = data + "&pid=0";
                var nodes1 = zTree.getNodes();
                var orderNum = 1;
                if (nodes1.length >= 1) {
                    orderNum = parseInt(nodes1[nodes1.length - 1].ordernum) + 1;
                }
                data = data + "&ordernum=" + encodeURI(orderNum);
                $.post('${basepath}/manage/menu/insert', data, function (result) {
                    if (result.message == "success") {
                        treeNode = zTree.addNodes(null, {
                            id: result.rows,
                            pId: 0,
                            isParent: isParent,
                            name: $('#name').val(),
                            ordernum:orderNum,
                            type:$('#operateid').val()
                        });
                    }
                });
                break;
            case "2":
                data = data + "&pid=" + treeNode.id;
                var orderNum = 1;
                if (treeNode.children) {
                    orderNum = parseInt(treeNode.children[treeNode.children.length-1].ordernum)+1;
                }
                data = data + "&ordernum=" + encodeURI(orderNum);
                $.post('${basepath}/manage/menu/insert', data, function (result) {
                    treeNode = zTree.addNodes(treeNode, {
                        id: result.rows,
                        pId: treeNode.id,
                        isParent: isParent,
                        name: $('#name').val(),
                        ordernum:orderNum,
                        type:$('#operateid').val()
                    });
                });
                break;
            case "3":
                data = data + "&pid=" + treeNode.id;
                var orderNum = 1;
                if (treeNode.children) {
                    orderNum = parseInt(treeNode.children[treeNode.children.length-1].ordernum)+1;
                }
                data = data + "&ordernum=" + encodeURI(orderNum);
                $.post('${basepath}/manage/menu/insert', data, function (result) {
                    treeNode = zTree.addNodes(treeNode, {
                        id: result.rows,
                        pId: treeNode.id,
                        isParent: false,
                        name: $('#name').val(),
                        ordernum:orderNum,
                        type:$('#operateid').val()
                    });
                });
                break;
        }
    }
    function sort() {
        getSortAfterNodes();
    }
    function getSortAfterNodes() {
        var nodeArr = new Array();
        var treeLeftObj = $.fn.zTree.getZTreeObj("treeid");
        var nodes= treeLeftObj.getNodes();
        for(var i = 0; i < nodes.length;i++){
            var node = new Object();
            node.id= nodes[i].id;
            node.pid = nodes[i].pid;
            node.ordernum=i+1;
            node.name = nodes[i].name;
            nodeArr.push(node);
            if(nodes[i].children != null && nodes[i].children.length>0){
                foreachFindChildNode(nodes[i], nodeArr);
            }
        }
        var data = "str=" + JSON.stringify(nodeArr);
        $.post('${basepath}/manage/menu/updateByJson',data, function (result) {
            if (result.message == "success") {
                alert("保存成功")
            }
        })

    }
    ///递归遍历旗下子节点
    function foreachFindChildNode(nodes, nodeArr) {
        for (var i = 0; i < nodes.children.length; i++) {
            var node = new Object();
            node.id = nodes.children[i].id;
            node.pid = nodes.children[i].pid;
            node.ordernum = i+1;
            node.name = nodes.children[i].name;
            nodeArr.push(node);
            if (nodes.children[i].children != null && nodes.children[i].children.length > 0) {
                foreachFindChildNode(nodes.children[i], nodeArr);
            }
        }
    }
    function getMenuList() {
        var data = "Random=" + encodeURI('${.now}');
        data = data + "&rid=0";
        $.ajax({
            url: "${basepath}/manage/menu/getAllMenus",
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