/**
 * Copyright (C)，2019-2019,Infor
 * Author: lli3
 * Description Goddess action
 */

package com.imooc.action;

import com.imooc.dao.GoddessDao;
import com.imooc.model.Goddess;

import java.util.List;

public class GoddessAction {

    public static void main(String[] args) throws Exception {

        GoddessDao g = new GoddessDao();
        List<Goddess> gs =g.query();
        for (Goddess goddess : gs) {
            System.out.println(goddess.getUser_name()+","+goddess.getAge());

        }
    }
}
