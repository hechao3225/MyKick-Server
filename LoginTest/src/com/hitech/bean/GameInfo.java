package com.hitech.bean;

public class GameInfo {
	public String uname;
	public int score;// 玩家上传的分数
	public int level;// 玩家等级
	public int money;// 玩家金币

	public GameInfo() {
		super();
	}

	public GameInfo(String uname, int score, int level, int money) {
		super();
		this.uname = uname;
		this.score = score;
		this.level = level;
		this.money = money;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

}
