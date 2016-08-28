package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;




/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream reader = new FileInputStream(br.readLine());

        byte[] list = new byte[256];
        byte[] bufReader = new byte[reader.available()];

        reader.read(bufReader);

        for (int i = 0; i < bufReader.length; i++) list[bufReader[i] & 0b11111111]++;

        for(int i = 0; i < list.length; i++){
            if (list[i] != 0) System.out.println(i + " ");
        }
    }
}
