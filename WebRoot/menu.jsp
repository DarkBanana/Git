<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setBundle basename="resources.messages" var="messagesBundle" />
<c:set var="baseurl" value="${pageContext.request.contextPath}/"></c:set>
<%@ include file="/WEB-INF/jsp/base/common_js.jsp"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<html>
<head>
<TITLE>柜体智能生产MES系统</TITLE>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="${baseurl}css/style.css" />
<link rel="stylesheet" href="${baseurl}css/zTreeStyle/zTreeStyle.css"
	type="text/css">
<link rel="stylesheet" type="text/css"
	href="${baseurl}css/skin_/nav.css" />
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$("#cut")
								.click(
										function() {
											htmlobj = $
													.ajax({
														url : "${baseurl}/procedurecoding/queryprocedurecoding.action?pc=cut",
														async : true
													});
										});
						$("#punch")
								.click(
										function() {
											htmlobj = $
													.ajax({
														url : "${baseurl}/procedurecoding/queryprocedurecoding.action?pc=punch",
														async : true
													});
										});
						$("#bend")
								.click(
										function() {
											htmlobj = $
													.ajax({
														url : "${baseurl}/procedurecoding/queryprocedurecoding.action?pc=bend",
														async : true
													});
										});
						$("#mfitting")
								.click(
										function() {
											htmlobj = $
													.ajax({
														url : "${baseurl}/procedurecoding/queryprocedurecoding.action?pc=mfitting",
														async : true
													});
										});
						$("#efitting")
								.click(
										function() {
											htmlobj = $
													.ajax({
														url : "${baseurl}/procedurecoding/queryprocedurecoding.action?pc=efitting",
														async : true
													});
										});
						$("#ffitting")
								.click(
										function() {
											htmlobj = $
													.ajax({
														url : "${baseurl}/procedurecoding/queryprocedurecoding.action?pc=ffitting",
														async : true
													});
										});

					});
