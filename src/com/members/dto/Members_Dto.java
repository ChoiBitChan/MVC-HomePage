package com.members.dto;

public class Members_Dto {
	
	String id;
	String pw;
	String name;
	
	public Members_Dto() {
		// TODO Auto-generated constructor stub
	}
	
	public Members_Dto(String id, String pw, String name) {
		this.id = id;
		this.pw = pw;
		this.name = name;
	}
	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
