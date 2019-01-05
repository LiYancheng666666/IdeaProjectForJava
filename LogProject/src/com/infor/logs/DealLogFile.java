/**
 * Copyright (C)，2019-2019,Infor
 * Author: lli3
 * Description analyse log file
 */

package com.infor.logs;

import com.infor.file.ReadLogFile;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DealLogFile {

    public String getLogs(ReadLogFile obj) {
        String logsContent =obj.ReadLogs();
//        System.out.println(logsContent);
        return logsContent;

    }

    /*public ArrayList<String> getIDORequestInfo(String str) {
        ArrayList<String> list =new ArrayList<String>();
        String[]  IDORequestInfoContent =str.split("<IDORequestInfo>");
        String[] MidContent1 = new String[10000];
        for (int i =0 ;i <IDORequestInfoContent.length; i++) {
            MidContent1[i] = IDORequestInfoContent[i].replace("</IDORequestInfo>","");
            System.out.println("    MidContent1[i]"+MidContent1[i]);
            list.add(MidContent1[i]);
        }
        return list;
    }*/

    public List<String> getIDORequestInfo(String str){
        List<String> list = new ArrayList<String>();
        String[]  IDORequestInfoContent =str.split("<IDORequestInfo>");
        for (int i = 0; i < IDORequestInfoContent.length; i++) {
            System.out.println(i+IDORequestInfoContent[i]);
        }
        return list;
    }

    public void getSubUtil(String soap) {
        Pattern p = Pattern.compile("<IDORequestInfo>(.*)</IDORequestInfo>");
        Matcher m = p.matcher(soap);
        while (m.find()) {
            System.out.println(m.group(0));
        }

    }

}
