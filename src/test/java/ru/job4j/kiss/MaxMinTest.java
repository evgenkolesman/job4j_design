package ru.job4j.kiss;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class MaxMinTest {

    @Test
    public void maxTest() {
        MaxMin max = new MaxMin();
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(-1);
        list.add(0);
        list.add(-2);
        list.add(1);

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        assertThat(max.max(list, comparator), is(2));
    }

    @Test
    public void min() {
        MaxMin max = new MaxMin();
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(-2);
        list.add(0);
        list.add(-1);
        list.add(1);

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        assertThat(max.min(list, comparator), is(-2));
    }
}