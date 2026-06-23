package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

class EvenCheckerTest {

    private final EvenChecker checker = new EvenChecker();

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 0, 100, -8})
    void evenNumbersReturnTrue(int number) {
        assertTrue(checker.isEven(number));
    }

    @ParameterizedTest
    @CsvSource({"3, false", "6, true", "7, false", "10, true"})
    void checksAgainstExpected(int number, boolean expected) {
        assertEquals(expected, checker.isEven(number));
    }
}
