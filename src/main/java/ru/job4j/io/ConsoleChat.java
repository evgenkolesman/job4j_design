package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
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

    public void run() throws IOException {
        //Scanner console = new Scanner(System.in);
        //String data = console.nextLine();
        try (BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in))) {
            try (BufferedWriter writter = new BufferedWriter(new FileWriter(target))) {
                String data = reader1.readLine();
                try (BufferedReader out = new BufferedReader(new FileReader(source))) {
                    while (out.readLine() != null) {
                        sourceList.add(out.readLine());
                    }
                }
                boolean botActive = true;
                while (reader1.readLine() != null) {
                    if (!(reader1.readLine().equals(OUT) && botActive == true)) {
                        if (reader1.readLine().equals(STOP)) {
                            botActive = false;// остановка, пока не работает
                        }
                        if (reader1.readLine().equals(CONTINUE)) {
                            botActive = true;
                        }
                    /*int i =0;
                    if (i < sourceList.size()) {
                        botAnswers = sourceList.get(i);
                        System.out.println(botAnswers);
                        i++;
                    }
                    if (i == sourceList.size() - 1) {
                        i = 0;
                    }*/

                    }
                    botAnswers = sourceList.get(1);
                    if (!reader1.readLine().equals(OUT) || !reader1.readLine().equals(CONTINUE)) {
                        System.out.println(botAnswers);
                    } else if(reader1.readLine().equals(OUT)) {
                        break;
                    }
                }
                // ответ пока циклит}
                writter.write(data);
                writter.write(System.lineSeparator());
                writter.write(botAnswers);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ConsoleChat cc = new ConsoleChat(target, source);
        cc.run();
    }
}
