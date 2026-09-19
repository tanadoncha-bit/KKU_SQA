package test.com.sqa.lab;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import main.com.sqa.lab.QuadraticEquation;
import main.com.sqa.lab.RootNature;

/**
 * CP353201 Software Quality Assurance (1/2569)
 * Lab 6.1 - Limited Entry Decision Table (LEDT)
 *
 * ใช้เฉพาะ Rule ที่เป็นไปได้ (ไม่ Impossible):
 * R4, R6, R7  -> NOT_QUADRATIC   (a = 0)
 * R12         -> REAL_ROOTS      (a≠0, D>0)
 * R14         -> EQUAL_ROOTS     (a≠0, D=0)
 * R15         -> IMAGINARY_ROOTS (a≠0, D<0)
 */

class QuadraticEquationTest_LEDT {

    private final QuadraticEquation eq = new QuadraticEquation();

    @ParameterizedTest(name = "TC{index} => a={0}, b={1}, c={2}, expected={3}")
    @CsvSource({
        "0, 1, 1, NOT_QUADRATIC",     // R4  / TC004
        "0, 0, 1, NOT_QUADRATIC",     // R6  / TC006
        "0, 1, 0, NOT_QUADRATIC",     // R7  / TC007
        "1, 3, 1, REAL_ROOTS",        // R12 / TC012 (D = 9-4  = 5  > 0)
        "1, 2, 1, EQUAL_ROOTS",       // R14 / TC014 (D = 4-4  = 0)
        "1, 1, 1, IMAGINARY_ROOTS"    // R15 / TC015 (D = 1-4  = -3 < 0)
    })
    void testDetermineRootNature(int a, int b, int c, String expected) {
        RootNature result = eq.determineRootNature(a, b, c);
        assertEquals(RootNature.valueOf(expected), result);
    }
}