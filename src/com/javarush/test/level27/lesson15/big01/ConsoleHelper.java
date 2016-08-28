package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stanislav on 26.08.2016.
 */
public class ConsoleHelper {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString(){
        String row = null;

        try {
            row = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return row;
    }

    public static List<Dish> getAllDishesForOrder() throws IOException{
        ArrayList<Dish> dishes = new ArrayList<>();
        String row;

        do {
            row = readString();

            for (Dish dish : Dish.values()) {
                if (row.equals(dish.toString())) {
                    dishes.add(dish);
                    break;
                }
            }

        } while (! row.equals("exit"));

        return dishes;
    }

}
