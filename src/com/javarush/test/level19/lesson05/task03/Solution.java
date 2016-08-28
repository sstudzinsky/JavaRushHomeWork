package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
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
        StringBuffer content = new StringBuffer();
        String row;

        while((row = reader.readLine()) != null){
            content.append(row);
        }
        reader.close();

        FileWriter fw = new FileWriter(file2);
        String[] words = content.toString().split(" ");

        for(int i = 0; i < words.length; i++){
            try{
                Integer.parseInt(words[i]);
                fw.write(words[i].concat(" "));
            }
            catch(Exception e){
                continue;
            }
        }

        fw.close();

    }
}
