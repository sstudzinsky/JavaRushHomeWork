package com.javarush.test.level05.lesson05.task02;

/* Реализовать метод fight
Реализовать метод boolean fight(Cat anotherCat):
реализовать механизм драки котов в зависимости от их веса, возраста и силы.
Зависимость придумать самому. Метод должен определять, выиграли ли мы (this) бой или нет,
т.е. возвращать true, если выиграли и false - если нет.
Должно выполняться условие:
если cat1.fight(cat2) = true , то cat2.fight(cat1) = false
*/

public class Cat
{
    public String name;
    public int age;
    public int weight;
    public int strength;


    public static void main(String[] args)
    {
        Cat stas = new Cat();
        stas.strength = 5;
        stas.weight = 4;
        stas.age = 21;
        stas.name = "Stas";

        Cat dima = new Cat();
        dima.strength = 4;
        stas.weight = 4;
        stas.age = 21;
        stas.name = "Dima";
    }

    public Cat()
    {
        this.name = name;
        this.age = age;
        this.strength = strength;
        this.weight = weight;
    }

    public boolean fight(Cat anotherCat)
    {
        //напишите тут ваш код
        if ( this.strength > anotherCat.strength ){
            return true;
        }
        else
            return false;
    }
}
