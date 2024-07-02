package org.practice.arrays;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TwoNumberSumTest {

    @Test
    void twoNumberSum_valid() {
        int [] actual = TwoNumberSum.twoNumberSum(new int [] {3, 5, -4, 8, 11, 1, -1, 6}, 10);
        int [] expected = new int [] {-1, 11};
        assertArrayEquals(actual, expected);
    }

    @Test
    void twoNumberSum_invalid() {
        int [] actual = TwoNumberSum.twoNumberSum(new int [] {3, 5, -4, 8, 11, 1, -1, 6}, 100);
        int [] expected = new int[0];
        assertArrayEquals(actual, expected);
    }
}