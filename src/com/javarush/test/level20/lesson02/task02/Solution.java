package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream("C:\\Users\\Shiva\\Desktop\\JavaRushHomeWork\\src\\1.txt", true);
            InputStream inputStream = new FileInputStream("C:\\Users\\Shiva\\Desktop\\JavaRushHomeWork\\src\\1.txt");

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);

            User stas = new User();
            stas.setBirthDate(format.parse("21.01.2000"));
            stas.setCountry(User.Country.UKRAINE);
            stas.setFirstName("Stas");
            stas.setLastName("Studzinsky");
            stas.setMale(true);
            javaRush.users.add(stas);

            User nelly = new User();
            nelly.setBirthDate(format.parse("14.03.1995"));
            nelly.setCountry(User.Country.UKRAINE);
            nelly.setFirstName("Nelly");
            nelly.setLastName("Salimova");
            nelly.setMale(false);
            javaRush.users.add(nelly);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }



    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);

        public void save(OutputStream outputStream) {
            //implement this method - реализуйте этот метод
            PrintWriter fw = new PrintWriter(outputStream);
            SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);

            for (User user : users) {
                fw.println(user.getFirstName());
                fw.println(user.getLastName());

                fw.println(formatter.format(user.getBirthDate()));

                fw.println(user.isMale());
                fw.println(user.getCountry().toString());
                fw.flush();
            }
            fw.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;

            while((line = reader.readLine()) != null ){
                User user = new User();
                user.setFirstName(line);
                user.setLastName(reader.readLine());

                Date formatter = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH).parse(reader.readLine());
                user.setBirthDate(formatter);

                user.setMale(Boolean.parseBoolean(reader.readLine()));

                switch (reader.readLine()){
                    case ("UKRAINE") :
                        user.setCountry(User.Country.UKRAINE);
                        break;
                    case ("RUSSIA") :
                        user.setCountry(User.Country.RUSSIA);
                        break;
                    default :
                        user.setCountry(User.Country.OTHER);
                        break;
                }
                users.add(user);
            }
            reader.close();
        }
    }
}
