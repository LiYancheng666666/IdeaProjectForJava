/**
 * Copyright (C)，2019-2019,Infor
 * Author: lli3
 * Description Test Mybatis
 */

package com.infor.test;

import com.infor.dao.EmployeeDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;


public class MybatisTest {

    @Test
    public void wan() {
        //获得当前Mybatis总的配置文件路径
        String resource = "resource.xml";
        Reader reader = null;
        try {
            //获得当前文件输入流。。。
            reader = Resources.getResourceAsReader(resource);
            //通过流对象来创建sqlsessionfactory对象，数据会话工厂
            SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
            //true表示自动提交，否则需要使用commit方法才会提交，默认是false
            SqlSession sqlSession = sqlMapper.openSession(true);

            //创建接口对象，这个session通过动态代理自动帮我们创建的，Proxy代理。。
            EmployeeDao empDao = sqlSession.getMapper(EmployeeDao.class);
            System.out.println(empDao);
//            Employee emp = empDao.selOne("2");
//            System.out.println(emp);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
