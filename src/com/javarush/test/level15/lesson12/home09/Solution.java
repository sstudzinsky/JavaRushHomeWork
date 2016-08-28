package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException{
        //add your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Object> obj_vars = new ArrayList<>();

        String url = br.readLine();
        br.close();
        String arguments = url.substring(url.indexOf("?") + 1);
        String[] argument_pair = arguments.split("&");

        Double numb = null;
        String answer = null;

        for (String k : argument_pair){
            if (k.indexOf("=") != -1){
                String key = k.substring(0,k.indexOf("="));
                String value = k.substring(k.indexOf("=") + 1);

                System.out.print(key+" ");

                if (key.equals("obj")){
                    try{
                        Double.parseDouble(value);
                        obj_vars.add(Double.parseDouble(value.toString()));
                    }
                    catch(Exception e){
                        obj_vars.add(value.toString());
                    }
                }
            }
            else
                System.out.print(k + " ");
        }
        System.out.println();

        for (Object s : obj_vars){
            if (s instanceof Double)
                alert(Double.parseDouble(s.toString()));
            else
                alert(s.toString());
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
