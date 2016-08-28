package com.javarush.test.level22.lesson09.task03;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution {
    public static void main(String[] args) throws IOException
    {
        //...
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //String filePath = br.readLine();
        //File file = new File(filePath);
        File file = new File("C:\\Users\\Shiva\\Desktop\\JavaRushHomeWork\\src\\1.txt");

        BufferedReader reader = new BufferedReader(new FileReader(file));
        ArrayList<String> list = new ArrayList<String>();
        String line;

        while((line = reader.readLine()) != null){
            String[] bufer = line.split(" ");
            Collections.addAll(list, bufer);
        }

        StringBuilder result = getLine((String[]) list.toArray());
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        if (words == null || words.length == 0){
            return new StringBuilder();
        }
        if (words.length == 1){
            return new StringBuilder(words[0]);
        }

        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, words);

        StringBuilder sb = new StringBuilder(list.get(0));

        while(list.size() > 0){

        }

        return null;
    }
}
