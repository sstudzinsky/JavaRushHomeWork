package com.javarush.test.level05.lesson07.task01;

/* Создать класс Friend
Создать класс Friend (друг) с тремя инициализаторами (тремя методами initialize):
- Имя
- Имя, возраст
- Имя, возраст, пол
*/

public class Friend
{

    //напишите тут ваш код
    private String info = null;

    public void initialize(String name){
        this.info = name;
    }
    public void initialize(String name,int age){
        this.info = name+", "+age;
    }
    public void initialize(String name,int age,String gender){
        this.info = name+", "+age+", "+gender;
    }
}
