package com.javarush.test.level14.lesson08.home09;

/**
 * Created by Shiva on 20.04.2016.
 */
public class Hrivna extends Money
{
    public String getCurrencyName(){
        return "HRN";
    }

    public Hrivna (double amount){
        super(amount);
    }
}
