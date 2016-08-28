package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Dish;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Stanislav on 26.08.2016.
 */
public class Tablet {
    public final int number;
    private static Logger logger = Logger.getLogger(Tablet.class.toString());

    public Tablet(int number){
        this.number = number;
    }

    public void createOrder(){
        try {
            ConsoleHelper.getAllDishesForOrder();
        }
        catch(IOException e){
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
    }
}
