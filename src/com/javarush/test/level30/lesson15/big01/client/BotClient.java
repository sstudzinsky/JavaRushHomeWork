package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Stanislav on 05.09.2016.
 */
public class BotClient extends Client {
    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSentTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        return "date_bot_" + Math.round(Math.random() * 99);
    }

    public static void main(String[] args) {
        BotClient client = new BotClient();
        client.run();
    }

    public class BotSocketThread extends Client.SocketThread {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            String[] values = message.split(": ");

            if (values.length >= 2) {
                String name = message.split(": ")[0];
                String text = message.split(": ")[1];

                SimpleDateFormat format = null;

                if (text.equals("дата")) format = new SimpleDateFormat("d.MM.YYYY");
                else if (text.equals("день")) format = new SimpleDateFormat("d");
                else if (text.equals("месяц")) format = new SimpleDateFormat("MMMM");
                else if (text.equals("год")) format = new SimpleDateFormat("YYYY");
                else if (text.equals("время")) format = new SimpleDateFormat("H:mm:ss");
                else if (text.equals("час")) format = new SimpleDateFormat("H");
                else if (text.equals("минуты")) format = new SimpleDateFormat("m");
                else if (text.equals("секунды")) format = new SimpleDateFormat("s");

                if (format != null) {
                    sendTextMessage("Информация для " + name + ": " + format.format(Calendar.getInstance().getTime()));
                }
            }
        }
    }
}
