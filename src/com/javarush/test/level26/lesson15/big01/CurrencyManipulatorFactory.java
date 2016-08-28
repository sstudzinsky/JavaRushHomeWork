package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.CurrencyManipulator;

import java.util.HashMap;

public final class CurrencyManipulatorFactory
{
    static HashMap<String, CurrencyManipulator> map = new HashMap<>();
    static boolean isExist = false;

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode)
    {
        isExist = false;
        CurrencyManipulator current;

        if (map.containsKey(currencyCode))
            return map.get(currencyCode);
        else {
            current = new CurrencyManipulator(currencyCode);
            map.put(currencyCode, current);
            return current;
        }
    }

    private CurrencyManipulatorFactory() {}
}