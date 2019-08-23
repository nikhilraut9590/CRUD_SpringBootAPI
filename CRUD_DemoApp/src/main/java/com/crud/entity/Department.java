package com.crud.entity;

public class Department {
	private Integer departId;
	private String departName;
	private String city;
	public Integer getDepartId() {
		return departId;
	}
	public void setDepartId(Integer departId) {
		this.departId = departId;
	}
	public String getDepartName() {
		return departName;
	}
	public void setDepartName(String departName) {
		this.departName = departName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Department(Integer departId, String departName, String city) {
		super();
		this.departId = departId;
		this.departName = departName;
		this.city = city;
	}
}
