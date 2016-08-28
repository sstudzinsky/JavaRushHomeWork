package com.javarush.test.level18.lesson05.task02;

/* Подсчет запятых
С консоли считать имя файла
Посчитать в файле количество символов ',', количество вывести на консоль
Закрыть потоки. Не использовать try-with-resources

Подсказка: нужно сравнивать с ascii-кодом символа ','
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream reader = new FileInputStream(br.readLine());

        byte[] buffer = new byte[64000];
        int bufferSize = 64000;
        int counter = 0;

        while (reader.available() > 0){
            if (reader.available() < 64000) bufferSize = reader.available();
            reader.read(buffer, 0, bufferSize);
            for (int i = 0; i < bufferSize; i++) if (buffer[i] == 44) counter++;
        }
        br.close();
        reader.close();


        System.out.println(counter);
    }
}
