/**
 * Copyright (C)，2019-2019,Infor
 * Author: lli3
 * Description Test Generic
 */

package com.imooc.collection;

import java.util.ArrayList;
import java.util.List;

public class TestGeneric {

    /*
    带有泛型--Course的List类型属性
     */
    public List<Course> courses;
    public TestGeneric() {
        this.courses = new ArrayList<Course>();
    }

    /*
    测试添加
     */

    public void testAdd() {
        Course cr1 = new Course("1","大学语文");
        courses.add(cr1);
        //泛型集合中，不能添加泛型规定的类型及其子类型以外的对象，否则会报错
        Course cr2 = new Course("2","Java基础");
        courses.add(cr2);
    }

    /*
    测试循环遍历
     */

    public void testForEach() {
        for (Course cours : courses) {
            System.out.println(cours.id + ":" +cours.name);

        }
    }

    /*
    泛型集合可以添加泛型的子类型的对象实例
     */
    public void testChild() {
        ChildCourse childCourse = new ChildCourse();
        childCourse.id ="3";
        childCourse.name ="我是子类型的课程对象实例";
        courses.add(childCourse);
    }

    /*
    泛型不能使用基本类型
     */
    public void testBasicType() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        System.out.println("基本类型必须使用包装类作为泛型!" + list.get(0));
    }

    public static void main(String[] args) {

        TestGeneric testGeneric = new TestGeneric();
        testGeneric.testAdd();
        testGeneric.testForEach();
        testGeneric.testChild();
        testGeneric.testForEach();
        testGeneric.testBasicType();
    }
}
