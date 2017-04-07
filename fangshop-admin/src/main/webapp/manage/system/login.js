$(function(){
	//用户名输入框  获取焦点
	//$("#userName").focus();
	//当 用户 重新输入 用户名 和密码 的时候  ，要将 错误消息  的提示框隐藏掉
	//$("#userName").keydown(hideErrorMsg());
	//$("#btn-hiden-errorMsg").click(hideErrorMsg());
})

//隐藏 错误消息 提示框
function hideErrorMsg(){
	if($("#div-login-error").children().length>0){
		$("#div-login-error").empty();
	}
}
