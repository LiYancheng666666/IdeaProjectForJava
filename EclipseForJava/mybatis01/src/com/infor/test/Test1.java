/**
 * Copyright (C)��2019-2019,Infor
 * Author: lli3
 * Description TesttEmployee
 */

package com.infor.test;

import com.infor.bean.EmployeeMapper;

public class Test1 {
    public static void main(String[] args) {
        EmployeeMapper zs = new EmployeeMapper();
        zs.setId("1");
        zs.setName("����");
        zs.setGender('1');
        zs.setAddress("���������");

        //�����ϵӳ�䣬�����ݿ��еļ�¼��ӳ���Java�е������һ����¼��Ӧһ�������
        //��ô�����ͱ���Ϊjavabean ���߽�entity(ʵ����)
    }
}
