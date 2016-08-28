package com.javarush.test.level05.lesson09.task05;

/* Создать класс прямоугольник (Rectangle)
Создать класс прямоугольник (Rectangle). Его данными будут top, left, width, height (левая координата, верхняя, ширина и высота). Создать для него как можно больше конструкторов:
Примеры:
-	заданы 4 параметра: left, top, width, height
-	ширина/высота не задана (оба равны 0)
-	высота не задана (равно ширине) создаём квадрат
-	создаём копию другого прямоугольника (он и передаётся в параметрах)
*/

public class Rectangle
{
    //напишите тут ваш код
    private int top;
    private int left;
    private int width;
    private int height;
    private Rectangle rect;


    public Rectangle(int left,int top,int width,int height){
        this.height = height;
        this.top = top;
        this.left = left;
        this.width = width;
    }
    public Rectangle(int left,int top){
        this.height = 0;
        this.top = top;
        this.left = left;
        this.width = 0;
    }
    public Rectangle(int left,int top,int width){
        this.height = width;
        this.top = top;
        this.left = left;
        this.width = width;
    }
    public Rectangle(Rectangle rect){
        this.height = rect.height;
        this.top = rect.top;
        this.left = rect.left;
        this.width = rect. width;
    }
}
