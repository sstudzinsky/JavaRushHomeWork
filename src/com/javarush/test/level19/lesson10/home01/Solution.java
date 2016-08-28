package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        //args = new String[]{"C:\\Users\\Shiva\\Desktop\\JavaRushHomeWork\\src\\1.txt"};

        BufferedReader br = new BufferedReader(new FileReader(new File(args[0])));
        TreeMap<String, Double> map = new TreeMap<>();
        Double currentValue;
        String[] parts;
        String row;

        while((row = br.readLine()) != null){
            parts = row.split(" ");

            if (map.containsKey(parts[0])){
                currentValue = map.get(parts[0]);
                map.put(parts[0], Double.parseDouble(parts[1]) + currentValue);
            }
            else{
                map.put(parts[0], Double.parseDouble(parts[1]));
            }
        }
        br.close();

        for (String s : map.keySet()) {
            System.out.println(s + " " + map.get(s));
        }
    }
}
