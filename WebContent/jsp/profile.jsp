<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="/jsp/common/side.jsp" %>
<form >
	<div class="col-xs-10 right-center">
		<ol class="dashboardLink">界面展示&gt;课程</ol>
		<div class="selectionInfo col-xs-10">
			<div class="selection-header">
				<h3>个人信息</h3>
			</div>

			<div class="cover-wrap">	
				<div class="cut">
					<div id="clipArea"></div>
					<div class="">
						<button id="clipBtn">保存封面</button>
					</div>
				</div>
			</div>

			<div class="selection-body col-xs-10">
				<div class="col-xs-4 userProfileStyle" id="changeImg">
					<img src="${info.dataURL }" alt="profile" class="img-responsive center-block profileStyle" id="view" /><!-- id="profileID" -->
					<button class="buttonRadis buttonTochangeFile" id="changePorfileID">更换头像</button>
					<input type="file" class="buttonRadis buttonTochangeFile" id="file"/>
				</div>
				
				<div class="col-xs-8 formLeft" id="div">
					<div class="profile-input-box blockStyle">
						<label for="userNameI" class="blockStyle">姓名</label> 
						<input id="userNameI" class="profile-input" name="userName" value="${info.userInfo.name }"/>
					</div>
					<div class="profile-input-box blockStyle">
						<label for="screenNameI" class="blockStyle">本地昵称</label> 
						<input id="screenNameI" class="profile-input" name="nickName" value="${info.userInfo.userName }"/>
					</div>
					<div class="profile-input-box blockStyle">
						<label for="gameNameI" class="blockStyle">游戏名字</label>
						<select id="screenNameI" class="profile-input" name="gameName" value="${info.userInfo.gameName }">
							<option>王者荣耀</option>
							<option>英雄联盟</option>
							<option>魔兽</option>
							<option>地下城与勇士</option>
						</select>
					</div>
					<div class="profile-input-introduce-box blockStyle">
						<label for="userNameII" class="blockStyle">自我介绍</label> 
						<input id="userNameII" class="profile-input-introduce" name="info" value="${info.userInfo.info }"/>
					</div>
					<button id="sbt">提交</button>
				</div>
			</div>
		</div>
	</div>
</form>
	</div>
	</div>
	
	
	<script src="../js/center.js"></script>
	</div>
</body>
</html>