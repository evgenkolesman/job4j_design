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
                    String str = in.readLine();
                    while (!str.isEmpty()) {
                        System.out.println(str);
                        if (str.contains("Hello")) {
                            out.write("Hello".getBytes());
                        }
                        if (str.contains("Exit")) {
                            System.exit(0);
                        }
                        if (str.contains("What")) {
                            out.write("What".getBytes());
                        }
                        str = in.readLine();
                    }
                    out.write("HTTP/1.1 200 OK\r\n".getBytes());
                    out.write("Hello, dear friend.".getBytes());
                }
            }
        }
    }
}
