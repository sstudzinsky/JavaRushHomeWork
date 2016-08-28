package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        if ( (a > b) && (a > c)){
            if ( b > c )
                System.out.println(a+" "+b+" "+c);
            else
                System.out.println(a+" "+b+" "+c);
        }
        if ( (b > a) && (b > c)){
            if ( a > c )
                System.out.println(b+" "+a+" "+c);
            else
                System.out.println(b+" "+c+" "+a);
        }
        if ( (c > b) && (c > a)){
            if ( b > a )
                System.out.println(c+" "+b+" "+a);
            else
                System.out.println(c+" "+a+" "+b);
        }

        if ((a>b)&&(a>c)){
            if (b>c) System.out.println(a+" "+b+" "+c);
            else System.out.println(a+" "+c+" "+b);
        }

        if ((b>a)&&(b>c)){
            if (a>c) System.out.println(b+" "+a+" "+c);
            else System.out.println(b+" "+c+" "+a);
        }

        if ((c>a)&&(c>b)){
            if (a>b) System.out.println(c+" "+a+" "+b);
            else System.out.println(c+" "+b+" "+a);
        }
    }
}
