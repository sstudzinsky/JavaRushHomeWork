package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;

        while (!(s = br.readLine()).equals("exit")){
            new ReadThread(s).start();
        }

        br.close();
    }

    public static class ReadThread extends Thread {
        public String fileName;

        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут

        public void run(){
            try
            {
                File file = new File(fileName);
                FileInputStream fis = new FileInputStream(file);




                int[] arrBytes = new int[256];

                byte fileImage[]=new byte[fis.available()];
                long fileSize=fileImage.length;
                fis.read(fileImage);
                for (int i = 0; i <fileSize ; i++) arrBytes[fileImage[i] & 0b11111111]++;
                fis.close();


                int max = Integer.MIN_VALUE;
                int res = 0;

                for (int l : arrBytes) if (max < l) max = l;
                for (int i = 0; i < arrBytes.length; i++){
                    if (arrBytes[i] == max) res = i;
                }

                resultMap.put(fileName, res);
            }
            catch(IOException e){

            }
        }
    }
}
