package ru.job4j.template;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

/* TDD
 * отработка TDD, написание тестов для возможной реализации в классах
 * отработка шаблонирование
 * @template = "I am a ${name}, Who are ${subject}? "
 *@author Kolesnikov Evgeniy (evgeniysanich@mail.ru)
 * @version 1.0
 */
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
    public void whenWrongNullMap() {
        Generator gen = new GeneratorV();
        gen.produce(new String(), Map.of(null, new String()));
        assertThat(gen, is(new GeneratorV()));
    }

    @Test
    @Ignore
    public void whenAllRight() {
        Generator gen = new GeneratorV();
        String t = "I am a ${name}, Who are ${subject}? ";
        Map v = Map.of("name", "Vick", "subject", "you");
        assertThat(gen.produce(t, v), is("I am a Vick, Who are you? "));
    }

    @Test
    @Ignore
    public void whenNotEnoughDataMap() {
        Generator gen = new GeneratorV();
        String t = "I am a ${name}, Who are ${subject}? ";
        Map v = Map.of("name", "Vick");
        assertThat(gen.produce(t, v), is("I am a Vick, Who are you? "));
    }

    @Test
    @Ignore
    public void whenTooManyDataMap() {
        Generator gen = new GeneratorV();
        String t = "I am a ${name}, Who are ${subject}? ";
        Map v = Map.of("name", "Vick", "subject", "you", "subject2.0", "him");
        assertThat(gen.produce(t, v), is("I am a Vick, Who are you? "));
    }
}