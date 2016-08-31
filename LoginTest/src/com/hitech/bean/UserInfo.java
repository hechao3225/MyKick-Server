package com.hitech.bean;

//更新：添加ucity、uphoe、uqq
public class UserInfo {

	public int uid;
	public String uname;
	public String upass;
	public String ucity;
	public String uphone;
	public String uqq;

	public UserInfo() {
		super();
	}

	public UserInfo(int uid, String uname, String upass, String ucity,
			String uphone, String uqq) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upass = upass;
		this.ucity = ucity;
		this.uphone = uphone;
		this.uqq = uqq;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpass() {
		return upass;
	}

	public void setUpass(String upass) {
		this.upass = upass;
	}

	public String getUcity() {
		return ucity;
	}

	public void setUcity(String ucity) {
		this.ucity = ucity;
	}

	public String getUphone() {
		return uphone;
	}

	public void setUphone(String uphone) {
		this.uphone = uphone;
	}

	public String getUqq() {
		return uqq;
	}

	public void setUqq(String uqq) {
		this.uqq = uqq;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + uid;
		result = prime * result + ((uname == null) ? 0 : uname.hashCode());
		result = prime * result + ((upass == null) ? 0 : upass.hashCode());
		// result = prime * result + ((ucity== null) ? 0 : ucity.hashCode());
		// result = prime * result + ((uphone== null) ? 0 : uphone.hashCode());
		// result = prime * result + ((uqq== null) ? 0 : uqq.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserInfo other = (UserInfo) obj;
		if (uid != other.uid)
			return false;
		if (uname == null) {
			if (other.uname != null)
				return false;
		} else if (!uname.equals(other.uname))
			return false;
		if (upass == null) {
			if (other.upass != null)
				return false;
		} else if (!upass.equals(other.upass))
			return false;
		return true;
	}
}
