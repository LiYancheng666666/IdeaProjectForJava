/**
 * Copyright (C)，2019-2019,Infor
 * Author: lli3
 * Description select Course
 */

package com.imooc.collection;
/**
Template text内容如下:
 * 功能描述: <br>
 * 〈〉
 *
 Courses type
 * @return:
 * @since: 1.0.0
 * @Author:
 * @Date:
 */


/**
 * 课程类
 * @author Administrator
 *
 */
public class Course {

    public String id;

    public String name;

    public Course(String id, String name) {
        this.id = id ;

        this.name = name;
    }

    public Course() {

    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Course))
            return false;
        Course other = (Course) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
}
