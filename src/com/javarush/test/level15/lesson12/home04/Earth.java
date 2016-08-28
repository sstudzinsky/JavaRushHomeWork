package com.javarush.test.level15.lesson12.home04;

/**
 * Created by Shiva on 27.04.2016.
 */
class Earth implements Planet{
    private static Earth instance;

    private Earth(){}

    public static Earth getInstance(){
        if(instance == null){
            instance = new Earth();
        }
        return instance;
    }
}
