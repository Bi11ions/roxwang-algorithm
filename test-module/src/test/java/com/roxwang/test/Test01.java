package com.roxwang.test;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

/**
 * @author wangsen@qgutech.com
 * @since 2019/7/10 17:38
 */
public class Test01 {

    @Test
    public void whenFlatMapEmployeeNames_thenGetNameStream() {
        List<List<String>> namesNested = Arrays.asList(
                Arrays.asList("Jeff", "Bezos"),
                Arrays.asList("Bill", "Gates"),
                Arrays.asList("Mark", "Zuckerberg"));

        List<String> namesFlatStream = namesNested.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        assertEquals(namesFlatStream.size(), namesNested.size() * 2);
    }

    @Test
    public void testAnd() {
        int capacity = 29;
        int num = 53687000;
        int result = num & capacity;
        System.out.println(result);
    }

    @Test
    public void testDateFormatter() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime dateTime = LocalDateTime.parse("0000-00-00", dateTimeFormatter);
        System.out.println(dateTime.toString());
    }

    @Test
    public void test() {
        System.out.println(Integer.toBinaryString(32 >>> 16));
    }

    @Test
    public void testStreamMap() {
    }
}
