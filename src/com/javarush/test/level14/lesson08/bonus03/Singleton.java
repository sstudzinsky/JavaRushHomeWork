package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by Shiva on 23.04.2016.
 */
public class Singleton
{
    private Singleton(){};
    private static Singleton stas;

    static Singleton getInstance(){
        if (stas == null)
            stas = new Singleton();
        return stas;
    }
}
