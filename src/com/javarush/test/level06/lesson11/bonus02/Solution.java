package com.javarush.test.level06.lesson11.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Нужно добавить в программу новую функциональность
Задача: У каждой кошки есть имя и кошка-мама. Создать класс, который бы описывал данную ситуацию. Создать два объекта: кошку-дочь и кошку-маму. Вывести их на экран.
Новая задача: У каждой кошки есть имя, кошка-папа и кошка-мама. Изменить класс Cat так, чтобы он мог описать данную ситуацию.
Создать 6 объектов: дедушку(папин папа), бабушку(мамина мама), папу, маму, сына, дочь.
Вывести их всех на экран в порядке: дедушка, бабушка, папа, мама, сын, дочь.

Пример ввода:
дедушка Вася
бабушка Мурка
папа Котофей
мама Василиса
сын Мурчик
дочь Пушинка

Пример вывода:
Cat name is дедушка Вася, no mother, no father
Cat name is бабушка Мурка, no mother, no father
Cat name is папа Котофей, no mother, father is дедушка Вася
Cat name is мама Василиса, mother is бабушка Мурка, no father
Cat name is сын Мурчик, mother is мама Василиса, father is папа Котофей
Cat name is дочь Пушинка, mother is мама Василиса, father is папа Котофей
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String grandPaName = reader.readLine();
        Cat grandPa = new Cat(grandPaName);

        String grandMomName = reader.readLine();
        Cat grandMom = new Cat(grandMomName);

        String fatherName = reader.readLine();
        Cat catFather = new Cat(fatherName, null, grandPa);

        String motherName = reader.readLine();
        Cat catMother = new Cat(motherName, grandMom, null );

        String sonName = reader.readLine();
        Cat son = new Cat(sonName, catMother, catFather);

        String daughterName = reader.readLine();
        Cat catDaughter = new Cat(daughterName, catMother, catFather);

        System.out.println(grandPa);
        System.out.println(grandMom);
        System.out.println(catFather);
        System.out.println(catMother);
        System.out.println(son);
        System.out.println(catDaughter);
    }

    public static class Cat
    {
        private String name;
        private Cat parentMother;
        private Cat parentFather;

        Cat(String name)
        {
            this.name = name;
        }

        Cat(String name, Cat parentMother, Cat parentFather)
        {
            this.name = name;
            this.parentMother = parentMother;
            this.parentFather = parentFather;
        }

        @Override
        public String toString()
        {
            String result = "Cat name is " + name;
            if ( parentMother == null){
                result += ", no mother";
            }
            else{
                result += ", mother is " + parentMother.name;
            }
            if ( parentFather == null){
                result += ", no father";
            }
            else{
                result += ", father is " + parentFather.name;
            }
            return result;
        }
    }

}

/*
public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String grandpaName = reader.readLine();
        Cat catGrandpa = new Cat(grandpaName);
        String grandmaName = reader.readLine();
        Cat catGrandma = new Cat (grandmaName);
        String fatherName = reader.readLine();
        Cat catFather = new Cat (fatherName, catGrandpa, null);
        String motherName = reader.readLine();
        Cat catMother = new Cat (motherName, null, catGrandma);
        String sonName = reader.readLine();
        Cat catSon = new Cat (sonName, catFather, catMother);
        String daughterName = reader.readLine();
        Cat catDaughter = new Cat (daughterName, catFather, catMother);
        //String daughterName = reader.readLine();
        //Cat catDaughter = new Cat(daughterName, catMother);
        System.out.println(catGrandpa);
        System.out.println(catGrandma);
        System.out.println(catFather);
        System.out.println(catMother);
        System.out.println(catSon);
        System.out.println(catDaughter);
    }
    public static class Cat
    {
        private String name;
        private Cat parent1;
        private Cat parent2;
        Cat(String name)
        {
            this.name = name;
        }
        Cat(String name, Cat parent1, Cat parent2)
        {
            this.name = name;
            this.parent1 = parent1;
            this.parent2 = parent2;
        }
        @Override
        public String toString()
        {
            String value = "Cat name is "+name;
            if (parent2 == null)
                value += ", no mother";
            else value += ", mother is " + parent2.name;
            if (parent1 == null)
                value += ", no father";
            else value += ", father is " + parent1.name;
            return(value);
        }
    }
}
 */
