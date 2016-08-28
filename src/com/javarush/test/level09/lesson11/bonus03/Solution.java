package com.javarush.test.level09.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* Задача по алгоритмам
Задача: Пользователь вводит с клавиатуры список слов (и чисел). Слова вывести в возрастающем порядке, числа - в убывающем.
Пример ввода:
Вишня
1
Боб
3
Яблоко
2
0
Арбуз
Пример вывода:
Арбуз
3
Боб
2
Вишня
1
0
Яблоко
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true)
        {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array)
        {
            System.out.println(x);
        }
    }

    public static void sort(String[] array)
    {
        //напишите тут ваш код
        ArrayList<Integer> ints = new ArrayList<Integer>();
        ArrayList<String> strings = new ArrayList<String>();

        ArrayList<Boolean> map = new ArrayList<>();

        for (int i = 0; i < array.length; i++)
        {
            if (isNumber(array[i]))
                ints.add(Integer.parseInt(array[i]));
            else
                strings.add(array[i]);

            try{
                Integer.parseInt(array[i]);
                map.add(true);
            }
            catch(Exception e){
                map.add(false);
            }
        }

        for (int i = 0; i < ints.size(); i++){
            for (int k = ints.size() - 1 ; k > 0; k--){
                if (ints.get(k - 1) < ints.get(k)){
                    int buf = ints.get(k);
                    ints.set(k, ints.get(k - 1));
                    ints.set(k - 1, buf);
                }
            }
        }

        for (int i = 0; i < strings.size(); i++){
            for (int k = strings.size() - 1; k > 0; k--){
                if (isGreaterThan(strings.get(k - 1), strings.get(k))){
                    String buf = strings.get(k);
                    strings.set(k, strings.get(k - 1));
                    strings.set(k - 1, buf);
                }
            }
        }

        int counterInt = 0;
        int counterString = 0;

        for (int i = 0; i < array.length; i++){
            if (map.get(i)) {
                array[i] = ints.get(counterInt).toString();
                counterInt++;
            }
            else{
                array[i] = strings.get(counterString);
                counterString++;
            }
        }

    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b)
    {
        return a.compareTo(b) > 0;
    }


    //строка - это на самом деле число?
    public static boolean isNumber(String s)
    {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++)
        {
            char c = chars[i];
            if ((i != 0 && c == '-') //есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-') ) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }
}
