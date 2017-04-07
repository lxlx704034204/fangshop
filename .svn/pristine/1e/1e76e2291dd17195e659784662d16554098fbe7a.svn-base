<#macro loading>
<div class="slbusyboxloading" style="position: absolute; right: 10px; top: 0px; display: none; opacity: 0.8;">
    执行中...
</div>
<script type="text/javascript">
  $(document).ready(function () {
	  try {
	            $(document).bind("ajaxStart", function () {
	                $(".slbusyboxloading").show().fadeTo("fast", 0.8);
	                $('.btn-success,.inputButton,#btnSearch').attr('disabled', 'disabled').addClass('disabled');
	            }).bind("ajaxStop", function () {
	                $(".slbusyboxloading").hide();
	                //RemoveBackDiv()
	                $('.btn-success,.inputButton,#btnSearch').removeAttr('disabled').removeClass('disabled');
	            }).bind("ajaxError", function (event, xhr, options, exc) {
	                //登录超时，或者没有权限
	                if (xhr.status == 403) {
	                    window.alert(xhr.responseText);
	                }
	                //找不到路径
	                else if (xhr.status == 404) {
	                    window.alert(xhr.responseText);
	                }
	                //程序内部错误
	                else if (xhr.status == 600) {
	                    window.alert(xhr.responseText);
	                }
	            });
	        }
	  catch (error) { }
  });
</script>
</#macro>