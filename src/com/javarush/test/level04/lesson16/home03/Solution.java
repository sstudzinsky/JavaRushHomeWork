package com.javarush.test.level04.lesson16.home03;

import java.io.*;

/* Посчитать сумму чисел
Вводить с клавиатуры числа и считать их сумму. Если пользователь ввел -1, вывести на экран сумму и завершить программу.  -1 должно учитываться в сумме.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        //напишите тут ваш код

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int hod = Integer.parseInt(br.readLine());
        int sum = 0;

        while ( hod != -1 ){
            sum += hod;
            hod = Integer.parseInt((br.readLine()));
        }

        sum += hod;
        System.out.println(sum);

    }
}
