package sqa.test;

import sqa.main.DistanceConverter;
import sqa.main.WeightConverter;

/*
 * Bottom-up driver that stands in for UniversalConverter.convert().
 * Used to exercise DistanceConverter.convert() and WeightConverter.convert()
 * (each already integrated with its own real getMultiplier()) before the
 * real UniversalConverter is brought into the build.
 */
public class UniversalConverterDriver {

	public static void main(String[] args) {
		DistanceConverter dc = new DistanceConverter();
		WeightConverter wc = new WeightConverter();

		System.out.println("Distance: " + dc.convert(1, "kilometer", "meter"));
		System.out.println("Weight: " + wc.convert(1, "kilogram", "lbs"));
	}
}
