package ru.job4j.io;

import java.io.FileOutputStream;

public class tableMathFile {

        public static void main(String []args) {
            String tableMath =
                    "1*2 =2 " + "2*2=4 " +"2*3=6 " + "2*4=8 " + "2*5=10 "+ "2*6=12 " + "2*7=14 "+ "2*8=16 " + "2*9 =18";
            try(FileOutputStream out = new FileOutputStream("tableMath.txt")) {
                out.write(tableMath.getBytes());
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
}
