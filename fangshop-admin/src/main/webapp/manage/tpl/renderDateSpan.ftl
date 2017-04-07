<#--时间控件-->
<#macro renderDataSpan RenderDateSpan_Suffix="" RenderDateSpan_DateBegin="" RenderDateSpan_DateEnd="" RenderDateSpan_DateMin="" RenderDateSpan_DateMax="" RenderDateSpan_HasLabel=false>
<script type="text/javascript">
function dtChange${RenderDateSpan_Suffix}(elem, selectDate){
	var _id = $(elem).attr('id');
    var _tmpDate='';
    if (_id == 'dtBegin${RenderDateSpan_Suffix}') {
        _tmpDate = $('#dtEnd${RenderDateSpan_Suffix}').val();
        if(_tmpDate.length===10){
            _tmpDate+=' 00:00:00';
            selectDate.setHours(0);selectDate.setMinutes(0);selectDate.setSeconds(0);selectDate.setMilliseconds(0);
        }//修正newDate 函数默认添加时区的问题
        if (selectDate - new Date(_tmpDate.replace(/-/g,'/')) > 0) { alert('起始日期必须小于或等于结束日期'); return false; }
        if('${RenderDateSpan_DateMin}' != ''){
                if (new Date('${RenderDateSpan_DateMin}')-new Date(Date.parse(selectDate) + (86400000 * 1)) > 0) { alert('最小日期不能小于 ${RenderDateSpan_DateMin}'); return false; }

        }
    } else if (_id == 'dtEnd${RenderDateSpan_Suffix}') {
        _tmpDate = $('#dtBegin${RenderDateSpan_Suffix}').val();
        if(_tmpDate.length===10){_tmpDate+=' 00:00:00';}
        if (new Date(_tmpDate.replace(/-/g,'/')) - selectDate > 0) { alert('起始日期必须小于或等于结束日期'); return false; }
        if('${RenderDateSpan_DateMax}'){
            if (selectDate - new Date('${RenderDateSpan_DateMax}'.replace(/-/g,'/'))-86400000 >= 0) { alert('最大日期不能大于 ${RenderDateSpan_DateMax}'); return false; }
        }
    }
	return true;
}
</script>
<#if RenderDateSpan_HasLabel==true>
    <label for="dtBegin">时间范围：</label>
</#if>
<input type="text" class="form-control" style="display: inline;width: 35%;background-color: white;" readonly="readonly" name="dtBegin${RenderDateSpan_Suffix}" id="dtBegin${RenderDateSpan_Suffix}" value="${RenderDateSpan_DateBegin}" 
onclick="SelectDate(this, 'yyyy-MM-dd', 0, 0, dtChange${RenderDateSpan_Suffix})" style="width: 100px;"   />
至
<input type="text" class="form-control" style="display: inline;width: 35%;background-color: white;" readonly="readonly" name="dtEnd${RenderDateSpan_Suffix}" id="dtEnd${RenderDateSpan_Suffix}" value="${RenderDateSpan_DateEnd}" 
onclick="SelectDate(this, 'yyyy-MM-dd', 0, 0, dtChange${RenderDateSpan_Suffix})" style="width: 100px;" />
</#macro>