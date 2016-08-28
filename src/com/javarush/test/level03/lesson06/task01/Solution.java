package com.javarush.test.level03.lesson06.task01;

/* Мама мыла раму
Вывести на экран все возможные комбинации слов «Мама», «Мыла», «Раму».
Подсказка: их 6 штук. Каждую комбинацию вывести с новой строки. Слова не разделять. Пример:
МылаРамуМама
РамуМамаМыла
...
*/

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        String s = "Мама";
        String b = "Мыла";
        String c = "Раму";

        System.out.println(s+b+c);
        System.out.println(s+c+b);
        System.out.println(b+c+s);
        System.out.println(b+s+c);
        System.out.println(c+s+b);
        System.out.println(c+b+s);
    }
}