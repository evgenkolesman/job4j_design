package ru.job4j.analize;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class AnalizeTest {

    @Test
    public void allIsOk() {
        List<Analize.User> first = new ArrayList<>();
        Analize.User ann = new Analize.User(1, "Ann");
        Analize.User joe = new Analize.User(2, "Joe");
        Analize.User vick = new Analize.User(3, "Vick");
        first.add(ann);
        first.add(joe);
        first.add(vick);
        List<Analize.User> second = new ArrayList<>(first);
        Analize stat = new Analize();
        stat.diff(first, second);
        assertion(first, second, stat, 0, 0, 0);
    }

    private void assertion(List<Analize.User> first, List<Analize.User> second, Analize stat, int i, int i2, int i3) {
        assertThat(stat.diff(first, second).deleted, is(i));
        assertThat(stat.diff(first, second).added, is(i2));
        assertThat(stat.diff(first, second).changed, is(i3));
    }

    @Test
    public void oneDel() {
        List<Analize.User> first = new ArrayList<>();
        Analize.User ann = new Analize.User(1, "Ann");
        Analize.User joe = new Analize.User(2, "Joe");
        Analize.User vick = new Analize.User(3, "Vick");
        first.add(ann);
        first.add(joe);
        first.add(vick);
        List<Analize.User> second = new ArrayList<>(first);
        second.remove(vick);
        Analize stat = new Analize();
        assertion(first, second, stat, 1, 0, 0);
    }

    @Test
    public void oneChangeLongSize() {
        List<Analize.User> first = new ArrayList<>();
        Analize.User ann = new Analize.User(1, "Ann");
        Analize.User joe = new Analize.User(2, "Joe");
        Analize.User vick = new Analize.User(3, "Vick");
        first.add(ann);
        first.add(joe);
        first.add(vick);
        List<Analize.User> second = new ArrayList<>(first);
        Analize.User vicktor = new Analize.User(2, "Vicktor");
        Analize.User alex = new Analize.User(4, "Alex");
        second.set(1, vicktor);
        second.add(alex);
        Analize stat = new Analize();
        assertion(first, second, stat, 0, 1, 1);
    }

    @Test
    public void oneAdd() {
        List<Analize.User> first = new ArrayList<>();
        Analize.User ann = new Analize.User(1, "Ann");
        Analize.User joe = new Analize.User(2, "Joe");
        Analize.User vick = new Analize.User(3, "Vick");
        first.add(ann);
        first.add(joe);
        first.add(vick);
        List<Analize.User> second = new ArrayList<>(first);
        Analize.User vicktor = new Analize.User(4, "Vicktor");
        second.removeAll(first);
        second.add(vicktor);
        Analize stat = new Analize();
        assertion(first, second, stat, 3, 1, 0);
    }
}