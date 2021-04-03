package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LogFilter {
    public static List<String> filter(String file) {
        List<Stream<String>> file1 = new ArrayList<>();
        List<String> file2 = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            String line = in.readLine();// до сюда процесс чтения
            String a = "404";
            //file1.add(in.lines().filter(s -> s.contains(a)));
            file2.add(String.valueOf(in.lines().filter(s -> s.contains(a))));
            /*if (line != null && line.contains(a)) {
                // цикл который должен фильтровать
                //file1.stream().filter().add(in.lines());// для стрима, но пока упростил ибо сбился в понимании
                line = in.readLine();
                file2.add(line);
            }*/
            //for(int index =0; index < file1.size(); index++) { System.out.println(file1.get(index).toString()); }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file2;
    }

    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        System.out.println(log);
    }
}




            /*file1.stream().filter(x -> {
                return x != null && x.contains("404");
            }).add(line);*/

            /*while (line != null) {
                // цикл который должен фильтровать
                file1.add(in.lines());// для стрима, но пока упростил ибо сбился в понимании
                line = in.readLine();
                file2.add(line);
            }*/
//System.out.println(file1.toString()); // для промежуточного котроля ,но



/*public class LogFilter {
    public static List<String> filter(String file) {
        List<Stream<String>> file1 = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {

            file1.add(in.lines());
            //in.lines().forEach(System.out::println);
            //Stream stream = file1.stream();
            //int a = file1.size() - 1;
            file1.stream().filter(stringStream -> file1.equals(" 404")).forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace(); }
        return null;
    }

    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        System.out.println(log);
    }
}*/
