package ru.job4j.srp;

import java.io.*;

/* Принципы SOLID
 * Пример ошибка SRP
 *@author Kolesnikov Evgeniy (evgeniysanich@mail.ru)
 * @version 1.0
 */

public class SrpMistake {

    private static File fileInPut;
    private static File fileOutPut;

    public static void main(String[] args) {
        reader();
        writer(); //
        int z = multiply(2, 4); // этот метод должен юыть в другом классе,
        // так как здесь есть 2 логически связных метода,
        // которые по идее то же можно развести по разным классам
        System.out.println(z);


    }

    public static void reader() {
        try (BufferedReader in = new BufferedReader(new FileReader(fileInPut))) {
            in.lines().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writer() {
        String data = "";
        try (BufferedWriter br = new BufferedWriter(new FileWriter(fileOutPut))) {
            br.write(data + System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int multiply(int a, int b) {
        a = a * b;
        return a;
    }

}
