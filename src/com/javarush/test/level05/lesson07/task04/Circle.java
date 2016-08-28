package com.javarush.test.level05.lesson07.task04;

/* Создать класс Circle
Создать класс (Circle) круг, с тремя инициализаторами:
- centerX, centerY, radius
- centerX, centerY, radius, width
- centerX, centerY, radius, width, color
*/

public class Circle
{
    //напишите тут ваш код
    private int x;
    private int y;
    private int rad;
    private int width;
    private String color;

    public void initialize(int x,int y,int rad){
        this.x = x;
        this.y = y;
        this.rad = rad;
    }

    public void initialize(int x, int y, int rad, int width){
        this.x = x;
        this.y = y;
        this.rad = rad;
        this.width = width;
    }

    public void initialize(int x, int y, int rad, int width,String color){
        this.x = x;
        this.y = y;
        this.rad = rad;
        this.width = width;
        this.color = color;
    }
}
