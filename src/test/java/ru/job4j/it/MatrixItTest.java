package ru.job4j.it;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import java.util.NoSuchElementException;

public class MatrixItTest {
    @Test
    public void when4El() {
        MatrixIt it = new MatrixIt(new int[][] {{1}});
        it.next();
        it.next();
        assertFalse(it.hasNext());
        //assertThat(it.next(), is(1));
    }

    @Test
    public void whenFirstEmptyThenNext() {
        MatrixIt it = new MatrixIt(new int[][] {{}, {1}});
        it.next();
        it.next();
        assertFalse(it.hasNext());
        /*int[][] in = {
                {}, {1}
        };
        MatrixIt it = new MatrixIt(in);
        //assertThat(it.next(), is(1));*/
    }

    @Test
    public void whenRowHasDiffSize() {
        MatrixIt it = new MatrixIt(new int[][] {
                {1}, {2, 3}});
        it.next();
        it.next();
        assertFalse(it.hasNext());

        /*int[][] in = {
                {1}, {2, 3}
        };
        MatrixIt it = new MatrixIt(in);
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));*/
    }

    @Test
    public void whenFewEmpty() {
        MatrixIt it = new MatrixIt(new int[][] {
                {1}, {}, {}, {}, {2}});
        it.next();
        it.next();
        assertFalse(it.hasNext());
        /*int[][] in = {
                {1}, {}, {}, {}, {2}
        };
        MatrixIt it = new MatrixIt(in);
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));*/
    }

    @Test
    public void whenEmpty() {
        MatrixIt it = new MatrixIt(new int[][] {{}});
        it.next();
        it.next();
        assertFalse(it.hasNext());

        /*int[][] in = {
                {}
        };
        MatrixIt it = new MatrixIt(in);
        assertThat(it.hasNext(), is(false));*/
    }

    @Test(expected = NoSuchElementException.class)
    public void whenEmptyThenNext() {
        MatrixIt it = new MatrixIt(new int[][]{ {} });
        it.next();
        it.next();
        assertFalse(it.hasNext());
    }
    /*public void whenEmptyThenNext() {
        int[][] in = {
                {}
        };
        MatrixIt it = new MatrixIt(in);
        it.next();*/

    @Test
    public void whenMultiHashNext() {
        MatrixIt it = new MatrixIt(new int[][]{{}, {1}});
        it.next();
        it.next();
        assertFalse(it.hasNext());

        /*int[][] in = {
                {}, {1}
        };
        MatrixIt it = new MatrixIt(in);
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));*/
    }

    @Test
    public void whenNoElements() {
        MatrixIt it = new MatrixIt(new int[][] {{}, {}, {}});
        it.next();
        it.next();
        assertFalse(it.hasNext());
        /*int[][] in = {{}, {}, {}};
        MatrixIt it = new MatrixIt(in);
        assertThat(it.hasNext(), is(false));*/
    }
}