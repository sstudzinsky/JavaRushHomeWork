package com.javarush.test.level29.lesson15.big01.human;

/**
 * Created by Stanislav on 31.08.2016.
 */
public class BloodGroup {
    private int code;

    private BloodGroup(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static BloodGroup first(){
        return new BloodGroup(1);
    }
    public static BloodGroup second(){
        return new BloodGroup(2);
    }
    public static BloodGroup third(){
        return new BloodGroup(3);
    }
    public static BloodGroup fourth(){
        return new BloodGroup(4);
    }
}
