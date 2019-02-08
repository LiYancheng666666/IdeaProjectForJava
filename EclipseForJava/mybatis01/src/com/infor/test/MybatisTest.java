/**
 * Copyright (C)，2019-2019,Infor
 * Author: lli3
 * Description TestSelect
 */

package com.infor.test;

import com.infor.bean.EmployeeMapper;
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
            //通过数据路会话工厂开启和数据库的一次会话
            SqlSession sqlSession = sqlMapper.openSession();
            //sqlsession 通过这个对象，来执行sql语句，用完之后关闭对象

            //所有的数据库操作都封装到sqlsession对象中了，增，删，改，查
            EmployeeMapper xm  =sqlSession.selectOne("com.infor.bean.EmployeeMapper.selOne", "1");
            System.out.println(xm.getId());
            System.out.println(xm.getName());
            System.out.println(xm.getGender());
            System.out.println(xm.getAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
