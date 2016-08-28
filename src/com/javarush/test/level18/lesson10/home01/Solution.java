package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        File fileName = new File(args[0]);
        FileInputStream fis = new FileInputStream(fileName);

        int counter = 0;

        byte[] bufer = new byte[fis.available()];
        fis.read(bufer);

        for ( int i : bufer) {
            if ((i >= 65 && i <= 90 ) || (i >= 97 && i <= 122 )) counter++;
        }

        fis.close();
        System.out.println(counter);
    }
}
