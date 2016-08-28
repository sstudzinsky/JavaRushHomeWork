package com.javarush.test.level15.lesson12.home04;

/**
 * Created by Shiva on 27.04.2016.
 */
class Moon implements Planet{
    private static Moon instance;

    private Moon(){}

    public static Moon getInstance(){
        if(instance == null){
            instance = new Moon();
        }
        return instance;
    }
}
