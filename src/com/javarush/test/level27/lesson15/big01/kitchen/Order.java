package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.List;

/**
 * Created by Stanislav on 26.08.2016.
 */
public class Order {
    List<Dish> dishes;
    Tablet tablet;

    public Order(Tablet tablet) {
        this.tablet = tablet;

        try {
            dishes = ConsoleHelper.getAllDishesForOrder();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        if (dishes.isEmpty()){
            return "";
        }
        else{
            String row = String.format("Your order: [%s] of Tablet{number=%d}", Dish.allDishesToString(), tablet.number);
            return row;
        }
    }
}
