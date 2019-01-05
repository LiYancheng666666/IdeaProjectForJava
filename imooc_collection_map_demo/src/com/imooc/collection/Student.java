/**
 * Copyright (C)，2019-2019,Infor
 * Author: lli3
 * Description Student
 */

package com.imooc.collection;

import com.sun.org.apache.xpath.internal.operations.String;

import java.util.HashSet;
import java.util.Set;
/*
Student type
 */
public class Student {

    public String id;
    public String name;
    public Set courses;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.courses = new HashSet();
    }
}
