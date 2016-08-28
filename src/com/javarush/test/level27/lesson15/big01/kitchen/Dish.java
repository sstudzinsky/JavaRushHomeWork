package com.javarush.test.level27.lesson15.big01.kitchen;

/**
 * Created by Stanislav on 26.08.2016.
 */
public enum  Dish {
    Fish,
    Steak,
    Soup,
    Juice,
    Water;

    public static String allDishesToString(){
        StringBuffer sb = new StringBuffer();

        for (Dish dish : Dish.values()) {
            sb.append(dish.toString() + ", ");
        }
        sb.replace(sb.length() - 2, sb.length(), "");
        return sb.toString();
    }
}
