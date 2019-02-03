/**
 * Copyright (C)��2019-2019,Infor
 * Author: lli3
 * Description Test EmployeeDao
 */

package com.infor.dao;

import com.infor.bean.Employee;

import java.util.List;

public interface EmployeeDao {

    //��ѯ����
    public List<Employee> selAll();
    //��ѯ��һ
    public Employee selOne(String id);
    
    //����
    public void insertEmp(Employee emp);
    
    //�޸�
    public void updateEmp(Employee emp);
    
    //ɾ��
    public void deleteEmp(String id);
    
}
