package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static void main(String[] args){
        HashMap<String, Date> stas = createMap();
        removeAllSummerPeople(stas);
}

    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone1", new Date("JANUARY 1 1980"));
        map.put("Stallone2", new Date("FEBRUARY 1 1980"));
        map.put("Stallone3", new Date("APRIL 1 1980"));
        map.put("Stallone4", new Date("APRIL 1 1980"));
        map.put("Stallone5", new Date("JUNE 1 1980"));
        map.put("Stallone6", new Date("JUNE 1 1980"));
        map.put("Stallone7", new Date("APRIL 1 1980"));
        map.put("Stallone8", new Date("JUNE 1 1980"));
        map.put("Stallone9", new Date("MAY 1 1980"));
        map.put("Stallone10", new Date("JUNE 1 1980"));

        //напишите тут ваш код
        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        //напишите тут ваш код
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()){
            Map.Entry<String, Date> pair = iterator.next();
            String key = pair.getKey();
            Date valu = pair.getValue();

            if (valu.getMonth() >= 5 && valu.getMonth() <= 7){
                iterator.remove();
            }
        }

    }
}
