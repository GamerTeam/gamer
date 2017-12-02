package cn.gt.controller.user;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Reader;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import cn.gt.pojo.User;
import cn.gt.service.user.UserService;

@Controller
@RequestMapping("/log")
public class LogController {

	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	//更新profile.jsp中的个人头像
	@RequestMapping("/upload")
	@ResponseBody
	public String upload(HttpServletRequest request, HttpServletResponse response){
		Map map = null;
		boolean flags = true;
	//将裁剪图片的dataURL数据写进本地
		//图片的二进制数据
		int uId = (Integer)request.getSession().getAttribute("uId");
		if(uId != 0){
			flags = false;
			//图片的数据
			String dataURL = request.getParameter("dataURL");
			//图片的存储路径
			String realPath = request.getSession().getServletContext().getRealPath("statics"+ File.separator+"uploadfiles");
			File targetFile = new File(realPath);
			//图片数据所在的文件
			String fileName = System.currentTimeMillis()+ RandomUtils.nextInt(1000000)+"_Personal"+uId+".txt";
			File files = new File(fileName);
			//图片存储在本地的地址
			String imgURL = realPath+File.separator+files;
			// 判断路径是否存在，不存在就新建这个路径
	        if(!targetFile.exists()){
	            targetFile.mkdirs();
	        }
	        Writer w = null;
	        try {
				w = new FileWriter(imgURL);
				w.write(dataURL);
				w.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
					try {
						if(w != null){
							w.close();
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
	    //将文件对应的地址写进数据库
	        User user = new User();
	        user.setuId(uId);
	        user.setImg(imgURL);
	        boolean flag = userService.upload(user);
	        if(flag){
	        	request.getSession().setAttribute("dataURL", dataURL);
	        }
	        map = new HashMap<>(); 
	        map.put("flag", flag);
//	        map.put("URL", dataURL);
	        map.put("flags", flags);
		}
        return JSON.toJSONString(map);
		
	}
	
	//更新profile.jsp中的个人信息
	@RequestMapping("/uploadInfo")
	@ResponseBody
	public String uploadInfo(HttpServletRequest request, HttpServletResponse response){
		String userName = request.getParameter("userName");
		String nickName = request.getParameter("nickName");
		String gameName = request.getParameter("gameName");
		String info = request.getParameter("info");
		int uId = (Integer) request.getSession().getAttribute("uId");
		User user = new User();
		user.setuId(uId);
		user.setUserName(userName);
		user.setNickName(nickName);
		user.setGameName(gameName);
		user.setInfo(info);
		boolean flag = userService.uploadInfo(user);
		if(flag){
			request.getSession().setAttribute("user", user);
		}
		return JSON.toJSONString(flag);
		
	}


	// 登出
	@RequestMapping("/logout")
	public void logout(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().invalidate();

	}

	// 登录
	@RequestMapping("/selectUser")
	@ResponseBody
	public String selectUser(HttpServletRequest request, HttpServletResponse response) {
		String userName = request.getParameter("userName");
		String userPwd = request.getParameter("userPwd");
		User user = new User();
		user.setName(userName);
		user.setPwd(userPwd);
		User users = userService.selectUser(user);
		Map map = null;
		if(users != null){
			int uId = users.getuId();
			request.getSession().setAttribute("loginName", userName);
			request.getSession().setAttribute("uId", uId);
			map = selectUserInfo(uId, request, response);
			request.getSession().setAttribute("info", map);
		}
		return JSON.toJSONString(map);

	}
	//获取用户信息
	public Map selectUserInfo(int uId, HttpServletRequest request, HttpServletResponse response){
		User users = userService.selectUserInfo(uId);
		String dataURL = null;
		String img =users.getImg();
		if(img == null || img == ""){
			File file = new File(img);
			Reader r = null;
			try {
				r = new FileReader(file);
				char[] c = new char[1000];
				try {
					int i = r.read(c);
					dataURL = new String(c, 0, i);
					System.out.println(dataURL);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					r.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		Map map = new HashMap<>();
		map.put("userInfo", users);
		map.put("dataURL", dataURL);
		return map;
		
	}

}
