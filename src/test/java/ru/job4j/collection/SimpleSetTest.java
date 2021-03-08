package ru.job4j.collection;


import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertThat;

public class SimpleSetTest {

    @Test
    public void testAdd() {
        SimpleSet<Integer> con = new SimpleSet<>();
        //con = new String[]{"a", "b", "c"};
        con.add(1);
        con.add(4);
        assertThat(Arrays.asList(1, 2, 3, 4), Is.is(con));
    }
}