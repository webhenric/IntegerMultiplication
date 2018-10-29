package com.webhenric;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StandardAlgorithmTest {

    private StandardAlgorithm standardAlgorithm;

    @BeforeEach
    void setUp() {
        standardAlgorithm = new StandardAlgorithm();
    }

    @Test
    void multiplySmallNumber() {
        final int multiplicand = 2018;
        final int multiplier = 4;
        final int expectedProduct = multiplicand * multiplier;
        final char[] multiplicandArray = Integer.toString(multiplicand).toCharArray();
        final String expectedString = Integer.toString(expectedProduct);

        assertEquals(expectedString, standardAlgorithm.multiply(Character.forDigit(multiplier, Character.MAX_RADIX), multiplicandArray));
    }

    @Test
    void multiplyBigNumber() {
        final int multiplicand = 987464;
        final int multiplier = 8;
        final int expectedProduct = multiplicand * multiplier;
        final char[] multiplicandArray = Integer.toString(multiplicand).toCharArray();
        final String expectedString = Integer.toString(expectedProduct);

        assertEquals(expectedString, standardAlgorithm.multiply(Character.forDigit(multiplier, Character.MAX_RADIX), multiplicandArray));
    }

    @Test
    void addWhenOnlyOneNumber() {
        final String number = "8072";
        List<String> results = Collections.singletonList(number);
        assertEquals(number, standardAlgorithm.add(results));
    }

    @Test
    void addWhenManyNumbers() {
        final String number1 = "8072";
        final String number2 = "17295";
        final String number3 = "53840";
        final String expectedSum =
                Integer.toString(Integer.valueOf(number1) +
                        (Integer.valueOf(number2) * 10) +
                        (Integer.valueOf(number3) * 100));

        List<String> results = new ArrayList<>();
        results.add(number1);
        results.add(number2);
        results.add(number3);

        assertEquals(expectedSum, standardAlgorithm.add(results));
    }

    @Test
    void compute() {
        final int multiplicand = 1234;
        final int multiplier = 5678;
        final String expectedResult = Integer.toString(multiplicand * multiplier);

        assertEquals(
                expectedResult,
                standardAlgorithm.compute(
                        Integer.toString(multiplicand).toCharArray(), Integer.toString(multiplier).toCharArray()));
    }
}