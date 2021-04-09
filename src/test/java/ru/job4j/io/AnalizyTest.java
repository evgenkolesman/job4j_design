package ru.job4j.io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AnalizyTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void unavailableTest() throws IOException {
        Analizy un = new Analizy();
        File source1 = folder.newFile("Targetfile1.txt");
        File source2 = folder.newFile ("Targetfile2.txt");
        un.unavailable("Sourcefile.txt", "Targetfile1.txt");
        //un.unavailable("Sourcefile.txt", "Targetfile2.txt");
        source2 = source1;
        List<String> target1 = new ArrayList<>();
        List<String> target2 = new ArrayList<>();
        assertThat(reader(source1, target1),is(reader(source2,target2)));
    }

    public List<String>  reader (File source, List<String> target) {
        try (BufferedReader in1 = new BufferedReader(new FileReader(source))) {
            target.addAll(in1.lines().collect(Collectors.toList()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return target;
    }
}