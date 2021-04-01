package ru.job4j.io;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class tableMathFile {

    public static void main(String[] args) {
        int i = 9;
        int z = 9;
        StringBuilder tableMath = new StringBuilder();
        String [][] arr = new String[i][z];

        for (int a = 0; a < arr.length; a++) {
            List<String> line =  new ArrayList<>();
            for(int b = 0; b < arr[a].length; b++) {
                arr[a][b] = " " + String.valueOf(a+1) + "*" + String.valueOf(b+1) +
                        "=" + String.valueOf((a+1)*(b+1)) + " ";
                line.add(arr[a][b]);
                }
            tableMath.append(line);
        }

        //tableMath.append(arr.toString());
        try (FileOutputStream out = new FileOutputStream("tableMath.txt")) {
            out.write(tableMath.toString().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

//"1*2=2 " + "2*2=4 " + "2*3=6 " + "2*4=8 " + "2*5=10 " + "2*6=12 " + "2*7=14 " + "2*8=16 " + "2*9=18"