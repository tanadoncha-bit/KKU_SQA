package sqa.test;

import sqa.main.WeightConverter;

/*
 * Bottom-up driver for WeightConverter.getMultiplier()
 * Stands in for WeightConverter.convert() / UniversalConverter, which are
 * not yet integrated at this point in the bottom-up build order.
 */
public class WeightConverterDriver {

	public static void main(String[] args) {
		WeightConverter wc = new WeightConverter();
		double multiplier = wc.getMultiplier("kilogram", "lbs");
		System.out.println("getMultiplier(kilogram, lbs) = " + multiplier);
	}
}
