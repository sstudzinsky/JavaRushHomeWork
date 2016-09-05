package com.javarush.test.level30.lesson06.home01;

import java.util.concurrent.RecursiveTask;

/**
 * Created by Stanislav on 01.09.2016.
 */
public class BinaryRepresentationTask extends RecursiveTask {
    private int dec;
    public BinaryRepresentationTask(int i) {
        this.dec = i;
    }

    @Override
    protected Object compute() {
        int a = dec % 2;
        int b = dec / 2;

        String result = String.valueOf(a);
        if (b > 0) {
            return fork() + result;
        }
        return result;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