</script>
</head>
<body>
	<div id="container">
		<div id="bd">
			<div class="sidebar">
				<div class="sidebar-bg"></div>
				<i class="sidebar-hide"></i>
				<h2>
					<a href="javascript:;"><i class="h2-icon" title="切换到树型结构"></i><span>安全管理</span></a>
				</h2>
				<ul class="nav">

					<li class="nav-li"><a href="javascript:;" class="ue-clear"><i
							class="nav-ivon"></i><span class="nav-text">BOM管理</span></a>
						<ul class="subnav">
							<li class="subnav-li" href="${baseurl}/ctype/queryctype.action"
								data-id="169"><a href="javascript:;" class="ue-clear"><i
									class="subnav-icon"></i><span class="subnav-text">产品类型管理</span></a></li>
							<li class="subnav-li" href="${baseurl}/bom/querybom.action"
								data-id="106"><a href="javascript:;" class="ue-clear"><i
									class="subnav-icon"></i><span class="subnav-text">BOM管理</span></a></li>
						</ul></li>

					<li class="nav-li"><a href="javascript:;" class="ue-clear"><i
							class="nav-ivon"></i><span class="nav-text">生产计划与排产</span></a>
						<ul class="subnav">
							<li class="subnav-li" href="${baseurl}/orders/queryorders.action"
								data-id="101"><a href="javascript:;" class="ue-clear"><i
									class="subnav-icon"></i><span class="subnav-text">生产订单管理</span></a></li>
							<li class="subnav-li"
								href="${baseurl}/decomposeorders/querydecomposeorders.action"
								data-id="103"><a href="javascript:;" class="ue-clear"><i
									class="subnav-icon"></i><span class="subnav-text">派工单管理</span></a></li>
							<li class="subnav-li"
								href="${baseurl}/workorder/queryworkorder.action" data-id="140"><a
								href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span
									class="subnav-text">工单查询</span></a></li>
						</ul></li>



					<li class="nav-li"><a href="javascript:;" class="ue-clear"><i
							class="nav-ivon"></i><span class="nav-text">条码管理</span></a>
						<ul class="subnav">


							<li class="subnav-li current"
								href="${baseurl}component/querybarcode.action" data-id="14"><a
								href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span
									class="subnav-text">部件编码</span></a></li>


							<li class="subnav-li current"
								href="${baseurl}product/querybarcode.action" data-id="15"><a
								href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span
									class="subnav-text">产品编码</span></a></li>


						</ul></li>

					
					<li class="nav-li last-nav-li"><a href="javascript:;"
						class="ue-clear"><i class="nav-ivon"></i><span
							class="nav-text">在制品管理</span></a>
						<ul class="subnav">
							<li class="subnav-li" id="cut"
								href="${baseurl}/procedurecoding/queryprocedurecoding.action?pc=cut"
								+new Date().getTime()  data-id="6"><a href="javascript:;"
								class="ue-clear"><i class="subnav-icon"></i><span
									class="subnav-text">剪板区</span></a></li>
							<li class="subnav-li" id="punch"
								href="${baseurl}/procedurecoding/queryprocedurecoding.action?pc=punch"
								+new Date().getTime() data-id="7"><a href="javascript:;"
								class="ue-clear"><i class="subnav-icon"></i><span
									class="subnav-text">冲压区</span></a></li>
							<li class="subnav-li" id="bend"
								href="${baseurl}/procedurecoding/queryprocedurecoding.action?pc=bend"
								+new Date().getTime() data-id="8"><a href="javascript:;"
								class="ue-clear"><i class="subnav-icon"></i><span
									class="subnav-text">折弯区</span></a></li>
							<li class="subnav-li" id="mfitting"
								href="${baseurl}/procedurecoding/queryprocedurecoding.action?pc=mfitting"
								+new Date().getTime() data-id="16"><a href="javascript:;"
								class="ue-clear"><i class="subnav-icon"></i><span
									class="subnav-text">机装区</span></a></li>
							<li class="subnav-li" id="efitting"
								href="${baseurl}/procedurecoding/queryprocedurecoding.action?pc=efitting"
								+new Date().getTime() data-id="17"><a href="javascript:;"
								class="ue-clear"><i class="subnav-icon"></i><span
									class="subnav-text">电装区</span></a></li>
							<li class="subnav-li" id="ffitting"
								href="${baseurl}/procedurecoding/queryprocedurecoding.action?pc=ffitting"
								+new Date().getTime() data-id="18"><a href="javascript:;"
								class="ue-clear"><i class="subnav-icon"></i><span
									class="subnav-text">总装区</span></a></li>
						</ul></li>
						
						
					<li class="nav-li last-nav-li"><a href="javascript:;"
						class="ue-clear"><i class="nav-ivon"></i><span
							class="nav-text">库存管理</span></a>
						<ul class="subnav">
							<li class="subnav-li"
								href="${baseurl}/rawstocktype/queryrawstocktype.action"
								data-id="188"><a href="javascript:;" class="ue-clear"><i
									class="subnav-icon"></i><span class="subnav-text">物料类型管理</span></a></li>
							<li class="subnav-li"
								href="${baseurl}/rawstock/queryrawstock.action" data-id="108"><a
								href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span
									class="subnav-text">物料区</span></a></li>
							<li class="subnav-li"
								href="${baseurl}/semiproducta/querysemiproducta.action"
								data-id="109"><a href="javascript:;" class="ue-clear"><i
									class="subnav-icon"></i><span class="subnav-text">半成品A区</span></a></li>
							<li class="subnav-li"
								href="${baseurl}/semiproductb/querysemiproductb.action"
								data-id="110"><a href="javascript:;" class="ue-clear"><i
									class="subnav-icon"></i><span class="subnav-text">半成品B区</span></a></li>
							<li class="subnav-li"
								href="${baseurl}/fproduct/queryfproduct.action" data-id="111"><a
								href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span
									class="subnav-text">成品区</span></a></li>
						</ul></li>
					
					<li class="nav-li"><a href="javascript:;" class="ue-clear"><i
							class="nav-ivon"></i><span class="nav-text">质量管理</span></a>
						<ul class="subnav">
							<li class="subnav-li"
								href="${baseurl}/qualitycheck/queryqualitycheck.action"
								data-id="121"><a href="javascript:;" class="ue-clear"><i
									class="subnav-icon"></i><span class="subnav-text">质检记录</span></a></li>
						</ul></li>
					
					<li class="nav-li last-nav-li"><a href="javascript:;"
						class="ue-clear"><i class="nav-ivon"></i><span
							class="nav-text">设备管理</span></a>
						<ul class="subnav">
							
							<li class="subnav-li"
								href="${baseurl}/equipmentledger/queryequipmentledger.action"
								data-id="27"><a href="javascript:;" class="ue-clear"><i
									class="subnav-icon"></i><span class="subnav-text">设备台账</span></a></li>
							<li class="subnav-li"
								href="${baseurl}/maintenance/querymaintenance.action"
								data-id="28"><a href="javascript:;" class="ue-clear"><i
									class="subnav-icon"></i><span class="subnav-text">维修保养记录</span></a></li>
							
							<li class="subnav-li"
								href="${baseurl}/toolmanagement/querytoolmanagement.action"
								data-id="26"><a href="javascript:;" class="ue-clear"><i
									class="subnav-icon"></i><span class="subnav-text">工具管理</span></a></li>		
									
						</ul></li>

					<li class="nav-li"><a href="javascript:;" class="ue-clear"><i
							class="nav-ivon"></i><span class="nav-text">统计查询</span></a>
						<ul class="subnav">
							<li class="subnav-li" href="${baseurl}/schedule/count.action"
								data-id="122"><a href="javascript:;" class="ue-clear"><i
									class="subnav-icon"></i><span class="subnav-text">生产进度统计</span></a></li>
									<li class="subnav-li" href="${baseurl}/schedule/stationcount.action" data-id="210"><a href="javascript:;"
						class="ue-clear"><i class="subnav-icon"></i><span
							class="subnav-text">工位生产量统计</span></a></li>
						</ul></li>


					


					<li class="nav-li current"><a href="javascript:;"
						class="ue-clear"><i class="nav-ivon"></i><span
							class="nav-text">系统管理</span></a> <shiro:hasPermission
							name="sysuser:query">
							<ul class="subnav">
								<li class="subnav-li current"
									href="${baseurl}/user/queryuser.action" data-id="123"><a
									href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span
										class="subnav-text">用户管理</span></a></li>
						</shiro:hasPermission> <shiro:hasPermission name="sysrole:query">
							<ul class="subnav">
								<li class="subnav-li current"
									href="${baseurl}role/queryrole.action" data-id="124"><a
									href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span
										class="subnav-text">角色管理</span></a></li>
						</shiro:hasPermission>
				</ul>
				</ul>
				</li>
				</ul>
				<div class="tree-list outwindow">
					<div class="tree ztree"></div>
				</div>
			</div>
			<div class="main">
				<div class="title">
					<i class="sidebar-show"></i>
					<ul class="tab ue-clear">

					</ul>
					<i class="tab-more"></i> <i class="tab-close"></i>
				</div>
				<div class="content"></div>
			</div>
		</div>
	</div>

	<div class="more-bab-list">
		<ul></ul>
		<div class="opt-panel-ml"></div>
		<div class="opt-panel-mr"></div>
		<div class="opt-panel-bc"></div>
		<div class="opt-panel-br"></div>
		<div class="opt-panel-bl"></div>
	</div>
</body>
<script type="text/javascript" src="js/nav.js"></script>
<script type="text/javascript" src="js/Menu.js"></script>
<script type="text/javascript" src="js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript">
	var menu = new Menu({
		defaultSelect : $('.nav').find('li[data-id="122"]')
	});

	// 左侧树结构加载
 	var setting = {};

/* 	var zNodes = [ {
		name : "操作指南",
	}];  */

	
	//$.fn.zTree.init($(".tree"), setting, zNodes);

/* 	$('.sidebar h2').click(function(e) {
		$('.tree-list').toggleClass('outwindow');
		$('.nav').toggleClass('outwindow');
	}); */

	/* $(document).click(function(e) {
		if (!$(e.target).is('.tab-more')) {
			$('.tab-more').removeClass('active');
			$('.more-bab-list').hide();
		}
	}); */
</script>
</HTML>
