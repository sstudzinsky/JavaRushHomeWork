package com.javarush.test.level18.lesson05.task05;

/* DownloadException
1 Считывать с консоли имена файлов.
2 Если файл меньше 1000 байт, то:
2.1 Закрыть потоки
2.2 выбросить исключение DownloadException
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while (true){
            line = br.readLine();
            if ( new FileInputStream(new File(line)).available() < 1000 ){
                br.close();
                throw new DownloadException();
            }
        }

    }

    public static class DownloadException extends Exception{

    }
}
