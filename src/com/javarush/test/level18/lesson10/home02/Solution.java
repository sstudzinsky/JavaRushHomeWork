package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        FileInputStream fis = new FileInputStream(new File(args[0]));
        int all = fis.available();

        byte[] buffer = new byte[fis.available()];
        fis.read(buffer);

        int spaces = 0;
        for (int i : buffer){
           if (i == 32) spaces++;
        }
        fis.close();

        double result = ((spaces * 1.0) / (all * 1.0)) * 100;
        String formattedDouble = new DecimalFormat("#0.00").format(result);


        System.out.println(formattedDouble);
    }
}
