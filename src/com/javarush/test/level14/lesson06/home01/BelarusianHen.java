package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Shiva on 17.04.2016.
 */
public class BelarusianHen extends Hen
{
    int getCountOfEggsPerMonth(){return 5;}

    String getDescription(){return super.getDescription() + " Моя страна - " + Country.BELARUS + ". Я несу "+getCountOfEggsPerMonth()+" яиц в месяц."; }
    /*
    getDescription
    Методы должны возвращать строку вида:
    <getDescription() родительского класса>  + <" Моя страна - Sssss. Я несу N яиц в месяц.">
    где Sssss - название страны
    где N - количество яиц в месяц
    */
}
