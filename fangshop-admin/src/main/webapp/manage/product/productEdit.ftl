<#import "/manage/tpl/pageBase.ftl" as page>
<@page.pageBase currentMenu="商品管理">

<script charset="utf-8" src="${staticpath}/bootstrap-fileinput-4.3.2/bootstrap-fileinput.js"?version="${version}"></script>
<script charset="utf-8" src="${staticpath}/bootstrap-fileinput-4.3.2/fileinput_locale_zh.js"?version="${version}"></script>
<link rel="stylesheet" href="${staticpath}/bootstrap-fileinput-4.3.2/fileinput.min.css"?version="${version}"/>
<script type="text/javascript" src="${basepath}/UEdit/ueditor.config.js"></script> 
<script type="text/javascript" src="${basepath}/UEdit/ueditor.all.js"></script> 
<script src="${basepath}/UEdit/lang/zh-cn/zh-cn.js" type="text/javascript"></script>
<link href="${basepath}/UEdit/themes/default/css/ueditor.css" rel="stylesheet" type="text/css" /> 

<style type="text/css">
*{
	margin:0;
	padding:0;
}

.toolbar{
	height:30px;
	width:100%; 
}
.div-tabs{
	height:700px;
	width:100%;
	background-color:#F8F8F8;
	border:1px solid #E7E7E7;
}
	.ul-tabls{
		height:40px;
		background-color: #337AB7;
	} 
	
	li a {
		color:#337AB7;
	}
	
	li a:hover{
		text-decoration:none;
		color:#e78f08;
		cursor:hand;
		cursor:pointer;
	}
	
	.ul-tabls li{
		list-style-type:none;
		background-color:white;
		float: left;
    	line-height: 35px; 
    	margin-top: 4px;
    	margin-left: 2px;
    	padding-left: 10px;
    	padding-right: 10px;
    	border-top-left-radius: 5px;
    	border-top-right-radius: 5px;
	}
	
	#baseInfo{
		width:80%;
		border-collapse:separate;
		border-spacing:0px 10px;
	}
	
	.td-lable{
		width:10%;
		text-align:right;
		padding-right:15px;
	}
	.td-input-text{
		width:40%;
	}
	
	#div-picture-toolbar{
		margin-left: 10px;
		height: 46px;
    	padding-top: 5px;
	}
	
	#table-picture{
		border-left:1px solid #E7E7E7;
		border-bottom:1px solid #E7E7E7;
		width: 30%;
    	margin-left: 10px;
    	margin-top: 10px; 
	}
	#table-picture td{
		border-top: 1px solid #E7E7E7;
    	border-right: 1px solid #E7E7E7;
    	text-align: center;
    	height: 30px;
	}
	.a-click{
		color:#e78f08;
	}
</style>

<script type="text/javascript">  
	var ue = null;
	window.UEDITOR_HOME_URL = "${basepath}/UEdit/";
	$(function(){ 
		$(".ul-tabls li").eq(0).find('a').addClass('a-click');
		
		$("#input-file").fileinput({ 
			language:'zh',
			showPreview:false,
			showUpload: true,
			allowedFileExtensions:['jpg', 'png','gif'],
			uploadUrl:'${basepath}/manage/product/uploadImg'
		});
	
		$("#sel-catalog,#sel-unit,#sel-isnew,#sel-sale").css('width',"100%"); 
		ue = UE.getEditor('container');  
		
		// editor准备好之后才可以使用 
		ue.addListener("ready", function () { 
        	ue.setHide(); 
		}); 
		
		$(".div-tabs-content-baseinfo").show();
		clickTab();
	})
	
	function clickTab(){
		$(".ul-tabls li a").click('on',function(){
			$(".div-tabs-content-baseinfo ,.div-tabs-content-picture,.div-tabs-content-attribute,.div-tabs-content-gift").hide();
			ue.setHide();
			$(".ul-tabls li a").removeClass('a-click');
			$(this).addClass('a-click');
			switch($(this).text()){
				case "基本信息":
					$(".div-tabs-content-baseinfo").show();
					break;
				case "商品介绍": 
					$(".div-tabs-content-introduce").show(); 
					ue.setShow(); 
					break;
				case "商品图片":
					$(".div-tabs-content-picture").show();
					break; 
				case "商品属性":
					$(".div-tabs-content-attribute").show();
					break; 
				case "绑定商品赠品":
					$(".div-tabs-content-gift").show();
					break;
			} 
		});
	}
</script>

<div class="toolbar" >
		<button type="button" id="btn-add" data-loading-text="Loading..." class="btn btn-success" style="margin-right:10px;" >新增</button>
</div>

<hr style="margin-top: 10px; margin-bottom: 5px;">

