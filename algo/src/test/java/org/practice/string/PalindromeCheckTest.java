package org.practice.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeCheckTest {

    @Test
    void isPalindrome_true() {
        boolean actual = PalindromeCheck.isPalindrome("abcdcba");
        boolean expected = true;
        assertEquals(actual, expected);
    }

    @Test
    void isPalindrome_false() {
        boolean actual = PalindromeCheck.isPalindrome("abcdefg");
        boolean expected = false;
        assertEquals(actual, expected);
    }
}