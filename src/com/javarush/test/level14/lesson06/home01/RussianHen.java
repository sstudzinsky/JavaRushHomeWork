package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Shiva on 17.04.2016.
 */
public class RussianHen extends Hen
{
    int getCountOfEggsPerMonth(){return 11;}

    String getDescription(){return super.getDescription() + " Моя страна - " + Country.RUSSIA + ". Я несу "+getCountOfEggsPerMonth()+" яиц в месяц."; }
}
