package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        File file1 = new File(br.readLine());
        File file2 = new File(br.readLine());
        br.close();

        FileInputStream fis = new FileInputStream(file1);
        FileOutputStream fos = new FileOutputStream(file2, true);

        int size = fis.available();
        for(int i = 1; i <= size; i++){
            int data = fis.read();
            if (i % 2 == 0) fos.write(data);
        }

        fis.close();
        fos.close();
    }
}
