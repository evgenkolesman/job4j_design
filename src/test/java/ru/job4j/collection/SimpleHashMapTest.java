package ru.job4j.collection;

import org.junit.Assert;
import org.junit.Test;


import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleHashMapTest {

    @Test
    public void testInsert() {
        SimpleHashMap<Integer, Integer> a = new SimpleHashMap<>();
        a.insert(1, 1);
        a.insert(2, 2);
        a.insert(3, 3);
        assertThat(a.get(1), is(1));
        assertThat(a.get(2), is(2));
        assertThat(a.insert(2, 2), is(false));
    }

    @Test
    public void testDelete() {
        SimpleHashMap<Integer, String> a = new SimpleHashMap<>();
        a.insert(1, "A");
        a.insert(2, "B");
        assertThat(a.delete(2), is(true));
        assertThat(a.delete(1), is(true));
        //assertThat(a.insert(2,1),is(true));
    }

    @Test(expected = NoSuchElementException.class)
    public void testIterNull() {
        SimpleHashMap<Integer, Integer> a = new SimpleHashMap<>();
        a.iterator().next();
    }

    @Test
    public void testIterInsert() {
        SimpleHashMap<Integer, Integer> a = new SimpleHashMap<>();
        a.insert(1, 1);
        a.insert(2, 2);
        a.insert(3, 3);
        Set<Integer> keys = Set.of(1, 2, 3);
        Set<Integer> values = Set.of(1, 2, 3);
        Iterator<Integer> iterator = a.iterator();
        for (int i = 0; i < 3; i++){
            Integer key = iterator.next();
            Assert.assertTrue(keys.contains(key));
            Assert.assertTrue(values.contains(a.get(key)));
        }
        Assert.assertFalse(iterator.hasNext());
    }
}