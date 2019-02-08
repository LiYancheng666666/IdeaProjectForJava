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

public class TestCache {
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
        	
        	//在新的sqlsession对象，使用二级缓存中的数据的时候，需要先将前面的sqlsession对象
        	//关闭，数据才能进入到二级缓存中
        	long s1 = System.currentTimeMillis();
        	List<Employee> emps =empDao.selAll();
        	System.out.println(emps);
        	long s2 = System.currentTimeMillis();
        	System.out.println("第一次执行的时间 " + (s2-s1));
        	
        	sqlSession.close();
        	
        	SqlSession sqlSession2 = sqlMapper.openSession();

            //创建接口对象，这个session通过动态代理自动帮我们创建的，Proxy代理。。
            EmployeeDao empDao2 = sqlSession2.getMapper(EmployeeDao.class);
        	
        	long s3 = System.currentTimeMillis();
        	List<Employee> emps2 =empDao2.selAll();
        	System.out.println(emps2);
        	long s4 = System.currentTimeMillis();
        	System.out.println("第二次执行的时间 " + (s4-s3));
			
        	/*
        	 * 二级缓存,namespace级别(一个xml文件对应我们的一个二级缓存)
        	 * 二级缓存需要我们手动的配置和开启
        	 * 2.1 在总的配置文件中设置开启我们的二级缓存
        	 * <setting name="cacheEnabled value= "true">
        	 * 2.2需要在映射文件中添加，cache标签
        	 */
        	
        	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

}
