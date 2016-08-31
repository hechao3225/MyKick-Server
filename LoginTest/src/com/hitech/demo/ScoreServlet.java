package com.hitech.demo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hitech.bean.GameInfo;
import com.hitech.service.UserDaoImpl;
import com.hitech.utils.CommonUtils;

public class ScoreServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html,utf-8");

		String username = request.getParameter("username");
		String score = request.getParameter("score");
		int score_int = 0;
		try {
			score_int = Integer.parseInt(score);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		Map<String, Object> map = new HashMap<String, Object>();
		GameInfo gameinfo = UserDaoImpl.getGameInfo(username);

		gameinfo.setScore(score_int);
		UserDaoImpl.setGameInfo(gameinfo, username);
		// 回传上传结果
		map.put("response", "upload score");
		map.put("userinfo", UserDaoImpl.getUserInfoJustName(username));
		map.put("gameinfo", UserDaoImpl.getGameInfo(username));

		CommonUtils.renderJson(response, map);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
