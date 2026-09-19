package sqa.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import sqa.main.DistanceConverter;
import sqa.main.WeightConverter;
import sqa.main.TemperatureConverter;
import sqa.main.UniversalConverter;

/*
 * Bottom-up Integration Testing
 * Universal Converter program
 *
 * Build order (leaves first, main program last):
 *   1. DistanceConverter.getMultiplier()               [driver: DistanceConverterDriver]
 *   2. WeightConverter.getMultiplier()                 [driver: WeightConverterDriver]
 *   3. TemperatureConverter.convert()                  [driver: TemperatureConverterDriver]
 *   4. DistanceConverter.convert() (+ getMultiplier)    [driver: UniversalConverterDriver]
 *   5. WeightConverter.convert() (+ getMultiplier)      [driver: UniversalConverterDriver]
 *   6. UniversalConverter.convert()                    [driver: - (top level, Driver.java is the real caller)]
 */
class BottomUpIntegrationTest {

	// ---------- Cluster 1: leaf units, built with throwaway drivers ----------
	@Test
	void step1_distanceConverter_getMultiplier_km_to_meter() {
		DistanceConverter dc = new DistanceConverter();
		assertEquals(1000.0, dc.getMultiplier("kilometer", "meter"));
	}

	@Test
	void step1_distanceConverter_getMultiplier_inch_to_mile() {
		DistanceConverter dc = new DistanceConverter();
		assertEquals(1.0 / 63360, dc.getMultiplier("inch", "mile"));
	}

	@Test
	void step2_weightConverter_getMultiplier_kg_to_lbs() {
		WeightConverter wc = new WeightConverter();
		assertEquals(2.205, wc.getMultiplier("kilogram", "lbs"));
	}

	@Test
	void step2_weightConverter_getMultiplier_gram_to_kg() {
		WeightConverter wc = new WeightConverter();
		assertEquals(1000.0, wc.getMultiplier("gram", "kilogram"));
	}

	@Test
	void step3_temperatureConverter_convert_celsius_to_kelvin() {
		TemperatureConverter tc = new TemperatureConverter();
		assertEquals(298.15, tc.convert(25, "C", "K"), 0.0001);
	}

	@Test
	void step3_temperatureConverter_convert_kelvin_to_celsius() {
		TemperatureConverter tc = new TemperatureConverter();
		assertEquals(25.0, tc.convert(298.15, "K", "C"), 0.0001);
	}

	// ---------- Cluster 2: combine convert() with its already-tested getMultiplier() ----------
	@Test
	void step4_distanceConverter_convert_2km_to_2000m() {
		DistanceConverter dc = new DistanceConverter();
		assertEquals(2000.0, dc.convert(2, "kilometer", "meter"));
	}

	@Test
	void step5_weightConverter_convert_2kg_to_4point41lbs() {
		WeightConverter wc = new WeightConverter();
		assertEquals(4.41, wc.convert(2, "kilogram", "lbs"), 0.0001);
	}

	// ---------- Top level: UniversalConverter, now fully integrated ----------
	@Test
	void step6_universalConverter_distance() {
		UniversalConverter uc = new UniversalConverter();
		assertEquals(1000.0, uc.convert(1, "Distance", "kilometer", "meter"));
	}

	@Test
	void step6_universalConverter_weight() {
		UniversalConverter uc = new UniversalConverter();
		assertEquals(2.205, uc.convert(1, "Weight", "kilogram", "lbs"), 0.0001);
	}

	@Test
	void step6_universalConverter_temperature() {
		UniversalConverter uc = new UniversalConverter();
		assertEquals(298.15, uc.convert(25, "Temperature", "C", "K"), 0.0001);
	}
}
