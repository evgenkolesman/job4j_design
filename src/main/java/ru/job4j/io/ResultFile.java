package ru.job4j.io;

import java.io.FileOutputStream;

public class ResultFile {
    public static void main(String []args){
        try(FileOutputStream out = new FileOutputStream("result.txt")) {
            out.write("Hello, world".getBytes());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        String tableMath = "2*2 =4" +
                "3*3=9" +
                "4*4=16" +
                "5*5=25";
    }
}
