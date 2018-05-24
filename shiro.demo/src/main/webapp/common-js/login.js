$(function() {

	$("#toLogin").click(function() {
		$.ajax({
			type : 'POST',
			dataType : 'text',
			url : "doLogin.shtml",
			data : $("#loginform").serializeArray(),
			contentType : 'application/x-www-form-urlencoded',
			success : function(msg) {
				alert("登陆成功！");
			}
		});
	});
});