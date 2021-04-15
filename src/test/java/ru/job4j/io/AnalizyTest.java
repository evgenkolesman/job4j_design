package ru.job4j.io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import java.io.*;
import java.nio.file.Files;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AnalizyTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void unavailableTest() throws IOException {
        Analizy un = new Analizy();
        File source = folder.newFile("Sourcefile1.txt");
        File target = folder.newFile("Targetfile1.txt");

        //записываем во временный файл данные для проверки
        Files.write(source.toPath(), List.of(
                "200 10:56:01",
                "500 10:57:01",
                "400 10:58:01",
                "500 10:59:01",
                "200 11:01:02",
                "400 11:02:02",
                "200 11:03:01"
        ));
        un.unavailable(source.getAbsolutePath(), target.getAbsolutePath());

        // переписываем все в листы для сравнения
        List<String> target1 = List.of(
                "Начало сбоя: ",
                "10:57:01",
                "11:01:02",
                "Начало следующего сбоя: ",
                "11:02:02",
                "11:03:01",
                "Начало следующего сбоя: ",
                "Работа окончена"
        );
        List<String> target2 = Files.readAllLines(target.toPath());

        // сравниваем полученные данные, которые должны быть идентичны
        assertThat(target2, is(target1));
    }
}