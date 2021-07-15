package ru.job4j.testexersize;

import java.math.BigDecimal;
import java.util.Collection;

public class TestExersize {
    public static void filter(Collection<BigDecimal> numbers) throws MyException {
        BigDecimal [] arr = numbers.toArray(new BigDecimal[numbers.size()]);
        for(BigDecimal n : numbers) {
            if(n.compareTo(arr[arr.length-1].divide(arr[0])) >= 0) {
                numbers.remove(n);
            }
        }
    }

}
