package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException{
        //args = new String[]{"C:\\Users\\Shiva\\Desktop\\JavaRushHomeWork\\src\\1.txt", "C:\\Users\\Shiva\\Desktop\\JavaRushHomeWork\\src\\2.html"};

        File file1 = new File(args[0]);
        File file2 = new File(args[1]);

        BufferedReader reader = new BufferedReader(new FileReader(file1));
        String row;

        while((row = reader.readLine()) != null){
            BufferedWriter writer = new BufferedWriter(new FileWriter(file2, true));
            String[] parts = row.split(" ");

            for (String part : parts) {
                if (part.matches(".*\\d.*")){
                    writer.write(part.concat(" "));
                }
            }
            writer.close();
        }
        reader.close();
    }
}
