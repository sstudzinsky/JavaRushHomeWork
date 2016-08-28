package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException
    {
        //args = new String[]{"C:\\Users\\Shiva\\Desktop\\JavaRushHomeWork\\src\\1.txt"};
        BufferedReader br = new BufferedReader(new FileReader(args[0]));
        String row;
        String[] bufer;

        while((row = br.readLine()) != null){
            bufer = row.split(" ");

            int day = Integer.parseInt(bufer[bufer.length - 3]);
            int month = Integer.parseInt(bufer[bufer.length - 2]);
            int year = Integer.parseInt(bufer[bufer.length - 1]);

            GregorianCalendar date = new GregorianCalendar(year, month - 1, day);
            Date birthday = date.getTime();

            StringBuilder name = new StringBuilder();
            for (int i = 0; i < bufer.length - 3; i++) {
                if ( i != bufer.length - 4)
                    name.append(bufer[i].concat(" "));
                else
                    name.append(bufer[i]);
            }

            PEOPLE.add(new Person(name.toString(), birthday));
        }
        br.close();
    }
}