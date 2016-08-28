package com.javarush.test.level18.lesson10.home09;

/* Файлы и исключения
Читайте с консоли имена файлов
Если файла не существует (передано неправильное имя файла), то
перехватить исключение FileNotFoundException, вывести в консоль переданное неправильное имя файла и завершить работу программы.
Закрыть потоки. Не использовать try-with-resources
Не используйте System.exit();
*/


import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";

        while(true){
            try{
                s = br.readLine();
                new FileInputStream(s);
            }
            catch(FileNotFoundException t){
                System.out.println(s);
                break;
            }
            catch(IOException e){}
        }

        try{ br.close(); }
        catch ( Exception e ){}
    }
}
