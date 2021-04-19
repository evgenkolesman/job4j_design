package ru.job4j.io;

import java.io.File;
import java.util.Objects;

public class Dir {
    public static void main(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Root folder is null. Usage java -jar dir.jar ROOT_FOLDER.");
        }
        File file = new File(args[0]);
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", file.getAbsoluteFile()));
        }
        //System.out.printf("size : %s%n", file.getTotalSpace());
        for (File subfile : Objects.requireNonNull(file.listFiles())) {
            String a = String.valueOf(subfile.length());
            String b = subfile.getAbsoluteFile().toString();
            System.out.printf("название : %s  -----  размер : %s%n", b, a);
        }
    }
}
