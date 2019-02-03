/**
 * Copyright (C)��2019-2019,Infor
 * Author: lli3
 * Description Test Mybatis
 */

package com.infor.test;

import com.infor.bean.Employee;
import com.infor.dao.EmployeeDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;


public class MybatisTest {

    @Test
    public void wan() throws IOException {
        //��õ�ǰMybatis�ܵ������ļ�·��
        String resource = "resource.xml";
       
        //��õ�ǰ�ļ�������������
        Reader reader = Resources.getResourceAsReader(resource);
        //ͨ��������������sqlsessionfactory�������ݻỰ����
        SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
        //true��ʾ�Զ��ύ��������Ҫʹ��commit�����Ż��ύ��Ĭ����false
        SqlSession sqlSession = sqlMapper.openSession(true);

        //�����ӿڶ������sessionͨ����̬�����Զ������Ǵ����ģ�Proxy������
        EmployeeDao empDao = sqlSession.getMapper(EmployeeDao.class);
        System.out.println(empDao);
        Employee emp = empDao.selOne("4");
        System.out.println(emp);
        List<Employee> list = empDao.selAll();
        System.out.println(list.size());


       
    }



}
