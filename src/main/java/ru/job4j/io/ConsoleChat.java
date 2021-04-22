package ru.job4j.io;

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

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {}

    public void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("","");
        cc.run();
    }
}
