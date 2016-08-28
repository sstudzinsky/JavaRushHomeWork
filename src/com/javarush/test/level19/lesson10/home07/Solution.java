package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException{
        //args = new String[]{"C:\\Users\\Shiva\\Desktop\\JavaRushHomeWork\\src\\1.txt", "C:\\Users\\Shiva\\Desktop\\JavaRushHomeWork\\src\\2.html"};

        File file1 = new File(args[0]);
        File file2 = new File(args[1]);

        BufferedReader reader = new BufferedReader(new FileReader(file1));
        ArrayList<String> list = new ArrayList<>();
        String line;

        while((line = reader.readLine())!= null ){
            String[] arr = line.split(" ");

            for (String s : arr) {
                if (s.length() > 6)
                    list.add(s);
            }
        }
        reader.close();


        BufferedWriter writer = new BufferedWriter(new FileWriter(file2, true));
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1)
                writer.write(list.get(i));
            else
                writer.write(list.get(i).concat(","));
        }
        writer.close();
    }
}
