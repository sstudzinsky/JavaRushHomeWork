package com.javarush.test.level07.lesson12.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 Задача:  Программа вводит с клавиатуры данные про котов и выводит их на экран. Пример:
 Cat name is Barsik age is 6, weight is 5, tail = 22
 Cat name is Murka age is 8, weight is 7, tail = 20
 */
public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Cat> list = new ArrayList<Cat>();
        while (true)
        {
            String name = reader.readLine();
            if (name.isEmpty()) break;
            int age = Integer.parseInt(reader.readLine());
            int weight = Integer.parseInt(reader.readLine());
            int tailLength = Integer.parseInt(reader.readLine());

            Cat cat = new Cat(name, age, weight, tailLength);
            list.add(cat);
        }

        for (int i = 0; i < list.size(); i++)
        {
            System.out.println(list.get(i).toString());
        }
    }

    public static class Cat
    {
        private String name;
        private int age;
        private int weight;
        private int tailLength;

        public Cat(String name, int age, int weight, int tailLength)
        {
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.tailLength = tailLength;
        }

        @Override
        public String toString()
        {
            return "Cat name is " + name + ", age is " + age + ", weight is " + weight + ", tail = " + tailLength;
        }
    }

}