package ru.job4j.iterator;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;

public class ListUtilsTest {

    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertThat(Arrays.asList(1, 2, 3), Is.is(input));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfter() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3, 4));
        ListUtils.addAfter(input, 1, 2);
        assertThat(Arrays.asList(1, 3, 2, 4), Is.is(input));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddAfterWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addAfter(input, 3, 2);
    }

    @Test
    public void whenRemoveIf() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3));
        int a = input.get(1);
        ListUtils.removeIf(input, x -> x.equals(a));
        assertThat(Arrays.asList(1, 3), Is.is(input));
    }

    @Test
    public void whenReplaceIf() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        int a = 1;
        Integer b = 4;
        ListUtils.replaceIf(input, x-> x.equals(a), b);
        assertThat(Arrays.asList(1, 4, 3, 4), Is.is(input));
    }

    @Test
    public void whenRemoveAll() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> input1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        ListUtils.removeAll(input, input1);
        assertThat(Arrays.asList(4), Is.is(input));
    }

    /*@Test
    public void whenRemoveAllDifferent() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> input1 = new ArrayList<>(Arrays.asList(2, 1, 4));
        ListUtils.removeAll(input, input1);
        assertThat(Arrays.asList(3), Is.is(input));
    }*/
}