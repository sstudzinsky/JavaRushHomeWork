package com.javarush.test.level05.lesson12.home02;

/* Man and Woman
1. Внутри класса Solution создай public static классы Man и Woman.
2. У классов должны быть поля: name(String), age(int), address(String).
3. Создай конструкторы, в которые передаются все возможные параметры.
4. Создай по два объекта каждого класса со всеми данными используя конструктор.
5. Объекты выведи на экран в таком формате [name + " " + age + " " + address].
*/

public class Solution
{
    public static void main(String[] args)
    {
        //создай по два объекта каждого класса тут

        Man stas = new Man("Stas",21,"Slavyansk");
        Man dima = new Man("Dima",20,"Schachtyorsk");

        Woman nellya = new Woman("Nellya",21,"Schachtyorsk");
        Woman juliya = new Woman("Juliya",19,"Schachtyorsk");

        //выведи их на экран тут
        System.out.println(stas.toString());
        System.out.println(dima.toString());
        System.out.println(nellya.toString());
        System.out.println(juliya.toString());
    }

    //добавьте тут ваши классы
    public static class Man
    {
        private String name;
        private int age;
        private String address;

        public String toString() { return this.name + " " + this.age + " " + this.address; }

        public Man(String name,int age,String address){
            this.name = name;
            this.age = age;
            this.address = address;
        }
    }
    public static class Woman
    {
        private String name;
        private int age;
        private String address;

        public String toString() { return this.name + " " + this.age + " " + this.address; }

        public Woman(String name,int age,String address){
            this.name = name;
            this.age = age;
            this.address = address;
        }
    }
}
