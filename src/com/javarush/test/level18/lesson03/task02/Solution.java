package com.javarush.test.level18.lesson03.task02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Минимальный байт
Ввести с консоли имя файла
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int min = 2147483647;

        FileInputStream fi = new FileInputStream(s);
        while(fi.available() > 0){
            int data = fi.read();

            if (min > data )
                min = data;
        }

        System.out.println(min);
        fi.close();
        br.close();
    }
}
