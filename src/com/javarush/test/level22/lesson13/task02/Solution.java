package com.javarush.test.level22.lesson13.task02;

import java.io.*;

/* Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
        File fileInput  = new File(args[0]);
        File fileOutput = new File(args[1]);

        BufferedReader reader = new BufferedReader(new FileReader(fileInput));
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileOutput));
        String line;

        while((line = reader.readLine()) != null){
            String utfLine = new String(line.getBytes("Windows-1251"), "UTF-8");
            writer.write(utfLine);
        }

        writer.close();
        reader.close();
    }
}
