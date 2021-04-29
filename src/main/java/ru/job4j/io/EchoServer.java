package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/* Бот
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
                    String answerText = "Hello, dear friend.";
                    String str = in.readLine();
                    while (!str.isEmpty()) {
                        System.out.println(str);
                        System.out.println(System.lineSeparator());
                        //String answerText = "Hello, dear friend.";
                        if (str.contains("Hello")) {
                            answerText = "Hello";
                        }
                        if (str.contains("Exit")) {
                            out.write("Bye".getBytes());
                            server.close(); // переделал на выход
                            break;
                        }
                        if (str.contains("What")) {
                            answerText ="What?";
                        }

                        str = in.readLine();
                    }
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    out.write(answerText.getBytes());
                }
            }
        }
    }
}
