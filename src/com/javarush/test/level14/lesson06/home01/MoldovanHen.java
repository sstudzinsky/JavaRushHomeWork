package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Shiva on 17.04.2016.
 */
public class MoldovanHen extends Hen
{
    int getCountOfEggsPerMonth(){return 7;}

    String getDescription(){return super.getDescription() + " Моя страна - " + Country.MOLDOVA + ". Я несу "+getCountOfEggsPerMonth()+" яиц в месяц."; }
}
