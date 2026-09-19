package sqa.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import sqa.main.DistanceConverter;
import sqa.main.WeightConverter;
import sqa.main.TemperatureConverter;
import sqa.main.UniversalConverter;

/*
 * Top-down / Depth-First Integration Testing
 * Universal Converter program
 *
 * Integration order (depth-first, left branch first):
 *   1. UniversalConverter.convert()          [root]
 *   2. DistanceConverter.convert()           [1st child - stub its own getMultiplier()]
 *   3. DistanceConverter.getMultiplier()     [leaf - real, no stub needed]
 *   4. WeightConverter.convert()             [2nd child - stub its own getMultiplier()]
 *   5. WeightConverter.getMultiplier()       [leaf - real, no stub needed]
 *   6. TemperatureConverter.convert()        [3rd child - leaf, no stub needed]
 *
 * Note: UniversalConverter.convert() instantiates DistanceConverter,
 * WeightConverter and TemperatureConverter directly (new ...()) instead of
 * receiving them through a constructor/setter. Because there is no injection
 * point, its three collaborators cannot literally be swapped for stub
 * objects from the test class. Step 1 below is therefore verified against
 * the real collaborators, and is re-verified again after each branch
 * (steps 2-6) has been integrated and proven correct on its own -
 * consistent with the depth-first idea of only trusting a branch once every
 * node underneath it has been tested.
 */
class TopDownIntegrationTest {

	// ---------- Step 1: UniversalConverter.convert() (root) ----------
	@Test
	void step1_universalConverter_delegatesToDistance() {
		UniversalConverter uc = new UniversalConverter();
		double expected = 1000.0; // 1 km -> m
		assertEquals(expected, uc.convert(1, "Distance", "kilometer", "meter"));
	}

	@Test
	void step1_universalConverter_delegatesToWeight() {
		UniversalConverter uc = new UniversalConverter();
		double expected = 2.205; // 1 kg -> lbs
		assertEquals(expected, uc.convert(1, "Weight", "kilogram", "lbs"), 0.0001);
	}

	@Test
	void step1_universalConverter_delegatesToTemperature() {
		UniversalConverter uc = new UniversalConverter();
		double expected = 32.0; // 0 C -> F (integer division 9/5 = 1 in the given code)
		assertEquals(expected, uc.convert(0, "Temperature", "C", "F"), 0.0001);
	}

	// ---------- Step 2: DistanceConverter.convert() with getMultiplier() stubbed ----------
	@Test
	void step2_distanceConverter_convert_1km_to_1000m() {
		StubDistanceConverter stub = new StubDistanceConverter();
		double expected = 1000.0;
		assertEquals(expected, stub.convert(1, "kilometer", "meter"));
	}

	@Test
	void step2_distanceConverter_convert_5km_to_5000m() {
		StubDistanceConverter stub = new StubDistanceConverter();
		double expected = 5000.0;
		assertEquals(expected, stub.convert(5, "kilometer", "meter"));
	}

	// ---------- Step 3: DistanceConverter.getMultiplier() (real, leaf) ----------
	@Test
	void step3_distanceConverter_getMultiplier_km_to_meter() {
		DistanceConverter dc = new DistanceConverter();
		assertEquals(1000.0, dc.getMultiplier("kilometer", "meter"));
	}

	@Test
	void step3_distanceConverter_getMultiplier_mile_to_km() {
		DistanceConverter dc = new DistanceConverter();
		assertEquals(1.609, dc.getMultiplier("mile", "kilometer"));
	}

	// After step 3, DistanceConverter is fully real and trusted.
	@Test
	void step3b_distanceConverter_fullyIntegrated_realBehavior() {
		DistanceConverter dc = new DistanceConverter();
		assertEquals(2000.0, dc.convert(2, "kilometer", "meter"));
	}

	// ---------- Step 4: WeightConverter.convert() with getMultiplier() stubbed ----------
	@Test
	void step4_weightConverter_convert_1kg_to_2205lbs() {
		StubWeightConverter stub = new StubWeightConverter();
		double expected = 2.205;
		assertEquals(expected, stub.convert(1, "kilogram", "lbs"), 0.0001);
	}

	@Test
	void step4_weightConverter_convert_3kg_stubbedMultiplier() {
		StubWeightConverter stub = new StubWeightConverter();
		double expected = 3 * 2.205;
		assertEquals(expected, stub.convert(3, "kilogram", "lbs"), 0.0001);
	}

	// ---------- Step 5: WeightConverter.getMultiplier() (real, leaf) ----------
	@Test
	void step5_weightConverter_getMultiplier_kg_to_lbs() {
		WeightConverter wc = new WeightConverter();
		assertEquals(2.205, wc.getMultiplier("kilogram", "lbs"));
	}

	@Test
	void step5_weightConverter_getMultiplier_kg_to_gram() {
		WeightConverter wc = new WeightConverter();
		assertEquals(1.0 / 1000, wc.getMultiplier("kilogram", "gram"));
	}

	// After step 5, WeightConverter is fully real and trusted.
	@Test
	void step5b_weightConverter_fullyIntegrated_realBehavior() {
		WeightConverter wc = new WeightConverter();
		assertEquals(4.41, wc.convert(2, "kilogram", "lbs"), 0.0001);
	}

	// ---------- Step 6: TemperatureConverter.convert() (leaf, no dependency) ----------
	@Test
	void step6_temperatureConverter_zeroCelsiusToFahrenheit() {
		TemperatureConverter tc = new TemperatureConverter();
		// NOTE: given source code uses integer division (9/5 = 1), so
		// convert(0, C, F) evaluates to 0*1 + 32 = 32.0
		assertEquals(32.0, tc.convert(0, "C", "F"), 0.0001);
	}

	@Test
	void step6_temperatureConverter_celsiusToKelvin() {
		TemperatureConverter tc = new TemperatureConverter();
		assertEquals(298.15, tc.convert(25, "C", "K"), 0.0001);
	}

	// ---------- Final: full system, all branches real ----------
	@Test
	void finalStep_fullSystem_allRealComponents() {
		UniversalConverter uc = new UniversalConverter();
		assertEquals(1000.0, uc.convert(1, "Distance", "kilometer", "meter"));
		assertEquals(2.205, uc.convert(1, "Weight", "kilogram", "lbs"), 0.0001);
		assertEquals(298.15, uc.convert(25, "Temperature", "C", "K"), 0.0001);
	}
}
