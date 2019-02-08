/**
 * Copyright (C)，2019-2019,Infor
 * Author: lli3
 * Description EmployeeMapper
 */

package com.infor.bean;

import java.io.Serializable;

//员工的实体类，负责数据库中的表(记录)
public class Employee implements Serializable{

    private String id;
    private String name;
    private char gender;
    private String address;

    private Department dept;
   
    public Employee() {
    	
	}



    
	public String getId() {
        return id;
    }

   

	public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }




	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", gender=" + gender + ", address=" + address + ", dept="
				+ dept + "]";
	}
    
   
}
