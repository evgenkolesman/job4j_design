package ru.job4j.io;

import java.io.*;
import java.util.*;

public class Analizy {

    public void unavailable(String source, String target) {
        try (BufferedReader inner = new BufferedReader(new FileReader(source));
             PrintWriter outer = new PrintWriter(new FileOutputStream(target))) {
            // списки интервалов
            List<String> downServ = new ArrayList<>();

            for (String lines = inner.readLine(); lines != null; lines = inner.readLine()) {
                if (!isActive(lines)) {
                    downServ.add(lines);

                } else if ((!downServ.isEmpty())
                        && (isDown(downServ.get((downServ.size()) - 1)))) {
                    downServ.add(lines);

                }
            }
            outer.println(String.format("%s ", "Начало сбоя:"));
            for (String line : downServ) {
                outer.printf("%s%n", line.substring(4));
                if (isActive(line)) {
                    outer.printf(String.format("%s%n", "Начало следующего сбоя: "));
                }
                if (downServ.indexOf(line) == downServ.size() - 1) {
                    outer.printf(String.format("%s%n", "Работа окончена"));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analizy un = new Analizy();
        un.unavailable("Sourcefile.txt", "Targetfile.txt");
    }

    private boolean isDown(String arr) {
        return arr.contains("400") || arr.contains("500");
    }

    private boolean isActive(String arr) {
        return (arr.contains("200") || "300".contains(arr));
    }
}

