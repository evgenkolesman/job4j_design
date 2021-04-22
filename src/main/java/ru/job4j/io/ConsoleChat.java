package ru.job4j.io;

import java.io.*;
import java.nio.CharBuffer;
import java.util.Scanner;

/* Создание консольного чата
 * Утилита для создания консольного чата, который
 * останавливается при команде стоп,
 * продолжает при продолжить,
 * заканчивает при команде закончить.
 *@author Kolesnikov Evgeniy (evgeniysanich@mail.ru)
 * @version 1.0
 */
public class ConsoleChat {
    private final String path;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    public static String target = "targetText.txt";
    public static String source = "sourceText.txt";

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        Scanner console = new Scanner(System.in);
        String data = console.nextLine();
        while (!data.isEmpty()) {
            try (BufferedWriter wr = new BufferedWriter(new FileWriter(target))) {
                wr.append(data);
                if (data.equals(OUT)) {
                    System.exit(0);
                }

                if (data.equals(STOP)) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                    }// не правильно надо придумать стоп
                }
                if (data.equals(CONTINUE)) {
                    notify();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try (BufferedReader out = new BufferedReader(new FileReader(source))) {
                System.out.println(out.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat(target, source);
        cc.run();
    }
}
