package ru.job4j.collection;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleSetTest {

    @Test
    public void testAddRightOrder() {
        SimpleSet<Integer> con = new SimpleSet<>();
        //con = new String[]{"a", "b", "c"};
        con.add(1);
        con.add(2);
        con.add(3);
        con.add(4);
        Iterator<Integer> rsl = con.iterator();
        //assertThat(rsl, is("first"));
        assertThat(rsl.next(), is(1));
        assertThat(rsl.next(), is(2));
        assertThat(rsl.next(), is(3));
        assertThat(rsl.next(), is(4));
    }

    @Test
    public void testAddWrongOrder() {
        SimpleSet<Integer> con = new SimpleSet<>();
        //con = new String[]{"a", "b", "c"};
        con.add(1);
        con.add(4);
        con.add(3);
        con.add(2);
        con.add(4);
        Iterator<Integer> rsl = con.iterator();
        //assertThat(rsl, is("a"));
        assertThat(rsl.next(), is(1));
        assertThat(rsl.next(), is(2));
        assertThat(rsl.next(), is(3));
        assertThat(rsl.next(), is(4));
    }

    @Test(expected = NoSuchElementException.class)
    public void testAddNextNull() {
        SimpleSet<Integer> con = new SimpleSet<>();
        Iterator<Integer> rsl = con.iterator();
        rsl.next();
    }
}