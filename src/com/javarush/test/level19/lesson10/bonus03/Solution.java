package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        File file = new File("C:\\Users\\Shiva\\Desktop\\JavaRushHomeWork\\src\\1.txt");
        args = new String[]{"span"};
        //File file = new File(br.readLine());
        br.close();

        String info = readData(file);
        String pattern = args[0];

        recursion(info, pattern);
    }

    public static void recursion(String file, String arg){
        int firstStart = file.indexOf("<" + arg);
        int firstEnd   = file.indexOf(">", firstStart);

        int nextStart = file.indexOf("<" + arg, firstEnd);
        int nextEnd   = file.indexOf("</" + arg + ">", firstEnd);

        if (nextStart < nextEnd && nextStart != -1) {
            String nextLine = file.substring(nextStart, nextEnd + arg.length() + 3);
            recursion(nextLine, arg);
        }
        else{
            System.out.println(file.substring(firstStart, nextEnd + arg.length() + 3));
        }


    }

    public static String readData(File file) throws FileNotFoundException, IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while((line = br.readLine()) != null){
            sb.append(line).append("\n");
        }
        return sb.toString();
    }
}
