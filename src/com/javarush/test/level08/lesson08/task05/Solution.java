package com.javarush.test.level08.lesson08.task05;

import java.util.HashMap;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        //напишите тут ваш код
        HashMap<String,String> stas = new HashMap<String, String>();
        stas.put("фамилия1","имя1");
        stas.put("фамилия2","имя2");
        stas.put("фамилия3","имя3");
        stas.put("фамилия4","имя4");
        stas.put("фамилия5","имя5");
        stas.put("фамилия6","имя4");
        stas.put("фамилия7","имя6");
        stas.put("фамилия8","имя4");
        stas.put("фамилия9","имя7");
        stas.put("фамилия10","имя4");

        return stas;
    }

    public static void main(String[] args){
        HashMap<String, String> stasik = createMap();
        removeTheFirstNameDuplicates(stasik);

        HashMap<String, String> copy = new HashMap<String, String>(stasik);
        for(Map.Entry<String, String> pair : copy.entrySet()){
            System.out.println(pair.getKey()+" : "+pair.getValue());
        }
    }


    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        //напишите тут ваш код
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet())
        {
            String st = pair.getValue();
            String Kt = pair.getKey();
            for (Map.Entry<String,String> sPair : copy.entrySet()){
                if (st.equals(sPair.getValue()) && Kt != sPair.getKey() ){
                    map.remove(pair.getKey());
                    map.remove(sPair.getKey());
                }
            }
        }


    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}
