package com.javarush.test.level20.lesson10.home05;

import java.io.*;
import java.util.logging.Logger;

/* Сериализуйте Person
Сериализуйте класс Person стандартным способом. При необходимости поставьте полям модификатор transient.
*/
public class Solution {
    public static void main(String[] args) throws Exception{
        Person stas = new Person("Stas","Stdz", "Ukraine", Sex.MALE);
        ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Shiva\\Desktop\\JavaRushHomeWork\\src\\1.txt"));
        ous.writeObject(stas);
        ous.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\Shiva\\Desktop\\JavaRushHomeWork\\src\\1.txt"));
        Person newStas = (Person) ois.readObject();
        ois.close();
    }

    public static class Person implements Externalizable {
        String firstName;
        String lastName;
        transient String fullName;
        transient final String greetingString = "Hello, ";;
        String country;
        Sex sex;
        transient PrintStream outputStream;
        transient Logger logger;

        public Person(){
        }

        public Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(firstName);
            out.writeObject(lastName);
            out.writeObject(country);
            out.writeObject(sex);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            firstName = (String) in.readObject();
            lastName = (String) in.readObject();
            country = (String) in.readObject();
            sex = (Sex) in.readObject();

            fullName = String.format("%s, %s", lastName, firstName);
            logger = Logger.getLogger(String.valueOf(Person.class));
            outputStream = System.out;
        }
    }

    enum Sex {
        MALE,
        FEMALE
    }
}
