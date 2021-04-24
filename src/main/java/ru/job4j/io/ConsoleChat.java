package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* Создание консольного чата
 * Утилита для создания консольного чата, который
 * останавливается при команде стоп,
 * продолжает при продолжить,
 * заканчивает при команде закончить.
 *@author Kolesnikov Evgeniy (evgeniysanich@mail.ru)
 * @version 1.0
 */
public class ConsoleChat {
    private static String path;
    private static String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    public static String target = "targetText.txt";
    public static String source = "sourceText.txt";
    List<String> sourceList = new ArrayList<>();
    List<String> targetList = new ArrayList<>();

    //конструктор
    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    //основная логика считываем с консоля данные(с помощью стримов, сканнер не зашел), производим считывание ответ
    // распознаем ответ, приминяем логику, все записываем.
    public void run() {
        try (BufferedReader dialogReader = new BufferedReader(new InputStreamReader(System.in))) {
            String botAnswer = null;
            readerData();
            boolean botActive = true;
            //вариант цикла, который позволяет избежать зацикливания
            do {
                botAnswer = dialogReader.readLine();
                targetList.add(botAnswer);
                    if (botAnswer.equals(STOP)) {
                        botActive = false;
                    }
                    if (botAnswer.equals(CONTINUE) || botAnswer.equals(OUT)) {
                        botActive = true;
                    } else if (botActive) {
                        int i = new Random().nextInt(sourceList.size());
                        botAnswer = sourceList.get(i);
                        targetList.add(botAnswer);
                        System.out.println(botAnswer);
                    }
            } while (botAnswer != OUT);
            writeData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // читаем все фразы из файла
    public void readerData() {
        try (BufferedReader out = new BufferedReader(new FileReader(path))) {
            String line = out.readLine();
            while (line != null) {
                sourceList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // пишем все данные в файл из списка
    public void writeData() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(botAnswers))) {
            for (String string : targetList) {
                writer.write(string);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // запускаем наш чат
    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat(target, source);
        cc.run();
    }
}