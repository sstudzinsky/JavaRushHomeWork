package com.javarush.test.level20.lesson10.home07;

import java.io.*;

/* Переопределение сериализации в потоке
Сериализация/десериализация Solution не работает.
Исправьте ошибки не меняя сигнатуры методов и класса.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать экземпляр класса Solution
2) записать в него данные  - writeObject
3) сериализовать класс Solution  - writeObject(ObjectOutputStream out)
4) десериализовать, получаем новый объект
5) записать в новый объект данные - writeObject
6) проверить, что в файле есть данные из п.2 и п.5
*/
public class Solution implements Serializable, AutoCloseable {
    transient private FileOutputStream stream;
    String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.stream = new FileOutputStream(fileName);
    }

    public static void main(String[] args) throws Exception {
        Solution solution1 = new Solution("C:\\Users\\Shiva\\Desktop\\JavaRushHomeWork\\src\\1.txt");
        solution1.writeObject("Hi1");
        solution1.close();

        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Shiva\\Desktop\\JavaRushHomeWork\\src\\3.txt");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
        outputStream.writeObject(solution1);
        outputStream.flush();
        outputStream.close();

        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Shiva\\Desktop\\JavaRushHomeWork\\src\\3.txt");
        ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
        Solution solution2 = (Solution) inputStream.readObject();
        inputStream.close();
        solution2.writeObject("Hi2");
        solution2.writeObject("Hi3");
        solution2.close();
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        stream = new FileOutputStream(this.fileName, true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }
}
