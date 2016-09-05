package com.javarush.test.level30.lesson04.home01;

import java.util.concurrent.TransferQueue;

/**
 * Created by Stanislav on 01.09.2016.
 */
public class Consumer implements Runnable {
    private TransferQueue<ShareItem> queue;

    public Consumer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }

        while (true) {
            try {
                if (Thread.currentThread().isInterrupted()){
                    return;
                }
                ShareItem item = queue.take();
                System.out.println("Processing " + item.toString());
            } catch (InterruptedException e) {
            }
        }
    }
}
