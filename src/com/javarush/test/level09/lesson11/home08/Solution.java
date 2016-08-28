package com.javarush.test.level09.lesson11.home08;

import java.util.ArrayList;

/* Список из массивов чисел
Создать список, элементами которого будут массивы чисел. Добавить в список пять объектов–массивов
длиной 5, 2, 4, 7, 0 соответственно. Заполнить массивы любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList()
    {
        int[] a5 = {1,2,3,4,5};
        int[] a2 = {1,2};
        int[] a4 = {1,2,3,4};
        int[] a7 = {1,2,3,4,5,6,7};
        int[] a0 = new int[0];

        //напишите тут ваш код
        ArrayList<int[]> stas = new ArrayList<int[]>();
        stas.add(a5);
        stas.add(a2);
        stas.add(a4);
        stas.add(a7);
        stas.add(a0);

        return stas;
    }

    public static void printList(ArrayList<int[]> list)
    {
        for (int[] array: list )
        {
            for (int x: array)
            {
                System.out.println(x);
            }
        }
    }
}
