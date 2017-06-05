package com.jk;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Created by dell on 2017/6/5.
 */
public class FileUtil {

    public static int getLineCount(File file) {
        if (!file.isFile()) {
            throw new IllegalArgumentException("请制定一个有效的文件对象");
        }
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            int count = 0;
            while (reader.readLine() != null) {
                count++;
            }
            reader.close();
            return count;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
