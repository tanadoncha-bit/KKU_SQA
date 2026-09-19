package sqa.test;

import sqa.main.DistanceConverter;

/*
 * Bottom-up driver for DistanceConverter.getMultiplier()
 * Stands in for DistanceConverter.convert() / UniversalConverter, which are
 * not yet integrated at this point in the bottom-up build order.
 */
public class DistanceConverterDriver {

	public static void main(String[] args) {
		DistanceConverter dc = new DistanceConverter();
		double multiplier = dc.getMultiplier("kilometer", "meter");
		System.out.println("getMultiplier(kilometer, meter) = " + multiplier);
	}
}
