package ru.job4j.collection;


import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertThat;

public class SimpleSetTest {

    @Test
    public void testAdd() {
        String [] con = {"a", "b", "c"};
        con.add("a");
        con.add("z");
        assertThat(Arrays.asList("a", "b", "c", "z"), Is.is(con));
    }
}