package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream reader = new FileInputStream(br.readLine());

        int bufferSize = 64000;
        byte[] buffer = new byte[64000];
        long[] arrLong = new long[256];

        while( reader.available() > 0 ){
            if ( reader.available() < 64000 ) bufferSize = reader.available();
            reader.read(buffer,0,bufferSize);
            for (int i = 0; i < bufferSize; i++)
            {
                arrLong[ buffer[i] & 0b11111111]++;
            }
        }

        long min = Long.MAX_VALUE;
        for (long aList : arrLong)
        {
            if (aList < min && aList != 0) min = aList;
        }

        for (int i = 0; i < arrLong.length; i++){
            if (arrLong[i] == min) System.out.print(i + " ");
        }
    }
}
