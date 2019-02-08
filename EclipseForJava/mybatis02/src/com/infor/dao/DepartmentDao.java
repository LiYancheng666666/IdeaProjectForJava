/**
 * Copyright (C)��2019-2019,Infor
 * Author: lli3
 * Description Test EmployeeDao
 */

package com.infor.dao;

import com.infor.bean.Department;
import com.infor.bean.Employee;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface DepartmentDao {
	
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

    //����id��ѯ������Ϣ
	public Department getDepartmentById(String id);
    
   
}
