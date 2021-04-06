package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Analizy {
    //private final String path;
    /*public Analizy(String path) {
        this.path = path;
    }*/
    public void unavailable(String source, String target) {
        try (BufferedReader inner = new BufferedReader(new FileReader(source));
             PrintWriter outer = new PrintWriter(new FileOutputStream(target))
        ) {
            List<String> common = new ArrayList<>();
            String lines = inner.readLine();

            // пишем все в общий список

            while (lines.contains("200") || lines.contains("300") ||
                    lines.contains("400")|| lines.contains("500")) {
            //while (!lines.isEmpty()) {
                common.add(lines);
            }

            // делим по спискам downList - когда упал, upplist - когда работал

            for (String line : common) {
                String down = null;
                String up = null;
                if (lines.contains("400") || lines.contains("500")) {
                    List<String> downList = new ArrayList<>();
                    downList.add(line);
                    down = downList.get(downList.indexOf(line));
                } else if (lines.contains("200") || lines.contains("300")) {
                    List<String> upList = new ArrayList<>();
                    upList.add(line);
                    up = upList.get(upList.indexOf(line));
                }

                // пишем в файл интервалы

                outer.write(down + ":" + up);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analizy un = new Analizy();
        un.unavailable("Sourcefile.txt", "Targetfile.txt");
    }
}
