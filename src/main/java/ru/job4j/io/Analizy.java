package ru.job4j.io;

import java.io.*;
import java.util.*;

public class Analizy {

    public void unavailable(String source, String target) {
        try (BufferedReader inner = new BufferedReader(new FileReader(source));
             PrintWriter outer = new PrintWriter(new FileOutputStream(target))) {
            // список всех данных чтения
            List<String> common = new ArrayList<>();
            // списки совпадений интервалов
            List<String> downServ = new ArrayList<>();

            for (String lines = inner.readLine(); lines != null; lines = inner.readLine()) {
                /*if (lines.contains("200") || lines.contains("300") ||
                        isDown(lines)) {
                    common.add(lines);
                }*/

                //for (int i = 0; i < common.size(); i++) {


                if (!isActive(lines)) {
                    downServ.add(lines);

                } else if ((!downServ.isEmpty()) && (isDown(downServ.get((downServ.size()) - 1)))) {
                    downServ.add(lines);

                }
            }


            //избавимся от дублей
            //Set<String> down = new LinkedHashSet(downServ);
            outer.println(String.format("%s ", "Начало сбоя:" ));
            for (String line : downServ) {

                outer.printf("%s%n", line.substring(4));
                if (isActive(line)) {
                    outer.printf(String.format("%s%n", "Начало следующего сбоя: "));
                }
                if (downServ.indexOf(line) == downServ.size()-1) {
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

    private boolean isDown(String lines) {
        return lines.contains("400") || lines.contains("500");
    }

    private boolean isActive(String arr) {
        if (arr.contains("400") || arr.contains("500")) {
            return false;
        }
        return true;
    }
}

