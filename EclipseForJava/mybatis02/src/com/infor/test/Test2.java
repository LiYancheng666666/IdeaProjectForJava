package com.infor.test;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.infor.bean.Employee;
import com.infor.dao.EmployeeDao;

public class Test2 {
	public static void main(String[] args) throws IOException {
		 //获得当前Mybatis总的配置文件路径
        String resource = "resource.xml";
       
        //获得当前文件输入流。。。
        Reader reader = Resources.getResourceAsReader(resource);
        //通过流对象来创建sqlsessionfactory对象，数据会话工厂
        SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
        //true表示自动提交，否则需要使用commit方法才会提交，默认是false
        SqlSession sqlSession = sqlMapper.openSession();

        //创建接口对象，这个session通过动态代理自动帮我们创建的，Proxy代理。。
        EmployeeDao empDao = sqlSession.getMapper(EmployeeDao.class);
        try {
        	Employee emp =new Employee();
//        	emp.setId("10");
//        	emp.setName("李");
//        	emp.setGender('1');
//        	emp.setAddress("富士康");
//        	empDao.updateEmp(emp);
//        	empDao.insertEmp(emp);
//        	empDao.deleteEmp("10");
//        	List<Employee> list = empDao.queryList("王", '1');
//        	Map map = new HashMap();
//        	map.put("name","王");
//        	map.put("gender", '1');
//        	List<Employee> list = empDao.queryByIf(emp);
//        	List<Employee> list = empDao.queryByTrim(emp);
//        	List<Employee> list = empDao.queryByChoose(emp);
//        	List<Employee> list = empDao.queryList2(map);
//        	List<Employee> list = empDao.queryByWhere(emp);
//        	System.out.println(list.size());
        	
//        	List list = new ArrayList();
//        	list.add("1");
//        	list.add("2");
//        	int x = empDao.deleteByList(list);
//        	String [] strs = {"3","4"};
//        	int x = empDao.deleteByArray(strs);
//         	System.out.println("count is " + x);
        	
//        	List<Employee> list = empDao.selAll3();
//        	System.out.println(list);
        	
        	Employee emp1 =empDao.selectStep("1");
        	String name = emp1.getName();
        	System.out.println(name);
        	
        	sqlSession.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

}
