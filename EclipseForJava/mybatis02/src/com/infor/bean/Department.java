package com.infor.bean;

import java.io.Serializable;

public class Department implements Serializable{
	
	private String d_id;
	private String d_name;
	public String getD_id() {
		return d_id;
	}
	public void setD_id(String d_id) {
		this.d_id = d_id;
	}
	public String getD_name() {
		return d_name;
	}
	public void setD_name(String d_name) {
		this.d_name = d_name;
	}
	@Override
	public String toString() {
		return "Department [d_id=" + d_id + ", d_name=" + d_name + "]";
	}
	
	

}
