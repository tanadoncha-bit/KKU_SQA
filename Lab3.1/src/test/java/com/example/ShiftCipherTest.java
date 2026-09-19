package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ShiftCipherTest {

    ShiftCipher cipher = new ShiftCipher();

    @Test
    public void testTC01() {
        assertEquals("ZVMADHYL", cipher.shift("SOFTWARE", 3));
    }

    @Test
    public void testTC02() {
        assertEquals("zvmadhyl", cipher.shift("software", 3));
    }

    @Test
    public void testTC03() {
        assertEquals("ABC", cipher.shift("XYZ", 3));
    }

    @Test
    public void testTC04() {
        assertEquals("invalid", cipher.shift("ABC1", 3));
    }
}