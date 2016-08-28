package com.javarush.test.level08.lesson08.task02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.HashSet;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

/* Удалить все числа больше 10
Создать множество чисел(Set<Integer>), занести туда 20 различных чисел.
Удалить из множества все числа больше 10.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        removeAllNumbersMoreThan10(createSet());
    }

    public static HashSet<Integer> createSet() throws IOException
    {
        //напишите тут ваш код
        HashSet<Integer> stas = new HashSet<Integer>();

        for (int i = 0; i < 20; i++){
            stas.add(i);
        }
        return stas;
    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set)
    {
        //напишите тут ваш код)
        Iterator<Integer> iterato = set.iterator();
        while (iterato.hasNext()){
            if (iterato.next() > 10) iterato.remove();
        }
        return set;
    }
}
