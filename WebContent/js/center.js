var userName = $("input[name='userName']");
var nickName = $("input[name='nickName']");
var gameName = $("select");
var info = $("input[name='info']");
$(document).ready(function() {


// 更新profile中的个人信息
$("#sbt").click(function() {
	userName = userName.val();
	nickName = nickName.val();
	gameName = gameName.find("option:selected").text();
	info = info.val();
	$.ajax({
		url : "../log/uploadInfo",
		type : "post",
		data : {
			userName : userName,
			nickName : nickName,
			gameName : gameName,
			info : info
		},
		dataType : "json",
		async : false,//同步
		success : function(data) {
			if (data == true) {
				htmlobj = $.ajax({url:"../jsp/profile_info.jsp",async:false});
				$("#div").html(htmlobj.responseText);
				return false;
			}
		},
		error : function() {
			alert("error");
		},
	})
})


//更新profile.jsp中的头像
var clipArea = new bjj.PhotoClip("#clipArea", {
	size: [428, 321],// 截取框的宽和高组成的数组。默认值为[260,260]
	outputSize: [428, 321], // 输出图像的宽和高组成的数组。默认值为[0,0]，表示输出图像原始大小
	//outputType: "jpg", // 指定输出图片的类型，可选 "jpg" 和 "png" 两种种类型，默认为 "jpg"
	file: "#file", // 上传图片的<input type="file">控件的选择器或者DOM对象
	view: "#view", // 显示截取后图像的容器的选择器或者DOM对象
	ok: "#clipBtn", // 确认截图按钮的选择器或者DOM对象
	loadStart: function() {
		// 开始加载的回调函数。this指向 fileReader 对象，并将正在加载的 file 对象作为参数传入
		$('.cover-wrap').fadeIn();
		console.log("照片读取中");
	},
	loadComplete: function() {
		 // 加载完成的回调函数。this指向图片对象，并将图片地址作为参数传入
		console.log("照片读取完成");
	},
	//loadError: function(event) {}, // 加载失败的回调函数。this指向 fileReader 对象，并将错误事件的 event 对象作为参数传入
	clipFinish: function(dataURL) {
		 // 裁剪完成的回调函数。this指向图片对象，会将裁剪出的图像数据DataURL作为参数传入
		$('.cover-wrap').fadeOut();
		$('#view').css('background-size','100% 100%');
		upload(dataURL);
	}
});

function upload(dataURL){
	$.ajax({
		url:"../log/upload",
		type:"post",
		dataType:"json",
		data:{dataURL:dataURL},
		async:false,
		success:function(data){
			if(data.flags){
				alert("请登录！");
				return;
			}else if(data.flag){
				htmlobj = $.ajax({url:"../jsp/profile_pic.jsp",async:false});
				$("#changeImg").html(htmlobj.responseText);
				return false;
			}
		},
		error:function(data){
			alert("error");
			return;
		}
	})
}
})