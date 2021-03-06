<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<meta name="robots" content="all">
<meta name="keywords" content="">
<meta name="description" content="">
<title>游戏先生</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/game.css" />

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/reset.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/profile.css"/>
<script src="${pageContext.request.contextPath }/js/jquery-3.2.1.min.js" type="text/javascript" charset="utf-8"></script>
<script language="JavaScript" src="../js/center.js"></script>
<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
<script src="../plugins/cover_js/iscroll-zoom.js" type="text/javascript" charset="utf-8"></script>
<script src="../plugins/cover_js/hammer.js" type="text/javascript" charset="utf-8"></script>
<script src="../plugins/cover_js/lrz.all.bundle.js" type="text/javascript" charset="utf-8"></script>
<script src="../plugins/cover_js/jquery.photoClip.min.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
	<div align="center">
		<nav class="navbar navbar-default navbar-fixed-top m-b-n">
		<div class="container-fluid">
			<div>
				<div class="gameLogo"></div>
			</div>
			<div class="navbar-right input-group">
				<ul id="menu">
					<li><a href=''>博客</a></li>
					<li><a href='${pageContext.request.contextPath }/signIn.jsp'>寻找先生</a></li>
					<li><a>个人中心</a></li>
				</ul>
			</div>
		</div>
		</nav>
		<div class="container-fluid bg-img">
			<div class="row">
				<div class="col-xs-2 index-left " id="leftBar">
					<span class="pull-right scaleButton" aria-hidden="true" id="toggleFlag"><</span>
					<div class="text-center m-t-30">
						<img id='userProfile' src='${pageContext.request.contextPath }/images/anon.png' alt="profile"
							class="img-responsive center-block needToggle" />
					</div>
					<div class="listInfo">
						<a href="#"> <img src="../images/dashboard_nav_calendar.png"
							alt="course" class="img-responsive imageInline" />
						</a>
						<h4 id="courseName" class='needToggle blueColor'>课程</h4>
						<ul>
							<li class="listClick" id="unScheduled"><a
								href="unScheduled.html" class='needToggle needToChangeBack'>未预订时间表</a></li>
							<li class="listClick" id="calender"><a href="calender.html"
								class="needToggle">日程表</a></li>
							<li class="listClick" id="listView"><a href="listView.html"
								class='needToggle'>列表试图</a></li>
							<li class="listClick" id="myReviews"><a
								href="myReviews.html" class='needToggle'>我的评论</a></li>
							<li class="listClick" id="getFreeLessons"><a
								href="getFreeLessons.html" class='needToggle'>免费课程</a></li>
						</ul>
					</div>
					<div class="listInfo">
						<a href="#"> <img src="${pageContext.request.contextPath }/images/dashboard_nav_wallet.png"
							alt="wallet" class="img-responsive imageInline" />
						</a>
						<h4 id="walletName" class='needToggle blueColor'>钱包</h4>
						<ul>
							<li class="listClick" id="summary"><a href="summary.html"
								class='needToggle'>概要</a></li>
							<li class="listClick" id="mySubscription"><a
								href="mySubscription.html" class="needToggle">我的预订</a></li>
							<li class="listClick" id="history"><a href="history.html"
								class='needToggle'>历史记录</a></li>
						</ul>
					</div>
					<div class="listInfo">
						<a href="#"> <img
							src="${pageContext.request.contextPath }/images/dashboard_nav_preferences.png" alt="wallet"
							class="img-responsive imageInline" />
						</a>
						<h4 id="preferenceName" class='needToggle blueColor'>设置</h4>
						<ul>
							<li class="listClick" id="userProfile"><a
								href="userProfile.html" class='needToggle'>个人信息</a></li>
							<li class="listClick" id="accountSetting"><a
								href="accountSetting.html" class="needToggle">账户设置</a></li>
							<li class="listClick" id="paymentOptions"><a
								href="paymentOptions.html" class='needToggle'>支付方式</a></li>
						</ul>
					</div>
					<p class='needToggle listClick'>
						<button onclick="logout()">注销</button>
					</p>
				</div>
			<script type="text/javascript" src="${pageContext.request.contextPath }/js/side.js"></script>
				