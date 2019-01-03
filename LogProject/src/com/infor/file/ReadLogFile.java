/**
 * Copyright (C)，2019-2019,Infor
 * Author: lli3
 * Description Read log files
 */

package com.infor.file;

import java.io.*;

public class ReadLogFile {


    public  String ReadLogs() {
        String logfilecontent = null;
        Reader reader;
        try {
            reader = new FileReader("D:/Utility/vbsGenerateTool/IDORunTimeLog/scrap.idoreq");
            BufferedReader bufferedReader = new BufferedReader(reader);

            try {

                String line = bufferedReader.readLine();
                StringBuffer buffer = new StringBuffer();

                while(line!=null) {
                    buffer.append(line + "\r\n");
                    line = bufferedReader.readLine();
                }

                logfilecontent =buffer.toString();
//                System.out.println("fileContent:    "+logfilecontent);
                bufferedReader.close();
                reader.close();
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return logfilecontent;

    }

}
