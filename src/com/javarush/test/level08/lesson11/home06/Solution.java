package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        ArrayList<Human> mamkasChildren = new ArrayList<Human>();
        ArrayList<Human> papkasChildren = mamkasChildren;

        ArrayList<Human> dedasChildren1 = new ArrayList<Human>();
        ArrayList<Human> babasChildren1 = dedasChildren1;

        ArrayList<Human> dedasChildren2 = new ArrayList<Human>();
        ArrayList<Human> babasChildren2 = dedasChildren2;

        Human grandPa1 = new Human("Genka",true,80,dedasChildren1);
        Human grandPa2 = new Human("Sanya",true,82,babasChildren1);
        Human grandBa1 = new Human("Polya",false,81,dedasChildren2);
        Human grandBa2 = new Human("Tanya",false,82,babasChildren2);
        Human father = new Human("Oleg",true,50,papkasChildren);
        Human mother = new Human("Liliya",false,51,mamkasChildren);
        Human stas = new Human("Stas",true,21,new ArrayList<Human>());
        Human vlad = new Human("Vlad",true,27,new ArrayList<Human>());
        Human lena = new Human("Elena",false,21,new ArrayList<Human>());

        mamkasChildren.add(stas);
        mamkasChildren.add(vlad);
        mamkasChildren.add(lena);
        dedasChildren1.add(father);
        dedasChildren1.add(mother);

        System.out.println(grandPa1.toString());
        System.out.println(grandPa2.toString());
        System.out.println(grandBa1.toString());
        System.out.println(grandBa2.toString());
        System.out.println(father.toString());
        System.out.println(mother.toString());
        System.out.println(stas.toString());
        System.out.println(vlad.toString());
        System.out.println(lena.toString());
    }

    // 1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
    public static class Human
    {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<Human>();

        public Human(String name, boolean sex, int age, ArrayList<Human> children){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
