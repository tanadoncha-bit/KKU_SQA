package test.com.sqa.lab;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import main.com.sqa.lab.ShiftCipher;

class ShiftCipherEncryptionTest {

	ShiftCipher cipher = new ShiftCipher();

    @ParameterizedTest
    @CsvSource({
        "ABC,0,ABC",
        "BOOM,17,SFFD",
        "ABC,-3,XYZ"
    })
    void testEncryptValid(String plainText, int key, String expected) {
        assertEquals(expected, cipher.encrypt(plainText, key));
    }

    @ParameterizedTest
    @CsvSource({
        "ABC123,5",
        "'I WANT A',10",
        "'',5",
        "abc,9",
        "Bad,30",
        "TAN,11!",
        "GOOD, "
    })
    void testEncryptInvalidInput(String plainText, int key) {
        assertThrows(IllegalArgumentException.class,
                () -> cipher.encrypt(plainText, key));
    }

}
