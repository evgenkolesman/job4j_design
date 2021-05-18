package ru.job4j.io.searchfiles;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Find {

    private static String fileWrite = "log.txt";

    public static void main(String[] args) {
        SearchFileVisitor searchFileVisitor = new SearchFileVisitor();
        try {
            Files.walkFileTree(Paths.get("c:\""), searchFileVisitor);
        } catch (IOException e) {
            e.printStackTrace();
        }

        searchFileVisitor.setPartOfName(".txt");

        List<Path> foundfiles = searchFileVisitor.getFoundfiles();
        for(Path a : foundfiles) {
            writeInFile(fileWrite, a);
        }
    }

    private static void writeInFile(String fileWrite, Path a) {
        try(BufferedWriter br = new BufferedWriter(new FileWriter(fileWrite))) {
            br.write(String.valueOf(a));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
