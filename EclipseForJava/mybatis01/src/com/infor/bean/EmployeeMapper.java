/**
 * Copyright (C)，2019-2019,Infor
 * Author: lli3
 * Description EmployeeMapper
 */

package com.infor.bean;

//员工的实体类，负责数据库中的表(记录)
public class EmployeeMapper {

    private String id;
    private String name;
    private char gender;
    private String address;

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
}
