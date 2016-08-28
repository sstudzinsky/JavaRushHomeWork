package com.javarush.test.level22.lesson09.task01;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        File file = new File(br.readLine());
        br.close();

        BufferedReader reader = new BufferedReader(new FileReader(file));
        ArrayList<String> list = new ArrayList<>();
        String row;

        while ((row = reader.readLine()) != null){
            String[] bufer = row.split(" ");
            Collections.addAll(list, bufer);
        }

        while (list.size() > 1){
            for (int i = 1; i < list.size(); i++) {
                StringBuilder sb = new StringBuilder(list.get(i));
                String start = list.get(0);

                if (start.equals(sb.reverse().toString())){
                    Pair pair = new Pair();
                    pair.first = list.get(0);
                    pair.second = list.get(i);

                    list.remove(i);
                    list.remove(0);

                    Boolean flag = true;
                    for (int j = 0; j < result.size(); j++) {
                        if (result.get(j).toString().equals(pair.toString())) {
                            flag = false;
                        }
                    }

                    if (flag){
                        i--;
                        result.add(pair);
                    }
                }
                else if ( i == list.size() - 1)
                    list.remove(0);
            }
        }


        for (Pair stas : result){
            System.out.println(stas.toString());
        }

    }

    public static class Pair {
        String first;
        String second;

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
