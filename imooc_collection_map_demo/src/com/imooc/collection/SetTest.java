/**
 * Copyright (C)，2019-2019,Infor
 * Author: lli3
 * Description Test Set
 */

package com.imooc.collection;

import java.util.*;

public class SetTest {

    public List<Course> coursesToSelect;

    public SetTest() {
       coursesToSelect = new ArrayList<Course>();
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
//        System.out.println("添加了课程: "+temp.id +":"+temp.name);

        Course cr2 = new Course("2","C语言");
        coursesToSelect.add(0,cr2);
        Course temp2 = (Course) coursesToSelect.get(0);
//        Course temp3 = (Course) coursesToSelect.get(1);
//        System.out.println("添加了课程: "+temp2.id +":"+temp2.name);
//        System.out.println("添加了课程: "+temp3.id +":"+temp3.name);

        Course[] course = {new Course("3","离散数学"),new Course("4","汇编语言")};
        coursesToSelect.addAll(Arrays.asList(course));
        Course temp3 = (Course) coursesToSelect.get(2);
        Course temp4 = (Course) coursesToSelect.get(3);
//        System.out.println("添加了两门课程: " + temp3.id +":" +
//                temp3.name +";" + temp4.id +":" +temp4.name);

        Course[] course2 = {new Course("5","高等数学"),new Course("6","大学英语")};
        coursesToSelect.addAll(2,Arrays.asList(course2));
        Course temp5 = (Course) coursesToSelect.get(2);
        Course temp6 = (Course) coursesToSelect.get(3);
//        System.out.println("添加了两门课程: " + temp5.id +":" +
//                temp5.name +";" + temp6.id +":" +temp6.name);
    }

    /*
   通过for each方法访问集合元素
    */
    public void testForEach(){
        System.out.println("有如下课程待选(通过foreach访问)");
        for (Object o : coursesToSelect) {
            Course cr = (Course) o;
            System.out.println("课程:" + cr.id +":" +cr.name);
        }

    }

    public void testForEachForSet(Student student) {
        // 打印输出学生所选的课程
        System.out.println("共选择了:"+student.courses.size() +"门课程! ");
        for (Course cr:student.courses) {
            System.out.println("选择了课程: " +cr.id +":" +cr.name);
        }
    }



    public static void main(String[] args) {

        SetTest setTest = new SetTest();
        setTest.testAdd();
        setTest.testForEach();
        //创建一个学生对象
        Student student = new Student("1","小明");
        System.out.println("欢迎学生: " +student.name + "选课!");

        //创建一个scanner对象，用来接收从键盘输入的课程ID
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 3 ; i++) {
            System.out.println("请输入课程ID");
            String courseId = scanner.next();
            for (Course cr : setTest.coursesToSelect) {
                if (cr.id.equals(courseId)) {
                    student.courses.add(cr);
                }
            }
        }

        setTest.testForEachForSet(student);
    }

}
