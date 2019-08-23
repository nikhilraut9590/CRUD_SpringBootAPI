package com.crud.entity;

public class Phone {
	/*
	 * private String faxnumber; private String homeNumber;
	 * 
	 * public Phone(String faxnumber, String homeNumber) { super(); this.faxnumber =
	 * faxnumber; this.homeNumber = homeNumber; }
	 * 
	 * public String getFaxnumber() { return faxnumber; }
	 * 
	 * public void setFaxnumber(String faxnumber) { this.faxnumber = faxnumber; }
	 * 
	 * public String getHomeNumber() { return homeNumber; }
	 * 
	 * public void setHomeNumber(String homeNumber) { this.homeNumber = homeNumber;
	 * }
	 */
	
	private String type;
	private String number;
	public Phone(String type, String number) {
		super();
		this.type = type;
		this.number = number;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
}
