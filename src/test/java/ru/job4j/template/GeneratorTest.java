package ru.job4j.template;

import org.junit.Ignore;
import org.junit.Test;
import template.Generator;
import template.GeneratorV;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;

public class GeneratorTest {

    @Test
    @Ignore
    public void produce() {
        Generator gen = new GeneratorV();
        gen.produce(new String(), Map.of(new String(), new String()));
        assertEquals(GeneratorV.class, gen.getClass());
    }

    @Test(expected = NullPointerException.class)
    @Ignore
    public void whenNulls() {
        Generator gen = new GeneratorV();
        gen.produce(null, Map.of(null, null));
    }

    @Test//(expected = Exception.class)
    @Ignore
    public void whenNullTemplate() {
        Generator gen = new GeneratorV();
        gen.produce(null, Map.of(new String(), new String()));
        assertEquals(GeneratorV.class, gen.getClass());
    }

    @Test(expected = NullPointerException.class)
    @Ignore
    public void whenWrongMap() {
        Generator gen = new GeneratorV();
        gen.produce(new String(), Map.of(null, new String()));
        assertThat(gen, is(new GeneratorV()));
    }
}