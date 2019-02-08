/**
 * Copyright (C)，2019-2019,Infor
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

    //查询所有
    public List<Employee> selAll();
    
    //查询所有
    public List<Employee> selAll2();
    
    public List<Employee> selAll3();
    
    public Employee selectStep(String id);
    //查询单一
    public Employee selOne(String id);
    
    //新增
    public void insertEmp(Employee emp);
    
    //修改
    public void updateEmp(Employee emp);
    
    //删除
    public void deleteEmp(String id);
    
    //多条件查询
    public List<Employee> queryList(@Param("name") String name,@Param("gender")char gender);
    
    //多条件查询
    public List<Employee> queryList2(Map map);
    
    //动态sql  ...if
    public List<Employee> queryByIf(Employee emp);
    
    //动态sql  ...choose
    public List<Employee> queryByChoose(Employee emp);
    
    //动态sql  ...Trim
    public List<Employee> queryByTrim(Employee emp);
    
    //动态sql  ...Where
    public List<Employee> queryByWhere(Employee emp);
    
    //批量操作
    public Integer deleteByList(List<Employee> emp);
    
    public Integer deleteByArray(String[] strs);
}
