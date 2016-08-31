package com.hitech.demo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hitech.bean.Error;
import com.hitech.bean.UserInfo;
import com.hitech.service.UserDaoImpl;
import com.hitech.utils.CommonUtils;

public class SetServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html,utf-8");

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String usercity = request.getParameter("usercity");
		String userphone = request.getParameter("userphone");
		String userqq = request.getParameter("userqq");

		Map<String, Object> map = new HashMap<String, Object>();
		UserInfo userset = UserDaoImpl.getUserInfoJustName(username);
		if (userset == null) {
			// 数据库中不存在与定用户名匹配的记录
			map.put("response", "error");
			map.put("error", new Error("response", "用户名填写错误"));
		} else {
			userset.upass = password;
			userset.ucity = usercity;
			userset.uphone = userphone;
			userset.uqq = userqq;

			UserDaoImpl.setUserInfo(userset, username);
			map.put("response", "set");

			map.put("userinfo", UserDaoImpl.getUserInfo(username, password));
		}
		CommonUtils.renderJson(response, map);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