<div class="div-tabs"> 
	<ul class="ul-tabls">
		<li><a>基本信息</a></li>
		<li><a>商品介绍</a></li>
		<li><a>商品图片</a></li>
		<li><a>商品属性</a></li>
		<li><a>绑定商品赠品</a></li>
	</ul> 
	<#--绑定商品赠品-->
	<div class="div-tabs-content-gift" style="display:none;">
		
	</div>
	
	<#--todo:商品参数、商品规格-->
	
	<#--商品属性-->
	<#--属性与类别（子类）相关联，所以应该在确定类别的情况下加载对应的属性-->
	<div class="div-tabs-content-attribute" style="display:none;">
		<table width="width:100%;">
			<tbody>
				
			</tbody>
		</table>
	</div>
	
	<#--商品图片-->
	<div class="div-tabs-content-picture" style="display:none;">
		<div id="div-picture-toolbar">
			<button type="button" id="btn-add-picture" data-loading-text="Loading..." class="btn btn-success" style="margin-right:10px;" >新增</button>
			<button type="button" id="btn-del-picture" data-loading-text="Loading..." class="btn btn-success" style="margin-right:10px;" >删除</button>
		</div>
		<table id="table-picture">
			<tbody>
				<tr style="background-color: #DFF0D8;">
					<td style="width:20px;"><input type="checkbox"></td>
					<td style="width:30%">图片</td>
					<td>图片地址</td>
				</tr>
			</tbody>
		</table>
	</div>
	
	<#--商品介绍-->
	<div class="div-tabs-content-introduce" style="display:none;">
		<textarea id="container" name="content" style="height:560px;width:100%"></textarea>
	</div>
	
	<#--基本信息-->
	<div class="div-tabs-content-baseinfo" style="display:none;">
		<table id="baseInfo">
			<tbody>
				<tr>
					<td class="td-lable"><span>名称</span></td>
					<td class="td-input-text"><input type="text" class="form-control"></td> 
				</tr>
				<tr>
					<td class="td-lable"><span>类别</span></td>
					<td>
						<select id="sel-catalog" name="catalogID">
							<#list catalogs as catalog>
								<optgroup label="${catalog.name}">  
								<#if catalog.children?? && catalog.children?size gt 0> 
									<#list catalog.children as child>
										<option value="${child.id}">&nbsp;&nbsp;${child.name}</option>
									</#list> 
								</#if> 
							</#list>
						</select>
					</td>
					<td class="td-lable"><span>单位</span></td>
					<td>
						<select id="sel-unit" name="unit" style="width:100%">
							<option value="0" selected="checked">件</option>
							<option value="1">个</option>
							<option value="2">只</option>
							<option value="3">盒</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="td-lable"><span>简介</span></td>
					<td colspan="3">
						<textarea rows="3" style="overflow-y:scroll;width:100%;"></textarea>
					</td>
				</tr>
				<tr>
					<td class="td-lable"><span>主图</span></td>
					<td>
						<input id="input-file" name="inputFile" type="file" class="file" >
					</td>
				</tr>
				<tr>
					<td class="td-lable"><span>定价</span></td>
					<td class="td-input-text">
						<input type="text" class="form-control">
					</td>
					<td class="td-lable"><span>现价</span></td>
					<td class="td-input-text">
						<input type="text" class="form-control">
					</td>
				</tr>	
				<tr>
					<td class="td-lable"><span>库存</span></td>
					<td class="td-input-text">
						<input type="text" class="form-control">
					</td>
					<td class="td-lable"><span>销量</span></td>
					<td class="td-input-text">
						<input type="text" class="form-control">
					</td>
				</tr>
				<tr>
					<td class="td-lable"><span>是否新品</span></td>
					<td class="td-input-text">
						<select id="sel-isnew" name="isnew" style="width:100%">
							<option value="y" selected="checked">是</option>
							<option value="n">否</option> 
						</select>
					</td>
					<td class="td-lable"><span>是否特价</span></td>
					<td class="td-input-text">
						<select id="sel-sale" name="sale" style="width:100%">
							<option value="y" selected="checked">是</option>
							<option value="n">否</option> 
						</select>
					</td>
				</tr>
				<tr>
					<td class="td-lable"><span>送积分</span></td>
					<td class="td-input-text" colspan="3">
						<input type="text" class="form-control">
					</td> 
				</tr>
				<tr>
					<td class="td-lable"><span>页面标题</span></td>
					<td class="td-input-text" colspan="3">
						<input type="text" class="form-control">
					</td> 
				</tr>
				<tr>
					<td class="td-lable"><span>页面描述</span></td>
					<td class="td-input-text" colspan="3">
						<input type="text" class="form-control">
					</td> 
				</tr>
				<tr>
					<td class="td-lable"><span>页面关键字</span></td>
					<td class="td-input-text" colspan="3">
						<input type="text" class="form-control">
					</td> 
				</tr>
			</tbody>
		</table>
	</div>
</div>

</@page.pageBase>