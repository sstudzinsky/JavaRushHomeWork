package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/


import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        File toRead = new File(br.readLine());
        File toWrite = new File(br.readLine());
        br.close();

        FileReader fr = new FileReader(toRead);
        BufferedReader reader = new BufferedReader(fr);

        String res = reader.readLine();
        String[] stringArray = res.split(" ");

        FileWriter fw = new FileWriter(toWrite);

        for (int i = 0; i < stringArray.length; i++)
        {
            fw.write(Math.round(Double.parseDouble(stringArray[i])) + " ");
        }

        fw.close();
        fr.close();
        reader.close();
    }
}
