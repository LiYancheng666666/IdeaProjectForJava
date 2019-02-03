package com.infor.test;

import java.io.IOException;
import java.io.Reader;

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
        	emp.setId("10");
        	emp.setName("王八蛋");
        	emp.setGender('1');
        	emp.setAddress("丑女");
//        	empDao.updateEmp(emp);
//        	empDao.insertEmp(emp);
        	empDao.deleteEmp("10");
        	
        	sqlSession.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

}
