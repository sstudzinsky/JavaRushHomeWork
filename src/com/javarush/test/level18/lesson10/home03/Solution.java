package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        File file1 = new File(br.readLine());
        File file2 = new File(br.readLine());
        File file3 = new File(br.readLine());
        br.close();

        FileInputStream fis2 = new FileInputStream(file2);
        FileInputStream fis3 = new FileInputStream(file3);

        FileOutputStream fos21 = new FileOutputStream(file1);
        FileOutputStream fos31 = new FileOutputStream(file1, true);

        byte[] buffer = new byte[64000];
        int bufferSize = 64000;

        while (fis2.available() > 0 ){
            if (fis2.available() < bufferSize) bufferSize = fis2.available();
            fis2.read(buffer, 0, bufferSize);
            fos21.write(buffer, 0, bufferSize);
        }

        bufferSize = 64000;
        while (fis3.available() > 0){
            if (fis3.available() < bufferSize) bufferSize = fis3.available();
            fis3.read(buffer, 0, bufferSize);
            fos31.write(buffer, 0, bufferSize);
        }

        fis2.close();
        fis3.close();
        fos21.close();
        fos31.close();
    }
}
