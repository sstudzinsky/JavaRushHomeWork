package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        //args = new String[]{"-u", "198480", "stas", "123.22", "100"};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        File file = new File(br.readLine());
        //File file = new File("C:\\Users\\Shiva\\Desktop\\JavaRushHomeWork\\src\\1.txt");
        br.close();

        if ( args[0].equals("-u"))
            updateNewRow(args, file);
        else if ( args[0].equals("-d"))
            deleteNewRow(args, file);
    }


    public static void updateNewRow(String[] args, File file) throws IOException{
        Integer ID = Integer.parseInt(args[1]);
        ArrayList<String> rows = new ArrayList<>();
        String row;

        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);

        while((row = reader.readLine()) != null ){
            if (Integer.parseInt(row.substring(0,8).trim()) == ID ) row = update(args, row);
            rows.add(row);
        }

        FileWriter fwRemove = new FileWriter(file);
        BufferedWriter writerRemove = new BufferedWriter(fwRemove);
        writerRemove.write("");
        fwRemove.close();
        writerRemove.close();

        FileWriter fw = new FileWriter(file, true);
        BufferedWriter writer = new BufferedWriter(fw);

        for (String s : rows)
        {
            writer.write(s + "\n");
        }

        writer.close();
        fw.close();
    }

    public static String update(String[] args, String row){
        row = String.format("%1$-8s%2$-30.30s%3$-8s%4$-4s", row.substring(0, 8), args[2], args[3], args[4]);
        return row;
    }

    public static void deleteNewRow(String[] args, File file) throws IOException{
        Integer ID = Integer.parseInt(args[1]);
        ArrayList<String> rows = new ArrayList<>();
        String row;

        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);

        while((row = reader.readLine()) != null ){
            rows.add(row);
            if (Integer.parseInt(row.substring(0,8).trim()) == ID ) rows.remove(rows.indexOf(row));
        }

        reader.close();
        fr.close();

        FileWriter fwRemove = new FileWriter(file);
        BufferedWriter writerRemove = new BufferedWriter(fwRemove);
        writerRemove.write("");
        fwRemove.close();
        writerRemove.close();

        FileWriter fw = new FileWriter(file, true);
        BufferedWriter writer = new BufferedWriter(fw);

        for (String s : rows)
        {
            writer.write(s + "\n");
        }

        writer.close();
        fw.close();
    }
}
