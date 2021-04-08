package ru.job4j.io;

import java.io.*;
import java.util.*;

public class Analizy {

    public void unavailable(String source, String target) {
        try (BufferedReader inner = new BufferedReader(new FileReader(source));
             PrintWriter outer = new PrintWriter(new FileOutputStream(target))
        ) {
            // список всех данных чтения
            List<String> common = new ArrayList<>();
            // списки совпадений интервалов
            List<String> downServ = new ArrayList<>();

            for (String lines = inner.readLine(); lines != null; lines = inner.readLine()) {
                if (lines.contains("200") || lines.contains("300") ||
                        isDown(lines)) {
                    common.add(lines);
                }

                for (int i = 0; i < common.size(); i++) {

                    if (!isActive(common.get(i))) {
                        downServ.add(common.get(i));
                        if ((i + 1) < common.size()) {
                            if ((isActive(common.get(i + 1)))) {
                                downServ.add(common.get(i + 1));
                            }
                        }
                    }
                }
            }

            //избавимся от дублей
            LinkedHashSet down = new LinkedHashSet(downServ);
            for (Object line : down) {
                outer.println(line);
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
        return !arr.contains("400") && !arr.contains("500");
    }
}

