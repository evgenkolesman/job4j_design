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
        Analize.User Ann = new Analize.User(1, "Ann");
        Analize.User Joe = new Analize.User(2, "Joe");
        Analize.User Vick = new Analize.User(3, "Vick");
        first.add(Ann);
        first.add(Joe);
        first.add(Vick);
        List<Analize.User> second;
        second = first;
        Analize stat = new Analize();
        stat.diff(first, second);
        assertThat(stat.diff(first, second).deleted, is(0));
        assertThat(stat.diff(first, second).added, is(0));
        assertThat(stat.diff(first, second).changed, is(0));
    }

    @Test
    public void oneDel() {
        List<Analize.User> first = new ArrayList<>();
        Analize.User Ann = new Analize.User(1, "Ann");
        Analize.User Joe = new Analize.User(2, "Joe");
        Analize.User Vick = new Analize.User(3, "Vick");
        first.add(Ann);
        first.add(Joe);
        first.add(Vick);
        List<Analize.User> second = new ArrayList<>();
        second.add(Ann);
        second.add(Joe);
        Analize.User Vicktor = new Analize.User(3, "Vicktor");
        Analize stat = new Analize();
        //stat.diff(first,second);
        assertThat(stat.diff(first, second).deleted, is(1));
        assertThat(stat.diff(first, second).added, is(0));
        assertThat(stat.diff(first, second).changed, is(0));
    }

    @Test
    public void oneChangeLongSize() {
        List<Analize.User> first = new ArrayList<>();
        Analize.User Ann = new Analize.User(1, "Ann");
        Analize.User Joe = new Analize.User(2, "Joe");
        Analize.User Vick = new Analize.User(3, "Vick");
        first.add(Ann);
        first.add(Joe);
        first.add(Vick);
        List<Analize.User> second = new ArrayList<>();
        //second = first;
        Analize.User Vicktor = new Analize.User(2, "Vicktor");
        Analize.User Alex = new Analize.User(4, "Alex");
        second.add(Ann);
        second.add(Vicktor);
        second.add(Vick);
        second.add(Alex);
        Analize stat = new Analize();
        assertThat(stat.diff(first, second).deleted, is(0));
        assertThat(stat.diff(first, second).added, is(1));
        assertThat(stat.diff(first, second).changed, is(1));
    }

    @Test
    public void oneAdd() {
        List<Analize.User> first = new ArrayList<>();
        Analize.User Ann = new Analize.User(1, "Ann");
        Analize.User Joe = new Analize.User(2, "Joe");
        Analize.User Vick = new Analize.User(3, "Vick");
        first.add(Ann);
        first.add(Joe);
        first.add(Vick);
        List<Analize.User> second = new ArrayList<>();
        Analize.User Vicktor = new Analize.User(4, "Vicktor");
        second.add(Vicktor);
        Analize stat = new Analize();
        assertThat(stat.diff(first, second).deleted, is(3));
        assertThat(stat.diff(first, second).added, is(1));
        assertThat(stat.diff(first, second).changed, is(0));
    }


}