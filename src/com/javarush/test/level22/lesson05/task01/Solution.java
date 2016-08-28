package com.javarush.test.level22.lesson05.task01;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
Метод main не участвует в тестировании.
*/
public class Solution {
    public static String getPartOfString(String string) throws Exception {
        String res = null;
        try
        {
            int posStart = 0;
            int posEnd = 0;

            int prevPos = 0;
            for (int i = 0; i < 5; i++) {
                int pos = string.indexOf(" ", prevPos + 1);
                prevPos = pos;

                if (i == 3) posStart = ++pos;
                if (i == 4) posEnd = pos;
            }
            String word = string.substring(posStart, posEnd);

            res = string.substring(string.indexOf(" ") + 1, string.indexOf(word) + word.length());
        }
        catch(Exception e){
            throw new TooShortStringException();
        }

        return res;
    }

    public static void main(String[] args) throws Exception
    {
        String s = "JavaRush - лучший сервис обучения Java.";
        System.out.println(getPartOfString(s));
    }

    public static class TooShortStringException extends Exception {

    }
}
