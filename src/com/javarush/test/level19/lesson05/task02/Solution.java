package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        File file = new File(br.readLine());
        //File file = new File("C:\\Users\\Shiva\\Desktop\\JavaRushHomeWork\\src\\3.txt");
        br.close();

        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);
        String row;
        int counter = 0;

        while ((row = reader.readLine()) != null){
            Pattern pattern = Pattern.compile("\\bworld\\b");
            Matcher matcher = pattern.matcher(row);

            while(true)
            {
                if (matcher.find()) counter++;
                else break;
            }
        }

        reader.close();
        fr.close();

        System.out.println(counter);
    }
}
