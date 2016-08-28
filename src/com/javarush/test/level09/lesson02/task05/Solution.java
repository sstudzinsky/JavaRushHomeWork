package com.javarush.test.level09.lesson02.task05;

/* Метод должен возвращать результат – глубину его стек-трейса
Написать метод, который возвращает результат – глубину его стек трейса – количество методов в нем (количество элементов в списке). Это же
 число метод должен выводить на экран.
*/

import java.io.FileNotFoundException;

public class Solution
{
    public static void main(String[] args) throws ClassNotFoundException{
        try{
            getStackTraceDeep();
        }
        catch (FileNotFoundException e){

        }
    }

    public static int getStackTraceDeep() throws FileNotFoundException, ClassNotFoundException
    {
        return 1;
    }
}
