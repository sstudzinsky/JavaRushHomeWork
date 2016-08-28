package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        File file1 = new File(br.readLine());
        File file2 = new File(br.readLine());
        br.close();

        FileInputStream fis = new FileInputStream(file1);
        FileOutputStream fos = new FileOutputStream(file2);

        byte[] bufer = new byte[fis.available()];
        fis.read(bufer,0,bufer.length);

        for(int i = bufer.length - 1; i >= 0; i--){
            fos.write(bufer[i]);
        }
    }
}
