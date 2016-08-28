package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static void main(String[] args){
        HashMap<String, String> stasik = createMap();
        System.out.println(getCountTheSameFirstName(stasik,"Stas7"));

    }
    public static HashMap<String, String> createMap()
    {
        //напишите тут ваш код
        HashMap<String, String> mapp = new HashMap<String, String>();
        mapp.put("Stud1","Stas" );
        mapp.put("Stud2","Stas1" );
        mapp.put("Stud3","Stas2" );
        mapp.put("Stud4","Stas3" );
        mapp.put("Stud5","Stas7" );
        mapp.put("Stud6","Stas5" );
        mapp.put("Stud7","Stas7" );
        mapp.put("Stud8","Stas14" );
        mapp.put("Stud9","Stas7" );
        mapp.put("Stud11","Stas51" );

        return mapp;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        //напишите тут ваш код
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        int count = 0;

        while (iterator.hasNext()){
            Map.Entry<String, String> pair = iterator.next();
            String lName = pair.getKey();
            String fName = pair.getValue();
            System.out.println(fName+":"+lName);
            if ( fName.equals(name) ){
                count++;
            }
        }
        return count;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName)
    {
        //напишите тут ваш код
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        int count = 0;

        while (iterator.hasNext()){
            Map.Entry<String, String> pair = iterator.next();
            String lName  = pair.getKey();
            String fName = pair.getValue();
            System.out.println(fName+":"+lName);
            if ( lName.equals(lastName) ){
                count++;
            }
        }
        return count;
    }
}
