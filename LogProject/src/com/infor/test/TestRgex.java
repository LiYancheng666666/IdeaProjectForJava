/**
 * Copyright (C)，2019-2019,Infor
 * Author: lli3
 * Description Test rgex
 */

package com.infor.test;

import com.infor.file.ReadLogFile;
import com.infor.logs.DealLogFile;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRgex {

    public static void main(String[] args) {
        String rgex = "<IDORequestInfo>/[ -~]/</IDORequestInfo>";
        ReadLogFile testLogFile = new ReadLogFile();
        DealLogFile dealLogFile = new DealLogFile();
        String logsContent = dealLogFile.getLogs(testLogFile);

//        String str = "<?xml version='1.0' encoding='UTF-8'?><ufinterface billtype='gl' filename='e:\1.xml' isexchange='Y' proc='add' receiver='1060337@1060337-003' replace='Y' roottag='sendresult' sender='01' successful='Y'><sendresult><billpk></billpk><bdocid>w764</bdocid><filename>e:\1.xml</filename><resultcode>1</resultcode><resultdescription>单据w764开始处理...单据w764处理完毕!</resultdescription><content>2017.09-记账凭证-1</content></sendresult><sendresult><billpk></billpk><bdocid>w1007</bdocid><filename>e:\1.xml</filename><resultcode>1</resultcode><resultdescription>单据w1007开始处理...单据w1007处理完毕!</resultdescription><content>2017.10-记账凭证-1</content></sendresult><sendresult><billpk></billpk><bdocid>w516</bdocid><filename>e:\1.xml</filename><resultcode>1</resultcode><resultdescription>单据w516开始处理...单据w516处理完毕!</resultdescription><content>2017.07-记账凭证-50</content></sendresult></ufinterface>";
        //String str = "abc3443abcfgjhgabcgfjabc";
//        String rgex = "<bdocid>(.*?)</bdocid>";

        System.out.println((new TestRgex()).getSubUtil(logsContent,rgex));
        List<String> lists = (new TestRgex()).getSubUtil(logsContent,rgex);
        for (String string : lists) {
            System.out.println(string);
        }
        System.out.println((new TestRgex()).getSubUtilSimple(logsContent, rgex));
    }

    /**
     * 正则表达式匹配两个指定字符串中间的内容
     * @param soap
     * @return
     */
    public List<String> getSubUtil(String soap,String rgex){
        List<String> list = new ArrayList<String>();
        Pattern pattern = Pattern.compile(rgex);// 匹配的模式
        Matcher m = pattern.matcher(soap);
        while (m.find()) {
            int i = 1;
            list.add(m.group(i));
            i++;
        }
        return list;
    }

    /**
     * 返回单个字符串，若匹配到多个的话就返回第一个，方法与getSubUtil一样
     * @param soap
     * @param rgex
     * @return
     */
    public String getSubUtilSimple(String soap,String rgex){
        Pattern pattern = Pattern.compile(rgex);// 匹配的模式
        Matcher m = pattern.matcher(soap);
        while(m.find()){
            return m.group(1);
        }
        return "";
    }

}
