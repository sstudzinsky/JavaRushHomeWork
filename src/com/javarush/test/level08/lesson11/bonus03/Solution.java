package com.javarush.test.level08.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Задача: Введи с клавиатуры 20 слов и выведи их в алфавитном порядке.
*/

public class Solution
{
    public class ExceptionExample
    {
        public static void main(String[] args)
        {
            method1();
        }

        public static void method1()
        {
            method2();
        }

        public static void method2()
        {
            method3();
        }

        public static void method3()
        {
            StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
            for (StackTraceElement element : stackTraceElements)
            {
                System.out.println(element.getMethodName());
            }
        }
    }

}
