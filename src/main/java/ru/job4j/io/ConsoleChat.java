package ru.job4j.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/* Создание консольного чата
 * Утилита для создания консольного чата, который
 * останавливается при команде стоп,  продолжает при продолжить,заканчивает при команде Закончить.
 *@author Kolesnikov Evgeniy (evgeniysanich@mail.ru)
 * @version 1.0
 */
public class ConsoleChat {
    private final String path;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    public String target = "targetText.txt";
    public String source = "sourceText.txt";

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        Scanner console = new Scanner(System.in);
        String data = console.nextLine();
        while (!data.isEmpty()) {
            try(BufferedWriter wr = new BufferedWriter(new FileWriter(target))) {
                wr.append(data);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (data.equals(OUT)) {
                break;
            }

            if (data.equals(STOP)) {
            }

            if (data.equals(CONTINUE)) {
            }

        }
    }

    public void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("","");
        cc.run();
    }
}
