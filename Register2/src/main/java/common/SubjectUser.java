package common;

import java.sql.Timestamp;

public class SubjectUser {
	private String userId;
	private String userPw;
	private String userName;
	private int subjectCode;
	private String subjectName;
	private String userPhoneNo;
	private Timestamp userDate;
	
	public SubjectUser() {
		super();
	}

	public SubjectUser(String userId, String userPw, String userName, int subjectCode, String subjectName,
			String userPhoneNo, Timestamp userDate) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.subjectCode = subjectCode;
		this.subjectName = subjectName;
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

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
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
		return "SubjectUser [userId=" + userId + ", userPw=" + userPw + ", userName=" + userName + ", subjectCode="
				+ subjectCode + ", subjectName=" + subjectName + ", userPhoneNo=" + userPhoneNo + ", userDate="
				+ userDate + "]";
	}
	
}
