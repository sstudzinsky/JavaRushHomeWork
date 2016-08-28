package com.javarush.test.level19.lesson05.task05;

/* Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Удалить все знаки пунктуации, включая символы новой строки. Результат вывести во второй файл.
http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        File file1 = new File(br.readLine());
        File file2 = new File(br.readLine());
        br.close();

        BufferedReader reader = new BufferedReader(new FileReader(file1));
        StringBuffer bufer = new StringBuffer();
        String row;

        while((row = reader.readLine()) != null ){
            bufer.append(row);
        }

        reader.close();

        BufferedWriter bw = new BufferedWriter(new FileWriter(file2));
        bw.write(bufer.toString().replaceAll("\\p{Punct}", ""));
        bw.close();
    }
}
