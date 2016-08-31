package com.hitech.service;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.hitech.bean.GameInfo;
import com.hitech.bean.UserInfo;
import com.hitech.db.MysqlHelper;

public class UserDaoImpl {
	public String topTenScore;

	public static boolean dumplicate(String username) {
		QueryRunner runner = new QueryRunner(MysqlHelper.getDataSource());
		UserInfo info = null;
		try {
			info = runner.query("SELECT uname FROM users WHERE uname=?",
					new BeanHandler<UserInfo>(UserInfo.class), username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return info != null;
	}

	public static int regist(UserInfo info) {
		QueryRunner runner = new QueryRunner(MysqlHelper.getDataSource());
		int i = -1;
		try {
			i = runner.update(
					"INSERT INTO users(uid,uname,upass) VALUES(NULL,?,?)",
					info.uname, info.upass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	// 更新功能：修改用户信息
	public static int setUserInfo(UserInfo newinfo, String username) {
		QueryRunner runner = new QueryRunner(MysqlHelper.getDataSource());
		int i = -1;
		try {
			i = runner
					.update("UPDATE users SET uname=?,upass=?,ucity=?,uphone=?,uqq=? WHERE uname=?",
							newinfo.uname, newinfo.upass, newinfo.ucity,
							newinfo.uphone, newinfo.uqq, username);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	// 更新功能：修改游戏数据
	public static int setGameInfo(GameInfo newinfo, String username) {
		QueryRunner runner = new QueryRunner(MysqlHelper.getDataSource());
		int i = -1;
		try {
			i = runner.update(
					"UPDATE users SET score=?,level=?,money=? WHERE uname=?",
					newinfo.score, newinfo.level, newinfo.money, username);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	public static UserInfo getUserInfo(String username, String password) {
		QueryRunner runner = new QueryRunner(MysqlHelper.getDataSource());
		UserInfo user = new UserInfo();
		try {
			user = runner.query(
					"SELECT * FROM users WHERE uname=? AND upass=?",
					new BeanHandler<UserInfo>(UserInfo.class), username,
					password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public static UserInfo getUserInfoJustName(String username) {
		QueryRunner runner = new QueryRunner(MysqlHelper.getDataSource());
		UserInfo user = new UserInfo();
		try {
			user = runner.query("SELECT * FROM users WHERE uname=?",
					new BeanHandler<UserInfo>(UserInfo.class), username);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public static GameInfo getGameInfo(String username) {
		QueryRunner runner = new QueryRunner(MysqlHelper.getDataSource());
		GameInfo gameinfo = new GameInfo();

		try {
			gameinfo = runner.query("SELECT * FROM users WHERE uname=?",
					new BeanHandler<GameInfo>(GameInfo.class), username);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return gameinfo;
	}

	public static String getTopTenScore() {
		QueryRunner runner = new QueryRunner(MysqlHelper.getDataSource());
		String topTenScore = null;
		try {
			topTenScore = runner.query(
					"SELECT * FROM users ODRER　BY score DESC　LIMIT 10 ",
					new BeanHandler<String>(String.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return topTenScore;
	}

}
