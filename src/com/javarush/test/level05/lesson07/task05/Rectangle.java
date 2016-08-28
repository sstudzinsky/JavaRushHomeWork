package com.javarush.test.level05.lesson07.task05;

/* Создать класс прямоугольник (Rectangle)
Создать класс прямоугольник (Rectangle). Его данными будут top, left, width, height (левая координата, верхняя, ширина и высота). Создать для него как можно больше методов initialize(…)
Примеры:
-	заданы 4 параметра: left, top, width, height
-	ширина/высота не задана (оба равны 0)
-	высота не задана (равно ширине) создаём квадрат
-	создаём копию другого прямоугольника (он и передаётся в параметрах)
*/

public class Rectangle
{
    //напишите тут ваш код
    private int left;
    private int top;
    private int width;
    private int height;
    private Rectangle rectangle;

    public void initialize(int left,int top,int width,int height){
        this.left = left;
        this.top = top;
        this.width = width;
        this.height = height;
    }

    public void initialize(int left,int top){
        this.left = left;
        this.top = top;
        this.height = 0;
        this.width = 0;
    }

    public void initialize(int left,int top,int width){
        this.left = left;
        this.top = top;
        this.height = width;
        this.width = width ;
    }

    public void initialize(Rectangle rectangle){
        this.left = rectangle.left;
        this.width = rectangle.width;
        this.height = rectangle.height;
        this.top = rectangle.top;
    }

}
