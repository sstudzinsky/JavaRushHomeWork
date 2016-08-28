package com.javarush.test.level15.lesson12.bonus02;

/**
 * Created by Shiva on 29.04.2016.
 */
public abstract class DrinkMaker
{
    public abstract void getRightCup();
    public abstract void putIngredient();
    public abstract void pour();

    void makeDrink(){
        getRightCup();
        putIngredient();
        pour();
    }
}
