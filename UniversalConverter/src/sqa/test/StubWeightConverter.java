package sqa.test;

import sqa.main.WeightConverter;

/*
 * Stub for WeightConverter, used to isolate WeightConverter.convert()
 * from WeightConverter.getMultiplier() during top-down integration testing.
 *
 * Fixed to always return the multiplier for kilogram -> lbs (2.205),
 * regardless of the units passed in.
 */
public class StubWeightConverter extends WeightConverter {

	@Override
	public double getMultiplier(String fromUnit, String toUnit) {
		return 2.205; // stubbed: kilogram -> lbs
	}
}
