/**
 * Copyright (C)，2019-2019,Infor
 * Author: lli3
 * Description Write file
 */

package com.infor.file;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriteLogsFile {

    public void testWriteFile(String text) {

        try {
            Writer writerlogs = new FileWriter("D:/Utility/vbsGenerateTool/src/data/testlogs/1.txt", true);
            writerlogs.write(text);

            writerlogs.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("write file error："+e.getMessage());
        }
    }

}
