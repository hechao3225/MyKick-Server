package com.hitech.demo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hitech.bean.UserInfo;
import com.hitech.service.UserDaoImpl;
import com.hitech.utils.CommonUtils;

public class RegistServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json,utf-8");

		String appkey = request.getHeader("appkey");

		System.out.println("appkey :: " + appkey);

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		System.out.println("Request for /regist servlet");

		System.out.println("Request Parameters :: " + username + " :: "
				+ password);

		Map<String, Object> map = new HashMap<String, Object>();

		if ("www.itechs.cn".equals(appkey)) {
			if (UserDaoImpl.dumplicate(username)) {
				// List<com.hitech.bean.Error> error = new
				// ArrayList<com.hitech.bean.Error>();
				// error.add(new com.hitech.bean.Error("regist", "账号已存在"));
				com.hitech.bean.Error error = new com.hitech.bean.Error(
						"regist", "该账号已存在");
				map.put("response", "error");
				map.put("error", error);
			} else {
				int uid = UserDaoImpl.regist(new UserInfo(0, username,
						password, null, null, null));
				map.put("response", "regist");
				UserInfo info = new UserInfo(uid, username, password, null,
						null, null);
				request.getSession().setAttribute(username, info);
				map.put("userinfo", info);
			}
			CommonUtils.renderJson(response, map);
		}
	}
}
