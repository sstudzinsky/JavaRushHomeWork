package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        File file = new File(br.readLine());
        br.close();

        //String[] arks = new String[]{"-c", "Шорты пляжные черные с рисункомммммм", "1113.00",  "17"};

        if ( args[0].equals("-c") ){
            addNewRow(args, file);
        }
    }

    public static void addNewRow(String[] args, File file) throws IOException{
        String sb = String.format("%1$-8s%2$-30.30s%3$-8s%4$-4s\n", getNewID(file), args[1], args[2], args[3]);

        FileWriter fos = new FileWriter(file, true);
        BufferedWriter writer = new BufferedWriter(fos);

        writer.write(sb);

        writer.close();
        fos.close();
    }

    public static int getNewID(File file) throws IOException{
        FileReader fis = new FileReader(file);
        BufferedReader br = new BufferedReader(fis);

        int max = Integer.MIN_VALUE;
        String s;

        while((s = br.readLine()) != null){
            if (max < Integer.parseInt(s.substring(0, 8).trim()))
                max = Integer.parseInt(s.substring(0, 8).trim());
        }

        br.close();
        fis.close();

        return ++max;
    }
}
