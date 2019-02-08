/**
 * Copyright (C)��2019-2019,Infor
 * Author: lli3
 * Description Test EmployeeDao
 */

package com.infor.dao;

import com.infor.bean.Employee;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface EmployeeDao {
	
	/**
	 * 1.��������Mybatis���������⴦��
	 * #{sjjjkkk}
	 * 2.�������pojo...
	 *    #{�������������}
	 *    
	 * 3.���������mybatis�����⴦����Ѵ���Ĳ����Զ���װ��map����
	 *   map��keyֵ���Ǵ�param1....paramN
	 * 
	 * 		map.put("param1",name);
	 *	 	map.put("param2",gender)
	 *		@Param("name") ����ʹ�����ע�� ������Map��װ���ݵ�keyֵ
	 *
	 *4.ֱ�Ӵ���map
	 *
	 *5.Collection(����)����(List,Set),����
	 */

    //��ѯ����
    public List<Employee> selAll();
    
    //��ѯ����
    public List<Employee> selAll2();
    
    public List<Employee> selAll3();
    
    public Employee selectStep(String id);
    //��ѯ��һ
    public Employee selOne(String id);
    
    //����
    public void insertEmp(Employee emp);
    
    //�޸�
    public void updateEmp(Employee emp);
    
    //ɾ��
    public void deleteEmp(String id);
    
    //��������ѯ
    public List<Employee> queryList(@Param("name") String name,@Param("gender")char gender);
    
    //��������ѯ
    public List<Employee> queryList2(Map map);
    
    //��̬sql  ...if
    public List<Employee> queryByIf(Employee emp);
    
    //��̬sql  ...choose
    public List<Employee> queryByChoose(Employee emp);
    
    //��̬sql  ...Trim
    public List<Employee> queryByTrim(Employee emp);
    
    //��̬sql  ...Where
    public List<Employee> queryByWhere(Employee emp);
    
    //��������
    public Integer deleteByList(List<Employee> emp);
    
    public Integer deleteByArray(String[] strs);
}
