package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    public static void main(String[] args) {

        final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str = in.readLine();
                    System.out.println(str);
                    System.out.println(System.lineSeparator());
                    String answerText = "Hello, dear friend.";
                    if (!str.isEmpty()) {
                        if (str.contains("Hello")) {
                            answerText = "Hello!\r\n";
                        } else if (str.contains("What")) {
                            answerText = "What?\r\n";
                        } else if (str.contains("Exit")) {
                            answerText = "Bye!\r\n";
                        }
                        out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                        out.write(answerText.getBytes());
                        System.out.println(answerText);
                        if (str.contains("Exit")) {
                            server.close(); // переделал на выход
                            break;
                        }
                    }
                }
            }
        } catch (Exception e) {
            LOG.error("Exception in log example", e);
        }
    }
}
