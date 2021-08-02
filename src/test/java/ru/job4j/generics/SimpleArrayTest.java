/*package ru.job4j.generics;

import junit.framework.TestCase;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleArrayTest extends TestCase {
    @Test
    public void Test1() {
        SimpleArray[] array = new SimpleArray(new SimpleArray[]{"а1", "а2", "а3"});
        //array.add(1,2);
        SimpleArray[] array1 = new int[]{"a1", "a1", "a2", "a3"};
        assertThat(((SimpleArray) array).add("a1"), is(array1));
    }

    public void Testremove () {
        int [] array = new int [] {1,2,3,4,5};
        int [] array1 = new int[]{1,2, 4, 5};
        assertThat(array.remove(3), is (array1));
    }
}*/