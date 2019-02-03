/**
 * Copyright (C)，2019-2019,Infor
 * Author: lli3
 * Description TesttEmployee
 */

package com.infor.test;

import com.infor.bean.EmployeeMapper;

public class Test1 {
    public static void main(String[] args) {
        EmployeeMapper zs = new EmployeeMapper();
        zs.setId("1");
        zs.setName("张三");
        zs.setGender('1');
        zs.setAddress("玛丽阿西娅");

        //对象关系映射，把数据库中的记录，映射成Java中的类对象，一条记录对应一个类对象
        //那么这个类就被称为javabean 或者叫entity(实体类)
    }
}
