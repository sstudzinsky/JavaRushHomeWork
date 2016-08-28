package com.javarush.test.level26.lesson15.big01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ConsoleHelper {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString(){
        String row = null;

        try {
            row = bufferedReader.readLine();
        } catch (IOException ignore) {}

        return row;
    }
}
