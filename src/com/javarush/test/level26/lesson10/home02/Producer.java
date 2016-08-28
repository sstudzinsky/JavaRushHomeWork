package com.javarush.test.level26.lesson10.home02;

import java.util.concurrent.ConcurrentHashMap;

public class Producer implements Runnable {
    protected ConcurrentHashMap<String, String> map;
    /* Мир не меняется, меняемся мы.
Разберитесь с ConcurrentHashMap
В отдельном файле создайте класс Producer, который будет:
1. каждые полсекунды выводить на консоль с новой строки начиная с 1 фразу [Some text for i] , пример "Some text for 1"
2. при возникновении исключения выводить в консоль [[TREAD_NAME] thread was terminated], пример "[thread-1] thread was terminated"
*/
    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    public void run() {
        try {
            int i = 1;
            while (true) {
                System.out.println("Some text for "+i++);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
        }
    }
}
