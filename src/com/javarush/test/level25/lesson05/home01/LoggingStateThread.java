package com.javarush.test.level25.lesson05.home01;

/**
 * Created by Shiva on 12.08.2016.
 */
public class LoggingStateThread extends Thread {
    Thread curThread;


    /* Мониторинг состояния нити
    В отдельном классе создать нить LoggingStateThread,
    которая будет выводить в консоль все состояния (State) переданной в конструктор нити.
    Нить LoggingStateThread должна сама завершаться после остановки переданной в конструктор нити.
    Метод main не участвует в тестировании.
    */

    public LoggingStateThread(Thread t){
        curThread = t;
        this.setDaemon(true);
    }

    Thread.State lastState;

    @Override
    public void run() {
        lastState = curThread.getState();
        System.out.println(lastState);


        while(lastState != State.TERMINATED) {
            if (lastState != curThread.getState()) {
                lastState = curThread.getState();
                System.out.println(lastState);
            }
        }
    }
}
