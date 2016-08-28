package com.javarush.test.level19.lesson03.task04;

import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные одного человека.
*/

public class Solution {
    public static class PersonScannerAdapter implements PersonScanner{
        private Scanner scanner;

        PersonScannerAdapter(Scanner scanner){
            this.scanner = scanner;
        }

        @Override
        public Person read() throws IOException
        {
            Person person = null;
            String[] parametrs;
            if (scanner.hasNext()){
                String row = scanner.nextLine();
                parametrs = row.split(" ");
                Date time = (new GregorianCalendar(Integer.parseInt(parametrs[5]), Integer.parseInt(parametrs[4]) - 1, Integer.parseInt(parametrs[3]))).getTime();

                person = new Person(parametrs[1],parametrs[2], parametrs[0], time);
            }

            return person;
        }

        @Override
        public void close() throws IOException
        {
            this.scanner.close();
        }
    }
}
