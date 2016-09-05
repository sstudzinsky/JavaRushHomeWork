package com.javarush.test.level30.lesson15.big01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Stanislav on 04.09.2016.
 */
public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            Connection connection = null;
            String name = null;

            try {
                SocketAddress socketAddress = socket.getRemoteSocketAddress();
                ConsoleHelper.writeMessage("Установлено соединение с " + socketAddress);

                connection = new Connection(socket);
                name = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, name));
                sendListOfUsers(connection, name);
                serverMainLoop(connection, name);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                ConsoleHelper.writeMessage("Ошибка при обмене данными с удаленным адресом");
                if (name != null){
                    connectionMap.remove(name);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED, name));
                }

            } finally {
                try {
                    connection.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            ConsoleHelper.writeMessage("Соединение закрыто");
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            String userName;

            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message newMessage = connection.receive();
                userName = newMessage.getData();

                if (userName == null
                        || newMessage.getType() != MessageType.USER_NAME
                        || userName.equals("")
                        || connectionMap.containsKey(userName)) {

                    continue;
                }

                connectionMap.put(userName, connection);
                connection.send(new Message(MessageType.NAME_ACCEPTED));
                break;
            }

            return userName;
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException {
            for (String otherName : connectionMap.keySet()) {
                Message message = new Message(MessageType.USER_ADDED, otherName);
                if (otherName.equals(userName)) continue;
                connection.send(message);
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();

                if (message.getType() == MessageType.TEXT) {
                    String messageVsName = userName + ": " + message.getData();
                    Message newMessage = new Message(MessageType.TEXT, messageVsName);
                    sendBroadcastMessage(newMessage);
                } else
                    ConsoleHelper.writeMessage("Error");
            }
        }
    }

    public static void sendBroadcastMessage(Message message) {
        for (Connection connection : connectionMap.values()) {
            try {
                connection.send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Ошибка при отпрвке сообщения.");
            }
        }
    }

    public static void main(String[] args) {
        try {
            ConsoleHelper.writeMessage("Порт сервера, пжлста:");
            int port = ConsoleHelper.readInt();

            try (ServerSocket serverSocket = new ServerSocket(port)) {
                ConsoleHelper.writeMessage("Сервер запущен!");

                while (true) {
                    Socket socket = serverSocket.accept();
                    Handler handler = new Handler(socket);
                    handler.start();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
