/**
 * Copyright (C)，2019-2019,Infor
 * Author: lli3
 * Description Test log
 */

package com.infor.test;

import com.infor.file.ReadLogFile;
import com.infor.logs.DealLogFile;

public class TestLogs {
    public static void main(String[] args) {
        String rgex = "<IDORequestInfo>(.*?)</IDORequestInfo>";
        ReadLogFile testLogFile = new ReadLogFile();
        DealLogFile dealLogFile = new DealLogFile();
        String logsContent = dealLogFile.getLogs(testLogFile);
        dealLogFile.getIDORequestInfo(logsContent);
//        dealLogFile.getSubUtil(logsContent);
    }
}
