package ru.job4j.io.searchfiles;

import java.io.File;

public class Args {

    private String[] args;

    public Args(String[] args) {
        this.args = args;
    }

    public void validateArgs() {
        if (args.length != 8) {
            throw new IllegalArgumentException("Try again, e.g. java -jar find.jar -d c:/ -n *.txt -m -o log.txt");
            //Почему же 7 аргументов, ответ: 1)-d 2) c:/ 3)-n 4)*.txt 5)-t 6)mask 7)-o 8)log.txt
        }
        if (!args[0].equalsIgnoreCase("-d") || !args[2].equalsIgnoreCase("-n")
                || !args[4].equalsIgnoreCase("-t") || !args[6].equalsIgnoreCase("-o")) {
            throw new IllegalArgumentException("Wrong Args name");
        }


        //проверка на присутсвие
        if (!new File(args[1]).exists()) {
            throw new IllegalArgumentException("Wrong directory");
        }
    }

    //пишем геттеры
    public String getDirectory() {
        return args[1];
    }

    public String getTypeSearch() {
        return args[3];
    }

    public String getLogPath() {
        return args[6];
    }
}
