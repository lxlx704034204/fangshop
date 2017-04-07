<#import "/manage/tpl/pageBase.ftl" as page> 
<#import "/manage/tpl/renderDateSpan.ftl" as dataspan>
<#import "/manage/tpl/loading.ftl" as load>
<@page.pageBase currentMenu="订单销售统计">
<@load.loading></@load.loading>
<div class="panel panel-default">
	<div class="panel-heading">
		<h4 class="panel-title">
			<a data-toggle="collapse" data-parent="#accordion"
				href="#collapseOne"> 操作 </a>
		</h4>
	</div>
	<div id="collapseOne" class="panel-collapse collapse in">
		<div class="panel-body">
		    <table>
		       <tr> 
		          <td style="width:50%">时间范围：<@dataspan.renderDataSpan RenderDateSpan_DateBegin='${currentUser().beginDate?string("yyyy-MM-dd")}' RenderDateSpan_DateEnd='${.now?string("yyyy-MM-dd")}'></@dataspan.renderDataSpan></td>
		          <td><button type="button" id="btnSearch" class="btn btn-success">搜索</button></td>
		       </tr>
		    </table>
		</div>
	</div>
</div>
<br/>
<div id="div-table">
 	 <div id="ShowChart" style="width: 100%; height: 600px;"></div>
</div>
<script type="text/javascript">
$(function(){
	
	search();
})
//搜索图表
function search() {
	var data = "Random=" + encodeURI('${.now}');
	if($("#dtBegin").val()==null || $("#dtEnd").val()==null){
		alert("开始时间和结束时间不能为空!");
		return;
    }
	data = data + "&startDate=" + encodeURI($("#dtBegin").val());
	data = data + "&endDate=" + encodeURI($("#dtEnd").val());
    $.ajax({
        type: "POST",
        url: "getOrderSalesData?t=" + Math.random(),
        cache: false,
        data: data,
        success: function (result) {
            if (result.message=="success") {
                KeyDataCurve(result); 
            }
        }
    });
}
function KeyDataCurve(result) {
    $('#ShowChart').highcharts({
        chart: {
            borderColor: '#ddd',
            borderWidth: 1,
            type: 'line'
        },
        title: {
            text: '销售总额趋势图',
            x: -20 //center
        },
        credits: {
            enabled: false   //右下角不显示LOGO
        },
        xAxis: {  //x轴
            categories: Round30X(result.rows.x),
            labels: {
                y: 26,//调节y偏移
                rotation: -40//调节倾斜角度偏移
            }
        },
        yAxis: {
            min: 0,
            title: {
                text: ''
            },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
        plotOptions: { //设置数据点
            spline: {
                lineWidth: 0.1,
                fillOpacity: 0.1,
                dataLabels: {
                    enabled: true  //在数据点上显示对应的数据值
                },
                marker: {
                    enabled: false,
                    states: {
                        hover: {
                            enabled: true,
                            radius: 2
                        }
                    }
                },
                shadow: false
            }
        },
        legend: {  //图例
            borderWidth: 0
        },
        series: Round30X(result.rows.y)
    });
}
//创建图表使用公共方法（曲线图+饼图+柱状图）
function Round30X(orginalX) {
    if (orginalX.length > 30) {
        var rtn = new Array();
        var step = Math.ceil(orginalX.length / 30);
        for (var i = 0; i < orginalX.length; i++) {
            if (!(i % step)) {
                rtn.push(orginalX[i]);
            }
        }
        return rtn;
    }
    else {
        return orginalX;
    }
}
function Round30Y(orginalY) {
    for (var i = 0; i < orginalY.length; i++) {
        if (orginalY[i].data.length > 30) {
            var rtn = new Array();
            var step = Math.ceil(orginalY[i].data.length / 30);
            for (var j = 0; j < orginalY[i].data.length; j++) {
                if (!(j % step)) {
                    rtn.push(orginalY[i].data[j]);
                }
            }
        }
        else {
            return orginalY;
        }
        orginalY[i].data = rtn;
    }
    return orginalY;
}
</script>
</@page.pageBase>