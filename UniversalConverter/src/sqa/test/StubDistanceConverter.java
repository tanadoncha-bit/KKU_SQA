package sqa.test;

import sqa.main.DistanceConverter;

/*
 * Stub for DistanceConverter, used to isolate DistanceConverter.convert()
 * from DistanceConverter.getMultiplier() during top-down integration testing.
 *
 * Fixed to always return the multiplier for 1 kilometer -> meter (1000.0),
 * regardless of the units passed in.
 */
public class StubDistanceConverter extends DistanceConverter {

	@Override
	public double getMultiplier(String fromUnit, String toUnit) {
		return 1000.0; // stubbed: km -> m
	}
}
