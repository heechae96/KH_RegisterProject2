package subject.model.vo;

import java.sql.Date;

public class Subject {
	private String subjectName;
	private String subjectCode;
	private String name;
	private int enrollNo;
	private int maxNo;
	private Date startDate;
	private Date endDate;
	
	public Subject() {
		super();
	}

	public Subject(String subjectName, String subjectCode, String name, int enrollNo, int maxNo, Date startDate,
			Date endDate) {
		super();
		this.subjectName = subjectName;
		this.subjectCode = subjectCode;
		this.name = name;
		this.enrollNo = enrollNo;
		this.maxNo = maxNo;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEnrollNo() {
		return enrollNo;
	}

	public void setEnrollNo(int enrollNo) {
		this.enrollNo = enrollNo;
	}

	public int getMaxNo() {
		return maxNo;
	}

	public void setMaxNo(int maxNo) {
		this.maxNo = maxNo;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "Subject [subjectName=" + subjectName + ", subjectCode=" + subjectCode + ", name=" + name + ", enrollNo="
				+ enrollNo + ", maxNo=" + maxNo + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
	
}
