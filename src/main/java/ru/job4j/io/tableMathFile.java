package ru.job4j.io;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class tableMathFile {

    public static void main(String[] args) {
        int i = 9;
        int z = 9;
        StringBuilder tableMath = new StringBuilder();
        StringBuilder a1 =new StringBuilder(System.lineSeparator());
        String[][] arr = new String[i][z];

        for (int a = 0; a < arr.length; a++) {
            List<String> line = new ArrayList<>();
            for (int b = 0; b < arr[a].length; b++) {
                arr[a][b] = String.format("%d * %d = %d ", a + 1, b + 1, (a + 1) * (b + 1));
                line.add(arr[a][b]);

            }
            tableMath.append(line);
            tableMath.append(a1);

        }
        try (FileOutputStream out = new FileOutputStream("tableMath.txt")) {
            out.write(tableMath.toString().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
