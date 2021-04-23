package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

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
    private String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    public static String target = "targetText.txt";
    public static String source = "sourceText.txt";
    List<String> sourceList = new ArrayList<>();
    List<String> targetList = new ArrayList<>();

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        Scanner console = new Scanner(System.in);
        String data = console.nextLine();
        //try (BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in))) {
        try (BufferedWriter writter = new BufferedWriter(new FileWriter(target))) {
            //String data1 = reader1.readLine();
            try (BufferedReader out = new BufferedReader(new FileReader(source))) {
                String line = out.readLine();
                while (line != null) {
                    sourceList.add(line);
                }
            }
            String botAnswer = null;
            boolean botActive = true;
            //вариант цикла, который позволяет избежать зацикливания
            do {
                if (!(data.equals(OUT) && botActive)) {
                    if (data.equals(STOP)) {
                        botActive = false;
                    }
                    if (data.equals(CONTINUE)) {
                        botActive = true;
                    } else if (botActive) {
                        int i = new Random().nextInt(sourceList.size());
                        botAnswer = sourceList.get(i);
                        System.out.println(botAnswer);
                    }
                }


            } while (data != OUT);
            writter.write(data);
            writter.write(System.lineSeparator());
            writter.write(botAnswer);
            // ответ пока циклит
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat(target, source);
        cc.run();
    }
}