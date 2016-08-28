package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{

        if (args[0].equals("-e"))
            chipr(args);
        else if(args[0].equals("-d"))
            deChipr(args);
    }


    public static void chipr(String[] parts) throws IOException{
        FileInputStream fis = new FileInputStream(new File(parts[1]));
        FileOutputStream fos = new FileOutputStream(new File(parts[2]));

        while(fis.available() > 0){
            int data;
            data = fis.read();
            fos.write(data + 3);
        }

        fis.close();
        fos.close();
    }


    public static void deChipr(String[] parts) throws IOException{
        FileInputStream fis = new FileInputStream(new File(parts[1]));
        FileOutputStream fos = new FileOutputStream(new File(parts[2]));

        while(fis.available() > 0){
            int data;
            data = fis.read();
            fos.write(data - 3);
        }

        fis.close();
        fos.close();
    }

}
