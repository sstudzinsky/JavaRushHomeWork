package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        File file1 = new File(br.readLine());
        File file2 = new File(br.readLine());
        File file3 = new File(br.readLine());
        br.close();

        FileInputStream fi1 = new FileInputStream(file1);

        FileOutputStream fo12 = new FileOutputStream(file2);
        FileOutputStream fo13 = new FileOutputStream(file3);

        byte[] buffer;
        byte[] buffer2;

        if (fi1.available() % 2 == 0)
        {
            buffer = new byte[fi1.available() / 2];

            fi1.read(buffer, 0, buffer.length);
            fo12.write(buffer);

            fi1.read(buffer, 0, buffer.length - 1);
            fo13.write(buffer);
        }
        else{
            buffer = new byte[fi1.available() / 2 + 1];
            buffer2 = new byte[fi1.available() / 2];

            fi1.read(buffer, 0, buffer.length);
            fo12.write(buffer);

            fi1.read(buffer2, 0, buffer2.length);
            fo13.write(buffer2);
        }
        fi1.close();
        fo12.close();
        fo13.close();

    }
}
