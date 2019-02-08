/**
 * Copyright (C)��2019-2019,Infor
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
        //��õ�ǰMybatis�ܵ������ļ�·��
        String resource = "resource.xml";
        Reader reader = null;
        try {
            //��õ�ǰ�ļ�������������
            reader = Resources.getResourceAsReader(resource);
            //ͨ��������������sqlsessionfactory�������ݻỰ����
            SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
            //ͨ������·�Ự�������������ݿ��һ�λỰ
            SqlSession sqlSession = sqlMapper.openSession();
            //sqlsession ͨ�����������ִ��sql��䣬����֮��رն���

            //���е����ݿ��������װ��sqlsession�������ˣ�����ɾ���ģ���
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
