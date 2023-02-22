package com.hc.register;

public class Elert {
	
	private String pageUrl;
	private String elertMessage;

	public Elert() {
		super();
	}

	public Elert(String pageUrl, String elertMessage) {
		super();
		this.pageUrl = pageUrl;
		this.elertMessage = elertMessage;
	}
	
	public String getPageUrl() {
		return pageUrl;
	}

	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}

	public String getElertMessage() {
		return elertMessage;
	}

	public void setElertMessage(String elertMessage) {
		this.elertMessage = elertMessage;
	}

	@Override
	public String toString() {
		return "Elert [pageUrl=" + pageUrl + ", elertMessage=" + elertMessage + "]";
	}

}
