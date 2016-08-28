package com.javarush.test.level19.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
оригинальный   редактированный    общий
file1:         file2:             результат:(lines)

строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка4                           REMOVED строка4
строка5        строка5            SAME строка5
               строка0            ADDED строка0
строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
               строка5            ADDED строка5
строка4        строка4            SAME строка4
строка5                           REMOVED строка5
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws Exception {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();


        String line;
        BufferedReader br1 = new BufferedReader(new FileReader("C:\\Users\\Shiva\\Desktop\\JavaRushHomeWork\\src\\1.txt"));
        while((line = br1.readLine()) != null){
            sb1.append(line + "\\|");
        }
        sb1.delete(sb1.length() - 1, 1);

        BufferedReader br2 = new BufferedReader(new FileReader("C:\\Users\\Shiva\\Desktop\\JavaRushHomeWork\\src\\3.txt"));
        while((line = br2.readLine()) != null){
            sb2.append(line + "\\|");
        }
        sb2.delete(sb2.length() - 1, 1);



    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
