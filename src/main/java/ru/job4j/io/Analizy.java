package ru.job4j.io;

import java.io.*;
import java.util.*;

public class Analizy {

    public void unavailable(String source, String target) {
        try (BufferedReader inner = new BufferedReader(new FileReader(source));
             PrintWriter outer = new PrintWriter(new FileOutputStream(target))) {
            // списки интервалов
            List<String> downServ = new ArrayList<>();
            boolean flag = false;
            for (String lines = inner.readLine(); lines != null; lines = inner.readLine()) {
                boolean active = isActive(lines);
                if (!flag && !active) {
                    downServ.add(lines);
                    flag = true;
                }
                else if (flag && active) {
                downServ.add(lines);
                flag = false;
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

    private boolean isActive(String arr) {
        return (arr.contains("200") || arr.contains("300"));
    }
}


//вариант чтобы записать все ошибки

   /*if (!isActive(lines)) {
                    downServ.add(lines);
                } else if ((!downServ.isEmpty())
                        && (isDown(downServ.get((downServ.size()) - 1)))) {
                    downServ.add(lines);}

      private boolean isDown(String arr) {
        return arr.contains("400") || arr.contains("500");
    } */