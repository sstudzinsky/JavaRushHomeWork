package com.javarush.test.level14.lesson08.home09;

public abstract class Money
{
    private double mon;

    public Money(double amount)
    {
        this.mon = amount;
    }

    public double getAmount(){
        return mon;
    }

    public abstract String getCurrencyName();
}

