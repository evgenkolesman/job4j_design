package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/* Бот
 * Реализация простого бота, на сервере номер 9000
 * Работа бота по заданиям Hello - отвечаем Hello, What - отвечает what, Exit - заканчивает работу
 *@author Kolesnikov Evgeniy (evgeniysanich@mail.ru)
 * @version 1.0
 */
public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String answerText = "";
                    String str = in.readLine();
                    while (!str.isEmpty()) {
                        System.out.println(str);
                        System.out.println(System.lineSeparator());
                        answerText = "Hello, dear friend.";
                        if (str.contains("Hello")) {
                            answerText = "Hello!\r\n\r\n";
                            //writeAnswer(out, answerText);
                        } else if (str.contains("Exit")) {
                            answerText = "Bye";
                            //writeAnswer(out, answerText);
                            server.close(); // переделал на выход
                            break;
                        } else if (str.contains("What")) {
                            answerText = "What?\r\n";
                            //writeAnswer(out, answerText);
                        }
                        //writeAnswer(out, answerText);
                        str = in.readLine();
                    }
                    writeAnswer(out, answerText);
                }
            }
        }
    }

    private static void writeAnswer(OutputStream out, String answerText) throws IOException {
        out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
        out.write(answerText.getBytes());
    }
}


/*if (str.contains("/?msg=")) {
                            String[] msg = str.split("");
                            String[] msgText1 = msg[1].split("=", 2);
                            String msgText = msgText1[1];*/