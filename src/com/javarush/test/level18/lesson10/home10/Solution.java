package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/


import java.io.*;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<File> parts = new TreeSet<>();
        String s, buf = null;

        while(!(s = br.readLine()).equals("end"))
        {
            parts.add(new File(s));
            buf = s;
        }
        br.close();

        Iterator<File> iter = parts.iterator();
        File output = new File(buf.substring(0, buf.length() - 6));
        FileOutputStream fos = new FileOutputStream(output);

        while(iter.hasNext()){
            FileInputStream fis = new FileInputStream(iter.next());
            byte[] bufer = new byte[fis.available()];
            fis.read(bufer);
            fos.write(bufer);

            fis.close();
        }

        fos.close();

    }
}
