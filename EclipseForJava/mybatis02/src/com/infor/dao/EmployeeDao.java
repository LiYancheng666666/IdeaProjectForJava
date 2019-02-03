/**
 * Copyright (C)，2019-2019,Infor
 * Author: lli3
 * Description Test EmployeeDao
 */

package com.infor.dao;

import com.infor.bean.Employee;

import java.util.List;

public interface EmployeeDao {

    //查询所有
    public List<Employee> selAll();
    //查询单一
    public Employee selOne(String id);
    
    //新增
    public void insertEmp(Employee emp);
    
    //修改
    public void updateEmp(Employee emp);
    
    //删除
    public void deleteEmp(String id);
    
}
