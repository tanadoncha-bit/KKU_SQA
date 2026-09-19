package test.com.sqa.lab;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import main.com.sqa.lab.ShiftCipher;

class ShiftCipherDecryptionTest {
	
	ShiftCipher cipher = new ShiftCipher();

	@ParameterizedTest
	@CsvSource({
	    "ABC,0,ABC",
	    "SFFD,17,BOOM",
	    "XYZ,-3,ABC"
	})
	void testDecryptValid(String cipherText, int key, String expected) {
	    assertEquals(expected, cipher.decrypt(cipherText, key));
	}

	@ParameterizedTest
	@CsvSource({
	    "ABC123,5",
	    "'I WANT A',10",
	    "'',5",
	    "abc,9",
	    "FEH,30",
        "TAN,11!",
        "GOOD, "
	})
	void testDecryptInvalid(String cipherText, int key) {
	    assertThrows(IllegalArgumentException.class,
	            () -> cipher.decrypt(cipherText, key));
	}

}
