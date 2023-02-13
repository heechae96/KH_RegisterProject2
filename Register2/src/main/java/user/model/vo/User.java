package user.model.vo;

import java.sql.Timestamp;

public class User {
	private String userId;
	private String userPw;
	private String userName;
	private int subjectCode;
	private String userPhoneNo;
	private Timestamp userDate;
	
	public User() {
		super();
	}
	
	public User(String userId, String userPw) {
		super();
		this.userId = userId;
		this.userPw = userPw;
	}

	public User(String userId, String userName, String userPhoneNo) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPhoneNo = userPhoneNo;
	}

	public User(String userId, String userPw, String userName, String userPhoneNo) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userPhoneNo = userPhoneNo;
	}
	
	public User(String userId, String userPw, String userName, int subjectCode, String userPhoneNo, Timestamp userDate) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.subjectCode = subjectCode;
		this.userPhoneNo = userPhoneNo;
		this.userDate = userDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(int subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getUserPhoneNo() {
		return userPhoneNo;
	}

	public void setUserPhoneNo(String userPhoneNo) {
		this.userPhoneNo = userPhoneNo;
	}

	public Timestamp getUserDate() {
		return userDate;
	}

	public void setUserDate(Timestamp userDate) {
		this.userDate = userDate;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userPw=" + userPw + ", userName=" + userName + ", subjectCode="
				+ subjectCode + ", userPhoneNo=" + userPhoneNo + ", userDate=" + userDate + "]";
	}
	
}
