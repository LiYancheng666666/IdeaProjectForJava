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
		 //��õ�ǰMybatis�ܵ������ļ�·��
        String resource = "resource.xml";
       
        //��õ�ǰ�ļ�������������
        Reader reader = Resources.getResourceAsReader(resource);
        //ͨ��������������sqlsessionfactory�������ݻỰ����
        SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
        //true��ʾ�Զ��ύ��������Ҫʹ��commit�����Ż��ύ��Ĭ����false
        SqlSession sqlSession = sqlMapper.openSession();

        //�����ӿڶ������sessionͨ����̬�����Զ������Ǵ����ģ�Proxy������
        EmployeeDao empDao = sqlSession.getMapper(EmployeeDao.class);
        try {
        	
        	//���µ�sqlsession����ʹ�ö��������е����ݵ�ʱ����Ҫ�Ƚ�ǰ���sqlsession����
        	//�رգ����ݲ��ܽ��뵽����������
        	long s1 = System.currentTimeMillis();
        	List<Employee> emps =empDao.selAll();
        	System.out.println(emps);
        	long s2 = System.currentTimeMillis();
        	System.out.println("��һ��ִ�е�ʱ�� " + (s2-s1));
        	
        	sqlSession.close();
        	
        	SqlSession sqlSession2 = sqlMapper.openSession();

            //�����ӿڶ������sessionͨ����̬�����Զ������Ǵ����ģ�Proxy������
            EmployeeDao empDao2 = sqlSession2.getMapper(EmployeeDao.class);
        	
        	long s3 = System.currentTimeMillis();
        	List<Employee> emps2 =empDao2.selAll();
        	System.out.println(emps2);
        	long s4 = System.currentTimeMillis();
        	System.out.println("�ڶ���ִ�е�ʱ�� " + (s4-s3));
			
        	/*
        	 * ��������,namespace����(һ��xml�ļ���Ӧ���ǵ�һ����������)
        	 * ����������Ҫ�����ֶ������úͿ���
        	 * 2.1 ���ܵ������ļ������ÿ������ǵĶ�������
        	 * <setting name="cacheEnabled value= "true">
        	 * 2.2��Ҫ��ӳ���ļ�����ӣ�cache��ǩ
        	 */
        	
        	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

}
