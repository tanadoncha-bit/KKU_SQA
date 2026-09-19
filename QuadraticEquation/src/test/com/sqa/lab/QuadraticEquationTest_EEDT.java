package test.com.sqa.lab;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import main.com.sqa.lab.QuadraticEquation;
import main.com.sqa.lab.RootNature;

class QuadraticEquationTest_EEDT {
	 private final QuadraticEquation eq = new QuadraticEquation();

	    @ParameterizedTest(name = "TC{index} => a={0}, b={1}, c={2}, expected={3}")
	    @CsvSource({
	        "0,   5,  3, NOT_QUADRATIC",     // Rule#1 (EC1, -)
	        "1,   5,  1, REAL_ROOTS",        // Rule#2 (EC2, EC3: D=21)
	        "1,   2,  1, EQUAL_ROOTS",       // Rule#3 (EC2, EC4: D=0)
	        "1,   1,  1, IMAGINARY_ROOTS",   // Rule#4 (EC2, EC5: D=-3)
	        "0,   100, 100, NOT_QUADRATIC",  // extra boundary: a=0, b,c=max
	        "100, 100, 100, IMAGINARY_ROOTS",// extra: D = 10000-40000 <0
	        "1,   0,  0, EQUAL_ROOTS"        // extra: D=0 minimal case
	    })
	    void testDetermineRootNature(int a, int b, int c, String expected) {
	        RootNature result = eq.determineRootNature(a, b, c);
	        assertEquals(RootNature.valueOf(expected), result);
	    }

}
