package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        //напишите тут ваши переменные и конструкторы
        public String name;
        public String secondName;
        public boolean sex;
        public int age;
        public String work;
        public String hobby;

        public Human(String name){
            this.name = name;
        }
        public Human(String name,String secondName){
            this.name = name;
            this.secondName = secondName;
        }
        public Human(String name,boolean sex,String secondName){
            this.name = name;
            this.sex = sex;
            this.secondName = secondName;
        }
        public Human(String name,int age,String work){
            this.name = name;
            this.work = work;
            this.age = age;
        }
        public Human(String name,boolean sex,int age){
            this.name = name;
            this.sex = sex;
            this.age = age;
        }
        public Human(String name,String work,boolean sex){
            this.name = name;
            this.work = work;
            this.sex = sex;
        }
        public Human(String name,boolean sex){
            this.name = name;
            this.sex = sex;
        }
        public Human(String name,String secondName,String hobby){
            this.name = name;
            this.secondName = secondName;
            this.hobby = hobby;
        }
        public Human(String name,String hobby,int age){
            this.name = name;
            this.hobby = hobby;
            this.age = age;
        }
        public Human(String secondName,String hobby,boolean sex,String work){
            this.secondName = secondName;
            this.hobby = hobby;
            this.sex = sex;
            this.work = work;
        }
    }
}
