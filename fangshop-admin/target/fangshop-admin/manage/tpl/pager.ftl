<#--分页控件-->
<#--调用方式见     manage/system/user/userList.ftl  -->
<#macro pagerCSS>
<style type="text/css">
	.slpager a{
		cursor:pointer;
	}
</style>
</#macro>
<#macro pagerJS>
<script type="text/javascript">
    function ResetSearch(RowsCount) {
        var MaxPage = Math.ceil(RowsCount / $("#txtPageSize").val());
        if (MaxPage == 0) {
            MaxPage = 1;
        }
        $("#txtMaxPage").val(MaxPage);
        $("#TotalCount").text(RowsCount);
        var currentPage = parseInt($("#txtCurrentPage").val());
        //if (currentPage > MaxPage) {
          //  $("#txtCurrentPage").val(1);
         //   search();
        //}
    }
    $(function () {
        //首页按钮
        $("#btnStartPage").click(function (event) {
            var currentPage = 1;
            $("#txtCurrentPage").val(currentPage);
            search();
        });
        //尾页按钮
        $("#btnEndPage").click(function (event) {
            var currentPage = parseInt($("#txtMaxPage").val());
            $("#txtCurrentPage").val(currentPage);
            search();
        });
        //下一页按钮
        $("#btnUpPage").click(function (event) {
            var currentPage = parseInt($("#txtCurrentPage").val());
            currentPage = currentPage - 1;
            if (currentPage < 1) {
                currentPage = 1;
                alert("已经到达首页！");
            }
            $("#txtCurrentPage").val(currentPage);
            search();
        });
            
        //上一页按钮
        $("#btnDownPage").click(function (event) {
            var currentPage = parseInt($("#txtCurrentPage").val());
            currentPage = currentPage + 1;
            var maxPage = parseInt($("#txtMaxPage").val());
            if (currentPage > maxPage) {
                currentPage = maxPage;
                alert("已经到达尾页！");
            }
            $("#txtCurrentPage").val(currentPage);
            search();
        });
        //输入页面
        $("#txtCurrentPage").keydown(function (event) {
            if (event.keyCode == 13) {
                var currentPage = parseInt($("#txtCurrentPage").val());
                var maxPage = parseInt($("#txtMaxPage").val());
                if (currentPage > maxPage) {
                    currentPage = maxPage;
                    $("#txtCurrentPage").val(currentPage);
                    alert("已经到达尾页！");
                }
                search();
                event.preventDefault();
            }
        })
        //更新页尺寸
        $("#txtPageSize").change(function () {
            $('#txtCurrentPage').val('1');
            search();
        });
        //查询按钮
        $("#btnSearch").click(function (event) {
            $("#txtCurrentPage").val("1");
            $("#TotalCount").text("0");
            $("#txtMaxPage").val("1");
            search();
        });
    });
</script>
</#macro>

<#macro paging pageSize=15 total=0>	
<div class="slpager">
    <a id="btnStartPage" title="首页"><b>|&lt;</b></a>&nbsp;<a id="btnUpPage" title="上一页"><b>&lt;</b></a>
    <input id="txtCurrentPage" title="当前页" type="text" value="1" style="width: 60px;text-align: center;border-color:#CCCCCC;" />/
    <input readonly="readonly" id="txtMaxPage" title="总页数" type="text" value="1" style="width: 60px; text-align: center;background-color:#EEEEEE" />
    <a id="btnDownPage" title="下一页"><b>&gt;</b></a>&nbsp;<a id="btnEndPage" title="尾页"><b>&gt;|</b></a>
    <select id="txtPageSize" style="height: 30px;" title="每页行数">
        <option value="10">10行</option>
        <option value="15"selected="selected">15行</option>
        <option value="20">20行</option>
        <option value="30" >30行</option>
        <option value="40">40行</option>
        <option value="50">50行</option>
        <option value="100">100行</option>
        <option value="500">500行</option>
    </select>
    共<font color="red" id="TotalCount">0</font>条记录
</div>
</#macro>