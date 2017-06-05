package com.jk;

import java.io.File;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        int i = getAllJavaFilesLineCount(new File("F:\\iWorkSpace\\lineCount"));
        System.out.println(i);
    }

    private static int getAllJavaFilesLineCount(File dir) {
        int count = 0;
        for (File file : dir.listFiles()) {
            //如果是.java文件，就统计行数
            if (file.isFile() && file.getName().endsWith(".java")) {
                count += FileUtil.getLineCount(file);
            } else if (file.isDirectory()) {//如果是文件夹就递归调用
                count += getAllJavaFilesLineCount(file);
            }
        }
        return count;
    }
}
