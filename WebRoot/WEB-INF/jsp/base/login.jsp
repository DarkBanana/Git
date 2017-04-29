<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/base/common_js.jsp"%>
<%@ include file="/WEB-INF/jsp/base/tag.jsp"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
<TITLE>新疆昌吉职业技术学院柜体智能制造生产线MES系统</TITLE>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${baseurl}css/style.css" />
<link rel="stylesheet" type="text/css"
	href="${baseurl}css/skin_/login.css" />
<link rel="stylesheet" type="text/css"
	href="${baseurl}jEasyUIcustom/uimaker/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${baseurl}jEasyUIcustom/uimaker/icon.css">
</head>
<body>
	<div id="container">
		<div id="bd">
			<div id="main">
				<div class="login-box">
					<FORM id="loginform" name="loginform" method="post"
						action="${baseurl}login.action">
						<div id="logo"></div>
						<h1></h1>
						<div class="input username" id="username">
							<label for="userName">用户名</label> <span></span> <input
								type="text" id="userName" name="username" /> <span
								style="margin-left: 210px;color: red" id="mphone_tip_msg_area">${userNameError}</span>
						</div>

						<div class="input psw" id="psw">
							<label for="password">密&nbsp;&nbsp;&nbsp;&nbsp;码</label> <span></span>
							<input type="password" id="password" name="password" /> <span
								style="margin-left: 200px;color: red" id="password_tip_msg_area">${pswError}</span>
						</div>
						<div class="input validate">
							<label for="valiDate">验证码</label> <input id="valiDate"
								name="randomcode" size="8" /> <img id="randomcode_img"
								style="float: right; margin-right: 90px; margin-top: 15px"
								src="${baseurl}validatecode.jsp" alt="" width="56" height="20"
								align='absMiddle' /> <a
								style="clear: both; float: right; margin-right: 40px; margin-top: -15px"
								href=javascript:randomcode_refresh()>刷新</a> <span
								id="code_tip_msg_area"
								style="float: right; margin-right: 5px; margin-top: 20px; color: red;">${codeError}</span>
						</div>

						<div id="btn" style="margin-left: 20px" class="loginButton"
							onclick="loginsubmit()">
							<input type="button" class="button" value="登录" />
						</div>
					</FORM>
				</div>
			</div>

			<div id="ft">湖北工业大学  武汉天之逸科技有限公司 研制   Copyright © 2017</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	var height = $(window).height() > 445 ? $(window).height() : 445;
	$("#container").height(height);
	var bdheight = ($(window).height() - $('#bd').height()) / 2 - 20;
	$('#bd').css('padding-top', bdheight);
	$(window).resize(function(e) {
		var height = $(window).height() > 445 ? $(window).height() : 445;
		$("#container").height(height);
		var bdheight = ($(window).height() - $('#bd').height()) / 2 - 20;
		$('#bd').css('padding-top', bdheight);
	});
	$('select').select();
	function loginsubmit() {

		var regMessageConfig = "";
		if ($("#userName").val() == "") {
			regMessageConfig += "<font color='red'><span>请输入用户名！</span></font>";
			$("#mphone_tip_msg_area").html(regMessageConfig);
			return;
		} else {
			$("#mphone_tip_msg_area").html("");
		}

		regMessageConfig = "";
		if ($("#password").val() == "") {
			regMessageConfig += "<font color='red'><span>请输入密码！</span></font>";
			$("#password_tip_msg_area").html(regMessageConfig);
			return;
		} else {
			$("#password_tip_msg_area").html("");
		}

		regMessageConfig = "";
		if ($("#valiDate").val() == "") {
			regMessageConfig += "<font color='red'><span>请输入验证码！</span></font>"
			$("#code_tip_msg_area").html(regMessageConfig);
			return;
		} else {
			$("#code_tip_msg_area").html("");
		}
		$("#loginform").submit();
	}

	//刷新验证码
	//实现思路，重新给图片的src赋值，后边加时间，防止缓存 
	function randomcode_refresh() {
		$("#randomcode_img").attr('src',
				'${baseurl}validatecode.jsp?time' + new Date().getTime());
	}
</script>
</HTML>
