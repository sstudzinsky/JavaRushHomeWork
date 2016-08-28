package com.javarush.test.level23.lesson06.task02;

import java.util.ArrayList;
import java.util.Arrays;

/* Рефакторинг
Отрефакторите класс Solution: вынесите все константы в public вложенный(nested) класс Constants.
Запретите наследоваться от Constants.
*/
public class Solution {
    public static void main(String[] args) {
        String[] inputs = new String[] {
                "u",
                "you",
                "Youuuuu",
                "youtube"
        };


        for (String input : inputs) {
            autocorrect(input);
        }
    }

    public static String autocorrect(String input) {
        // your code here
        ArrayList<String> list = new ArrayList<>();
        list.add(new String("\\yo[u]+"));
        list.add(new String("\\d"));
        list.add(new String("\\ u "));
        list.add(new String("\\ you "));

        String result = null;
        for (String s : list) {
            result = input.replaceAll(s, "your sister");
        }

        return result; // "corrected" input
    }
}
