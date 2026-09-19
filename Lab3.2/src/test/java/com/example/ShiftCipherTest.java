package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ShiftCipherTest {

    ShiftCipher cipher = new ShiftCipher();

    @Test
    public void testLowercase() {
        assertEquals("vriwzduh",cipher.shift("software",3));
    }

    @Test
    public void testMixedCase() {
        assertEquals("VriwZduh",cipher.shift("SoftWare",3));
    }

    @Test
    public void testMixedCaseNumber() {
        assertEquals("Vriw123",cipher.shift("Soft123",3));
    }

}