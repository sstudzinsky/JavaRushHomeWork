package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        File first = new File(br.readLine());
        File second = new File(br.readLine());
        br.close();

        FileInputStream firstStream = new FileInputStream(first);
        byte[] firstData = new byte[firstStream.available()];
        firstStream.read(firstData);
        firstStream.close();

        FileInputStream secondStream = new FileInputStream(second);
        byte[] secondData = new byte[secondStream.available()];
        secondStream.read(secondData);
        secondStream.close();

        FileOutputStream secondToFirst = new FileOutputStream(first);
        secondToFirst.write(secondData);
        secondToFirst.close();

        FileOutputStream firstInTheEnd = new FileOutputStream(first, true);
        firstInTheEnd.write(firstData);
        firstInTheEnd.close();
    }
}
