package com.hitech.demo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hitech.service.UserDaoImpl;
import com.hitech.utils.CommonUtils;

public class RankingListServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html,utf-8");

		String str = request.getParameter("scoreranking");
		String username = request.getParameter("username");

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("response", str);
		map.put("userinfo", UserDaoImpl.getUserInfoJustName(username));
		map.put("gameinfo", UserDaoImpl.getGameInfo(username));
		// 待实现：服务器回送sql前十分数。
		map.put("scoreranking", UserDaoImpl.getTopTenScore());

		CommonUtils.renderJson(response, map);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
