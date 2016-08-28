package com.javarush.test.level08.lesson03.task01;

/* HashSet из растений
Создать коллекцию HashSet с типом элементов String.
Добавить в неё 10 строк: арбуз, банан, вишня, груша, дыня, ежевика, жень-шень, земляника, ирис, картофель.
Вывести содержимое коллекции на экран, каждый элемент с новой строки.
Посмотреть, как изменился порядок добавленных элементов.
*/

import java.util.HashSet;
import java.util.Set;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        Set<String> sett = new HashSet<>();

        sett.add("арбуз");
        sett.add("банан");
        sett.add("вишня");
        sett.add("груша");
        sett.add("дыня");
        sett.add("ежевика");
        sett.add("жень-шень");
        sett.add("земляника");
        sett.add("ирис");
        sett.add("картофель");

        for (String text : sett){
            System.out.println(text);
        }
    }
}
