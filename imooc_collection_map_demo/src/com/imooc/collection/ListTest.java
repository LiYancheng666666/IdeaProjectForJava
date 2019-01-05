/**
 * Copyright (C)，2019-2019,Infor
 * Author: lli3
 * Description Test List
 */

package com.imooc.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListTest {
    /*
    用于存放被选课程的List
     */
    public List coursesToSelect;

    public ListTest() {
        this.coursesToSelect = new ArrayList();
    }

    /*
    用于往coursesToSelect中添加被选课程
     */
    public void testAdd(){
        //创建一个课程对象，并通过调用add方法，添加到被选课程list中
        Course cr1 = new Course("1","数据结构");
        coursesToSelect.add(cr1);
        /*
        将对象添加进集合中变成object类型，取出时需要强制类型转换将object转换为原来的类型。
         */
        Course temp = (Course) coursesToSelect.get(0);
        System.out.println("添加了课程: "+temp.id +":"+temp.name);

        Course cr2 = new Course("2","C语言");
        coursesToSelect.add(0,cr2);
        Course temp2 = (Course) coursesToSelect.get(0);
//        Course temp3 = (Course) coursesToSelect.get(1);
        System.out.println("添加了课程: "+temp2.id +":"+temp2.name);
//        System.out.println("添加了课程: "+temp3.id +":"+temp3.name);

        Course[] course = {new Course("3","离散数学"),new Course("4","汇编语言")};
        coursesToSelect.addAll(Arrays.asList(course));
        Course temp3 = (Course) coursesToSelect.get(2);
        Course temp4 = (Course) coursesToSelect.get(3);
        System.out.println("添加了两门课程: " + temp3.id +":" +
        temp3.name +";" + temp4.id +":" +temp4.name);

        Course[] course2 = {new Course("5","高等数学"),new Course("6","大学英语")};
        coursesToSelect.addAll(2,Arrays.asList(course2));
        Course temp5 = (Course) coursesToSelect.get(2);
        Course temp6 = (Course) coursesToSelect.get(3);
        System.out.println("添加了两门课程: " + temp5.id +":" +
                temp5.name +";" + temp6.id +":" +temp6.name);


    }

    public static void main(String[] args) {
        ListTest listTest = new ListTest();
        listTest.testAdd();
    }
}
