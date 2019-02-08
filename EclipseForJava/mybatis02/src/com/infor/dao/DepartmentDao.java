/**
 * Copyright (C)，2019-2019,Infor
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
	 * 1.单个参数Mybatis不会做特殊处理
	 * #{sjjjkkk}
	 * 2.传入对象pojo...
	 *    #{对象的属性名称}
	 *    
	 * 3.多个参数，mybatis做特殊处理，会把传入的参数自动封装成map类型
	 *   map的key值就是从param1....paramN
	 * 
	 * 		map.put("param1",name);
	 *	 	map.put("param2",gender)
	 *		@Param("name") 可以使用这个注解 来定义Map封装数据的key值
	 *
	 *4.直接传入map
	 *
	 *5.Collection(集合)类型(List,Set),数组
	 */

    //根据id查询部门信息
	public Department getDepartmentById(String id);
    
   
}
