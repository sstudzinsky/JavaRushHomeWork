package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.File;
import java.io.FileInputStream;

public class Solution {
    public static void main(String[] args) throws Exception{
        File text = new File(args[0]);
        FileInputStream fis = new FileInputStream(text);

        long[] counter = new long[256];
        byte[] bufer = new byte[fis.available()];

        fis.read(bufer);
        for (int i = 0; i < bufer.length; i++) counter[bufer[i] & 0b11111111]++;
        fis.close();

        for (int i = 0; i < counter.length; i++)
        {
            if (counter[i] != 0) System.out.println((char)i + " " + counter[i]);
        }

//        FileInputStream inputStream = new FileInputStream(new File("C:\\Users\\Shiva\\Desktop\\JavaRushHomeWork\\src\\3.txt"));
////        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
////        FileInputStream inputStream = new FileInputStream(new File(rd.readLine()));
//
//        byte[] symbols = new byte[inputStream.available()];
//        inputStream.read(symbols);
//        Arrays.sort(symbols);
//
//        HashMap<Byte, Integer> map = new HashMap<Byte, Integer>();
//
//        int count;
//
//
//        for (byte x : symbols) {
//            count = 0;
//
//            for (byte x1 : symbols) {
//                if (x == x1) {
//                    count++;
//                }
//            }
//
//            if (!map.containsKey(x)) {
//                map.put(x, count);
//                System.out.println((char) x + " " + count);
//            }
//
//
//        }
//
//
//        inputStream.close();

    }
}
