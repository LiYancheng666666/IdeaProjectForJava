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
        	Employee emp =new Employee();
        	emp.setId("10");
        	emp.setName("���˵�");
        	emp.setGender('1');
        	emp.setAddress("��Ů");
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
